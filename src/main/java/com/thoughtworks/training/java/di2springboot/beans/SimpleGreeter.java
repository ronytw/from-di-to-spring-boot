package com.thoughtworks.training.java.di2springboot.beans;

public class SimpleGreeter implements Greeter {
    @Override
    public String greet(String name) {
        return "Hello " + name;
    }
}
