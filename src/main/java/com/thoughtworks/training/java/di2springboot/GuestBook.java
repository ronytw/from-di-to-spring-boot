package com.thoughtworks.training.java.di2springboot;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GuestBook {
    Optional<LocalDateTime> findLatestVisit(String name);
}
