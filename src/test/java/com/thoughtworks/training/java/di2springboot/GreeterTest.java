package com.thoughtworks.training.java.di2springboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreeterTest {
    @Test
    void greetGianluca() {
        final Greeter greeter = new SimpleGreeter();

        final String greeting = greeter.greet("Gianluca");

        assertThat(greeting).contains("Hello Gianluca");
    }
}