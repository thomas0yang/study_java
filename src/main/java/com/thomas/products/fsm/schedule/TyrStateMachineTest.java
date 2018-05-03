package com.thomas.products.fsm.schedule;

import com.thomas.products.fsm.squirrel.ATMState;
import com.thomas.products.fsm.squirrel.ATMStateMachine;
import org.junit.*;
import org.squirrelframework.foundation.component.SquirrelPostProcessorProvider;
import org.squirrelframework.foundation.component.SquirrelProvider;
import org.squirrelframework.foundation.fsm.*;

public class TyrStateMachineTest {
    
    @AfterClass
    public static void afterTest() {
        ConverterProvider.INSTANCE.clearRegistry();
        SquirrelPostProcessorProvider.getInstance().clearRegistry();
    }
    
    private TyrStateMachine stateMachine;
    
    @Before
    public void setup() {
        StateMachineBuilder<TyrStateMachine, TyrState, String, InstanceContext> builder = StateMachineBuilderFactory.create(
                TyrStateMachine.class, TyrState.class, String.class, InstanceContext.class);
        builder.externalTransition().from(TyrState.Init).to(TyrState.Running).on("Connected").when(new Condition<InstanceContext>() {
            @Override
            public boolean isSatisfied(InstanceContext context) {
                return context!=null && context.getTaskInstanceId()<1;
            }

            @Override
            public String name() {
                return "MyCondition1";
            }
        });
        builder.externalTransition().from(TyrState.Init).to(TyrState.Success).on("Connected").when(new Condition<InstanceContext>() {
            @Override
            public boolean isSatisfied(InstanceContext context) {
                return context!=null && context.getTaskInstanceId()>1;
            }

            @Override
            public String name() {
                return "MyCondition2";
            }
        });
//        builder.externalTransition().from(ATMState.Loading).to(ATMState.Disconnected).on("ConnectionClosed");
//        builder.externalTransition().from(ATMState.Loading).to(ATMState.InService).on("LoadSuccess");
//        builder.externalTransition().from(ATMState.Loading).to(ATMState.OutOfService).on("LoadFail");
//        builder.externalTransition().from(ATMState.OutOfService).to(ATMState.Disconnected).on("ConnectionLost");
//        builder.externalTransition().from(ATMState.OutOfService).to(ATMState.InService).on("Startup");
//        builder.externalTransition().from(ATMState.InService).to(ATMState.OutOfService).on("Shutdown");
//        builder.externalTransition().from(ATMState.InService).to(ATMState.Disconnected).on("ConnectionLost");
//        builder.externalTransition().from(ATMState.Disconnected).to(ATMState.InService).on("ConnectionRestored");
        
        stateMachine = builder.newStateMachine(TyrState.Init);
        stateMachine.setContext(new InstanceContext(1, 2));
    }
    
    @After
    public void teardown() {
        if(stateMachine!=null && stateMachine.getStatus()!=StateMachineStatus.TERMINATED) {
            stateMachine.terminate(null);
        }
    }
    
    @Test
    public void testIdelToInService() {
        stateMachine.start();
//        Assert.assertEquals(stateMachine.consumeLog(), "entryInit");
//        Assert.assertEquals(stateMachine.getCurrentState(), TyrState.Init);

//        System.out.println(stateMachine.getCurrentState());
//        stateMachine.fire("LoadSuccess");
//        System.out.println(stateMachine.getCurrentState());


        stateMachine.fire("Connected", stateMachine.getContext());
//        Assert.assertEquals(stateMachine.consumeLog(), "exitInit.transitFromInitToRunningOnConnected.entryRunning");
//        Assert.assertEquals(stateMachine.getCurrentState(), TyrState.Running);
        System.out.println(stateMachine.getCurrentState());
        
//        stateMachine.fire("LoadSuccess");
//        Assert.assertEquals(stateMachine.consumeLog(), "exitLoading.transitFromLoadingToInServiceOnLoadSuccess.entryInService" );
//        Assert.assertEquals(stateMachine.getCurrentState(), ATMState.InService);
//
//        stateMachine.fire("Shutdown");
//        Assert.assertEquals(stateMachine.consumeLog(), "exitInService.transitFromInServiceToOutOfServiceOnShutdown.entryOutOfService");
//        Assert.assertEquals(stateMachine.getCurrentState(), ATMState.OutOfService);
//
//        stateMachine.fire("ConnectionLost");
//        Assert.assertEquals(stateMachine.consumeLog(), "exitOutOfService.transitFromOutOfServiceToDisconnectedOnConnectionLost.entryDisconnected");
//        Assert.assertEquals(stateMachine.getCurrentState(), ATMState.Disconnected);
//
//        stateMachine.fire("ConnectionRestored");
//        Assert.assertEquals(stateMachine.consumeLog(), "exitDisconnected.transitFromDisconnectedToInServiceOnConnectionRestored.entryInService");
//        Assert.assertEquals(stateMachine.getCurrentState(), ATMState.InService);
    }
    
    @Test
    public void exportAndImportATMStateMachine() {
        SCXMLVisitor visitor = SquirrelProvider.getInstance().newInstance(SCXMLVisitor.class);
        stateMachine.accept(visitor);
        // visitor.convertSCXMLFile("ATMStateMachine", true);
        String xmlDef = visitor.getScxml(false);
        UntypedStateMachineBuilder builder = new UntypedStateMachineImporter().importDefinition(xmlDef);
        
        ATMStateMachine stateMachine = builder.newAnyStateMachine(ATMState.Idle);
        stateMachine.start();
        Assert.assertEquals(stateMachine.consumeLog(), "entryIdle");
        Assert.assertEquals(stateMachine.getCurrentState(), ATMState.Idle);
        
        stateMachine.fire("Connected");
        Assert.assertEquals(stateMachine.consumeLog(), "exitIdle.transitFromIdleToLoadingOnConnected.entryLoading");
        Assert.assertEquals(stateMachine.getCurrentState(), ATMState.Loading);
    }

}