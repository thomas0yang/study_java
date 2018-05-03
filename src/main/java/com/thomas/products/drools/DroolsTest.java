package com.thomas.products.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {
 
    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

//            // load up the knowledge base 2
//            KieServices kieServices = KieServices.Factory.get();
//            KieFileSystem kfs = kieServices.newKieFileSystem();
//            // for each DRL file, referenced by a plain old path name:
//            FileInputStream fis = new FileInputStream("/Users/yangyang32/IdeaProjects/study_java/src/main/resources/drools/Sample.drl");
//            kfs.write("src/main/resources/drools/Sample.drl",
//                    kieServices.getResources().newInputStreamResource( fis ) );
//
//            KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
//            Results results = kieBuilder.getResults();
//            KieContainer kContainer =
//                    kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );
//            KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}