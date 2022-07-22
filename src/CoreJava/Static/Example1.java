package CoreJava.Static;

public class Example1 {
    class A {
        public void methodA() {
            System.out.println("A");
        }
    }

    class B extends A {
        public void methodB() {
            System.out.println("B");
        }
    }

    public void main(String[] args) {
        A a = new B();
        B b = (B) new A();

        b.methodA();
        // a.methodB();  // Compile Time error
    }
}
