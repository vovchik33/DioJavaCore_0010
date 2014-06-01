package edu.dio.lesson7;

public class Main {

    public static void main(String[] args) {
        ResourceDelegator delegator = new ResourceDelegator(new ResourceForDelegation());
        delegator.method1();
        delegator.method3("Hello1");
        delegator.method3("Hello2");
    }
}
