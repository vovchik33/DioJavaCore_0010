package edu.dio.lesson7;

/**
 * Created by Vladimir V. Kravchenko on 01.06.2014.
 */
public class ResourceDelegator {
    ResourceForDelegation resource;

    public ResourceDelegator(ResourceForDelegation resource) {
        this.resource = resource;
    }

    public void method1() {
        System.out.println("ResourceDelegator.method1()");
        resource.method1();
    }

    public void method3(String param) {
        System.out.println("ResourceDelegator.method3("+param+")");
        resource.method3(param);
    }

    public String method4(String name) {
        return resource.method4(name);
    }
}
