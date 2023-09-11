package com.thoughtworks.training.java.di2springboot;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.DURATION;

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
        final GuestBook anEmptyGuestBook = createEmptyGuestBook();
        final Greeter greeter = new GreeterWithMemory(anEmptyGuestBook);

        final String greeting = greeter.greet("Gianluca");
        assertThat(greeting).contains("Hello Gianluca");
        assertThat(greeting).contains("you've never been here before");
    }

    @Test
    void greetGianlucaAfterYesterdaysVisit() {
        final LocalDateTime yesterday = LocalDateTime.now().minus(Duration.ofDays(1));
        final GuestBook guestBookWithYesterdaysVisit = createGuestBookWithVisitOn(yesterday);
        final Greeter greeter = new GreeterWithMemory(guestBookWithYesterdaysVisit);

        final String greeting = greeter.greet("Gianluca");
        assertThat(greeting).contains("Hello Gianluca");
        assertThat(greeting).contains("last time you were here was " + yesterday);
    }

    private GuestBook createEmptyGuestBook() {
        return name -> Optional.empty();
    }

    private GuestBook createGuestBookWithVisitOn(LocalDateTime yesterday) {
        return name -> Optional.of(yesterday);
    }
}