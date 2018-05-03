package com.thomas.products.fsm;

public enum State {
    OFF {
        @Override
        void exit(Aircon ac) {
            super.exit(ac);
            startFan();
        }

        @Override
        void power(Aircon ac) {
            this.exit(ac);
            ac.state = FANONLY;
            ac.state.entry(ac);
        }

        @Override
        void cool(Aircon ac) {
            System.out.println("nothing");
        }
    },
    FANONLY {
        @Override
        void power(Aircon ac) {
            this.exit(ac);
            stopFan();
            ac.state = OFF;
            ac.state.entry(ac);
        }

        @Override
        void cool(Aircon ac) {
            this.exit(ac);
            ac.state = COOL;
            ac.state.entry(ac);
        }
    },
    COOL {
        @Override
        void exit(Aircon ac) {
            super.exit(ac);
            stopCool();
        }

        @Override
        void entry(Aircon ac) {
            startCool();
            super.entry(ac);
        }

        @Override
        void power(Aircon ac) {
            this.exit(ac);
            stopFan();
            ac.state = OFF;
            ac.state.entry(ac);
        }

        @Override
        void cool(Aircon ac) {
            this.exit(ac);
            ac.state = FANONLY;
            ac.state.entry(ac);
        }
    };

    //状态模式 提取的接口  
    abstract void power(Aircon ac);

    abstract void cool(Aircon ac);

    //状态机的各种动作action methode  
    void entry(Aircon ac) {
        System.out.println("→" + ac.state.name());
    }

    void exit(Aircon ac) {
        System.out.println(ac.state.name() + "→ ");
    }

    void startCool() {
        System.out.println("start Cool");
    }

    void stopCool() {
        System.out.println("stop Cool");
    }

    void startFan() {
        System.out.println("start Fan");
    }

    void stopFan() {
        System.out.println("stop Fan");
    }
}  