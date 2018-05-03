package com.thomas.products.cron;

import com.cronutils.descriptor.CronDescriptor;
import com.cronutils.model.Cron;
import com.cronutils.model.CronType;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.definition.CronDefinitionBuilder;
import com.cronutils.model.time.ExecutionTime;
import com.cronutils.parser.CronParser;

import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * Created by yangyang32 on 16/11/24.
 */
public class CrontabTest {

    public static void main(String[] args) {
        //get a predefined instance
        CronDefinition cronDefinition =
                CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ);

        //create a parser based on provided definition
        CronParser parser = new CronParser(cronDefinition);
        Cron quartzCron = parser.parse("* * 10 * * ?");

        //create a descriptor for a specific Locale
        CronDescriptor descriptor = CronDescriptor.instance(Locale.UK);

        //parse some expression and ask descriptor for description
        String description = descriptor.describe(parser.parse("*/45 * * * * ?"));
        System.out.println(description);
        //description will be: "every 45 seconds"

        //validate expression
        quartzCron.validate();

        ZonedDateTime now = ZonedDateTime.now();
        ExecutionTime executionTime = ExecutionTime.forCron(quartzCron);
        ZonedDateTime zonedDateTime = executionTime.nextExecution(now);
        System.out.println("next excute time :" + zonedDateTime);
//        Date from = Date.from(zonedDateTime.toInstant());


        System.out.println(
                String.format(
                        "Given the Quartz cron '%s' and reference date '%s', last execution was '%s'",
                        quartzCron.asString(), now, executionTime.lastExecution(now)
                )
        );

    }
}
