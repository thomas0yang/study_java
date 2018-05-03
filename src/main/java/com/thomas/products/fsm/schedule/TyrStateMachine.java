package com.thomas.products.fsm.schedule;

import org.squirrelframework.foundation.fsm.annotation.ContextInsensitive;
import org.squirrelframework.foundation.fsm.impl.AbstractStateMachine;

@ContextInsensitive
public class TyrStateMachine extends AbstractStateMachine<TyrStateMachine, TyrState, String, InstanceContext> {

    private InstanceContext context;

    void postConstruct() {
        System.out.println("TyrStateMachine PostConstruct Touched!");
    }

    private StringBuilder logger = new StringBuilder();

    public void entryInit(TyrState from, TyrState to, String event) {
        addOptionalDot();
        logger.append("entryInit");
    }
    
    public void exitInit(TyrState from, TyrState to, String event) {
        addOptionalDot();
        logger.append("exitInit");
    }
    
    public void transitFromInitToRunningOnConnected(TyrState from, TyrState to, String event) {
        addOptionalDot();
        logger.append("transitFromInitToRunningOnConnected");
        System.out.println("Transition from '"+from+"' to '"+to+"' on event '"+event+
                "' with context '"+context+"'.");
    }
    
    public void entryRunning(TyrState from, TyrState to, String event) {
        addOptionalDot();
        logger.append("entryRunning");
    }
    
    public void exitRunning(TyrState from, TyrState to, String event) {
        addOptionalDot();
        logger.append("exitRunning");
    }
    
//    public void transitFromLoadingToInServiceOnLoadSuccess(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromLoadingToInServiceOnLoadSuccess");
//    }
//
//    public void transitFromLoadingToOutOfServiceOnLoadFail(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromLoadingToOutOfServiceOnLoadFail");
//    }
//
//    public void transitFromLoadingToDisconnectedOnConnectionClosed(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromLoadingToDisconnectedOnConnectionClosed");
//    }
//
//    public void entryOutOfService(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("entryOutOfService");
//    }
//
//    public void transitFromOutOfServiceToDisconnectedOnConnectionLost(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromOutOfServiceToDisconnectedOnConnectionLost");
//    }
//
//    public void transitFromOutOfServiceToInServiceOnStartup(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromOutOfServiceToInServiceOnStartup");
//    }
//
//    public void exitOutOfService(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("exitOutOfService");
//    }
//
//    public void entryDisconnected(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("entryDisconnected");
//    }
//
//    public void transitFromDisconnectedToInServiceOnConnectionRestored(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromDisconnectedToInServiceOnConnectionRestored");
//    }
//
//    public void exitDisconnected(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("exitDisconnected");
//    }
//
//    public void entryInService(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("entryInService");
//    }
//
//    public void transitFromInServiceToOutOfServiceOnShutdown(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromInServiceToOutOfServiceOnShutdown");
//    }
//
//    public void transitFromInServiceToDisconnectedOnConnectionLost(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("transitFromInServiceToDisconnectedOnConnectionLost");
//    }
//
//    public void exitInService(TyrState from, TyrState to, String event) {
//        addOptionalDot();
//        logger.append("exitInService");
//    }
    
    private void addOptionalDot() {
        if (logger.length() > 0) {
            logger.append('.');
        }
    }
    
    public String consumeLog() {
        final String result = logger.toString();
        logger = new StringBuilder();
        return result;
    }

    public InstanceContext getContext() {
        return context;
    }

    public void setContext(InstanceContext context) {
        this.context = context;
    }

}