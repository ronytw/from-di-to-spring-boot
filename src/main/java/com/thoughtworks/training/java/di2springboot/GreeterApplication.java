package com.thoughtworks.training.java.di2springboot;

import com.thoughtworks.training.java.di2springboot.beans.Greeter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GreeterApplication {

    public static void main(String[] args) {
        final BeanFactory context = createBeanFactory();

        final Greeter greeter = context.getBean(Greeter.class);

        final String greeting = greeter.greet("Marisa");
        System.out.println(greeting);
    }

    private static BeanFactory createBeanFactory() {
        return new AnnotationConfigApplicationContext(GreeterConfiguration.class);
    }
}
