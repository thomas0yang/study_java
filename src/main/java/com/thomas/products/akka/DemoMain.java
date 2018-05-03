package com.thomas.products.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;  
import akka.actor.Props;
import akka.actor.UntypedActor;

public class DemoMain {  
      
    public static void main(String[] args) {  
        ActorSystem system = ActorSystem.create("demo1");  
        ActorRef actor1 = system.actorOf(Props.create(Actor01.class));
        ActorRef actor2 = system.actorOf(Props.create(Actor02.class));
        actor1.tell("hello akka!!", actor2); //actor2告诉actor1 "hello akka!!"
        system.shutdown();//
    }
}

class Actor01 extends UntypedActor {

    @Override
    public void onReceive(Object arg0) throws Exception {
        if(arg0 instanceof String)
            System.err.println("1-------------->"+arg0);
    }

}

class Actor02 extends UntypedActor {

    @Override
    public void onReceive(Object arg0) throws Exception {
        if(arg0 instanceof String)
            System.err.println("2-------------->"+arg0);
    }

}