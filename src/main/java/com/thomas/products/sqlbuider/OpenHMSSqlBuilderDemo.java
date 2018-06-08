package com.thomas.products.sqlbuider;

import com.healthmarketscience.sqlbuilder.*;
import com.healthmarketscience.sqlbuilder.dbspec.basic.*;

import java.util.Date;

public class OpenHMSSqlBuilderDemo {

    //http://openhms.sourceforge.net/sqlbuilder/index.html

    public static void main(String[] args){

        // create default schema
        DbSpec spec = new DbSpec();
//        DbSchema schema = spec.addSchema("addd");
        DbSchema schema = spec.addDefaultSchema();

        // add table with basic customer info
        DbTable customerTable = schema.addTable("customer");
        DbTable customerTable2 = schema.addTable("customer");
        DbColumn custIdCol = customerTable.addColumn("cust_id", "number", null);
        DbColumn custNameCol = customerTable.addColumn("name", "varchar", 255);
        DbColumn custNameCol2 = customerTable.addColumn("name", "varchar", 255);


        // add order table with basic order info
        DbTable orderTable = schema.addTable("order");
        DbColumn orderIdCol = orderTable.addColumn("order_id", "number", null);
        DbColumn orderCustIdCol = orderTable.addColumn("cust_id", "number", null);
        DbColumn orderTotalCol = orderTable.addColumn("total", "number", null);
        DbColumn orderDateCol = orderTable.addColumn("order_date", "timestamp", null);

        System.out.println(customerTable.getAbsoluteName()); //schema.tablename
        System.out.println(customerTable.getAlias());
        System.out.println(customerTable2.getAlias());
        System.out.println(orderTable.getAlias());
        System.out.println(custNameCol == custNameCol);
        System.out.println(custNameCol == custNameCol2);
        System.out.println(custNameCol.equals(custNameCol2));


        // add a join from the customer table to the order table (on cust_id)
        DbJoin custOrderJoin = spec.addJoin(null, "customer",
                null, "order",
                "cust_id");

        ////
        // find a customer name by id
        String query1 =
                new SelectQuery()
                        .addColumns(custNameCol).addAliasedColumn(custNameCol, "asName")
                        .addCondition(BinaryCondition.equalTo(custIdCol, 1))
                        .validate().toString();
        System.out.println(query1);

        // => SELECT t0.name FROM customer t0
        //      WHERE (t0.cust_id = 1)

        ////
        // find all the orders for a customer, given name, order by date
        String query2 =
                new SelectQuery()
                        .addAllTableColumns(orderTable)
                        .addJoin(SelectQuery.JoinType.LEFT_OUTER, customerTable, orderTable, custIdCol, orderIdCol)
//                        .addJoins(SelectQuery.JoinType.LEFT_OUTER, custOrderJoin)
                        .addCondition(BinaryCondition.equalTo(custNameCol, "bob"))
                        .addOrderings(orderDateCol)
                        .validate().toString();
        System.out.println(query2);


        // => SELECT t1.*
        //      FROM customer t0 INNER JOIN order t1 ON (t0.cust_id = t1.cust_id)
        //      WHERE (t0.name = 'bob')
        //      ORDER BY t1.order_date

        ////
        // find the totals of all orders for people named bob who spent over $100
        // this year, grouped by name
        String query3 =
                new SelectQuery()
                        .addCustomColumns(
                                custNameCol,
                                FunctionCall.sum().addColumnParams(orderTotalCol))
                        .addJoins(SelectQuery.JoinType.INNER, custOrderJoin)
                        .addCondition(BinaryCondition.like(custNameCol, "%bob%"))
                        .addCondition(BinaryCondition.greaterThan(
                                orderDateCol,
                                JdbcEscape.date(new Date(108, 0, 1)), true))
                        .addGroupings(custNameCol)
                        .addHaving(BinaryCondition.greaterThan(
                                FunctionCall.sum().addColumnParams(orderTotalCol),
                                100, false))
                        .validate().toString();
        System.out.println(query3);

        // => SELECT t0.name,SUM(t1.total)
        //      FROM customer t0 INNER JOIN order t1 ON (t0.cust_id = t1.cust_id)
        //      WHERE ((t0.name LIKE '%bob%') AND (t1.order_date >= {d '2008-01-01'}))
        //      GROUP BY t0.name
        //      HAVING (SUM(t1.total) > 100)


        ////
        // find addresses for customers from PA,NJ,DE from table:
        //   address(cust_id, street, city, state, zip)
        SelectQuery customQuery1 =
                new SelectQuery()
                        .addCustomColumns(
                                custNameCol,
                                new CustomSql("a1.street as street"),
                                new CustomSql("a1.city"),
                                new CustomSql("a1.state"),
                                new CustomSql("sum("),
                                new CustomSql("a1.zip"))
                        .addCustomJoin(SelectQuery.JoinType.INNER, customerTable,
                                "address a1",
                                BinaryCondition.equalTo(custIdCol,
                                        new CustomSql("a1.cust_id")))
                        .addCondition(new InCondition("a1.state",
                                "PA", "NJ", "DE"))
                        .addCondition(new ComboCondition(ComboCondition.Op.OR,
                                new BinaryCondition(BinaryCondition.Op.EQUAL_TO,"a1.id", 10),
                                new InCondition("a1.test_id",1, 2, 3)
                                ));
        System.out.println(customQuery1.validate().toString());

        // => SELECT t0.name,a1.street,a1.city,a1.state,a1.zip
        //      FROM customer t0 INNER JOIN address a1 ON (t0.cust_id = a1.cust_id)
        //      WHERE ('a1.state' IN ('PA','NJ','DE') )


        UnionQuery unionQuery = new UnionQuery(SetOperationQuery.Type.UNION_ALL, customQuery1, customQuery1);
//        System.out.println(unionQuery.validate().toString());


        final SelectQuery selectQuery = new SelectQuery();
        String name = "col1";
        selectQuery.addAliasedColumn(new CustomSql("t." + name), name);
        selectQuery.addCustomFromTable(new CustomSql("(" + unionQuery + ") as t"));
//        System.out.println(selectQuery);
    }




}
