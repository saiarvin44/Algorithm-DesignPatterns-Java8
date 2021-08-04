package CoreJava.multithreading.Synchronization;

public class Example1 {
    private String objName;

    public Example1(String objName) {
        this.objName = objName;
    }

    synchronized public void methodOne() {
        System.out.println("Method One called from Object : " + this.objName + " from thread name : " + Thread.currentThread().getName());
    }


    synchronized public void methodTwo() {
        System.out.println("Method Two called from Object : " + this.objName + " from thread name : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Example1 o1 = new Example1("object1"), o2 = new Example1("object2");

        // Same thread calling both functions from same objects
        Thread t1 = new Thread(() -> {
            o1.methodOne();
            o1.methodTwo();
        });
        t1.start();

        // Same thread calling both functions from different objects
        Thread t2 = new Thread(() -> {
            o1.methodOne();
            o2.methodTwo();
        });
        t2.start();

        // Different threads calling both functions from same objects
        Thread t3 = new Thread(() -> {
            o1.methodOne();
        });
        t3.start();
        Thread t4 = new Thread(() -> {
            o1.methodTwo();
        });
        t4.start();

        // Different threads calling both functions from different objects
        Thread t5 = new Thread(() -> {
            o1.methodOne();
        });
        t5.start();
        Thread t6 = new Thread(() -> {
            o2.methodTwo();
        });
        t6.start();

    }
}
