package edu.dio.lesson7;

/**
 * Created by Vladimir V. Kravchenko on 01.06.2014.
 */
public class ResourceForDelegation {
    public void method1() {
        System.out.println("ResourceForDelegation.method1()");
        method2();
    }
    private void method2() {
        System.out.println("ResourceForDelegation.method2()");
    }
    public void method3(String param) {
        System.out.println("ResourceForDelegation.method3("+param+")");
    }
    public String method4(String name) {
        System.out.println("ResourceForDelegation.method4("+name+")");
        return name;
    }
    public void method5() {
        System.out.println("ResourceForDelegation.method5()");
    }
}
