package app;

public class HelloWorld {

    private void sayHello(String name) {
        System.out.println("Hello my name is " + name);
    }

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        hw.sayHello("Vijesh");
    }
}