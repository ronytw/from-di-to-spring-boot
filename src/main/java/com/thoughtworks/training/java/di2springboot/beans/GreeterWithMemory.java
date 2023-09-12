package com.thoughtworks.training.java.di2springboot.beans;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class GreeterWithMemory implements Greeter {

    private final GuestBook guestBook;

    public GreeterWithMemory(@Autowired GuestBook guestBook) {
        this.guestBook = guestBook;
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
