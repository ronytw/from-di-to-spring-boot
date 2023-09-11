package com.thoughtworks.training.java.di2springboot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GreeterTest {
    @Test
    void greetGianluca() {
        final Greeter greeter = new SimpleGreeter();

        final String greeting = greeter.greet("Gianluca");

        System.out.println(greeting);
        assertThat(greeting).contains("Hello Gianluca");
    }

    @Test
    void greetGianlucaForTheFirstTime() {
        final GuestBook guestBook = new PropertiesGuestBook();
        final Greeter greeter = new GreeterWithMemory(guestBook);

        final String greeting = greeter.greet("Gianluca");
        assertThat(greeting).contains("Hello Gianluca");
    }
}