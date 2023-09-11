package com.thoughtworks.training.java.di2springboot;

import java.time.LocalDateTime;
import java.util.Optional;

public class GreeterWithMemory implements Greeter {

    private final GuestBook guestBook;

    public GreeterWithMemory() {
        guestBook = new GuestBook();
    }

    @Override
    public String greet(String name) {
        String latestVisitMessage = buildLatestVisitMessage(name);

        return "Hello " + name + ", " + latestVisitMessage;
    }

    private String buildLatestVisitMessage(String name) {
        Optional<LocalDateTime> latestVisit = guestBook.findLatestVisit(name);
        return latestVisit
                .map(t -> "last time you were here was " + t)
                .orElse("you've never been here before");
    }
}
