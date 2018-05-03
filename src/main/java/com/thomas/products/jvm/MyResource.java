package com.thomas.products.jvm;

public class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("资源被关闭了！");
    }

    public void doSomething() {
        System.out.println("干活了！");
//        throw new RuntimeException("test");
    }


    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    private static void test1() {
        try {
            MyResource mr = new MyResource();
            mr.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 在try块的末尾，无论是正常结束还是抛出了异常，out与in资源都会自动调用close()方法。
     */
    private static void test2() {
        try(MyResource mr = new MyResource()) {
            mr.doSomething();
            Thread.currentThread().sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 此外，与之前test2不同的是mr.close()与mr2.close()保证会执行
     * (在之前的示例中，一旦mr.close()方法抛出了异常，随后的mr2.close()方法就没有机会执行了)。
     */
    private static void test3() {
        try
            (MyResource mr = new MyResource();
             MyResource mr2 = new MyResource();) {
            mr.doSomething();
            mr2.doSomething(); //关闭顺序与代码循序相反，优先彻底关闭
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 一种更加精炼的写法
     * @throws Exception
     */
    private static void test4() throws Exception {
        try (MyResource mr = new MyResource()) {
            mr.doSomething();
        }
    }
}