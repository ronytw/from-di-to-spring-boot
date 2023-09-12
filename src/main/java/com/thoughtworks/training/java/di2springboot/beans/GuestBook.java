package com.thoughtworks.training.java.di2springboot.beans;

import java.time.LocalDateTime;
import java.util.Optional;

public interface GuestBook {
    Optional<LocalDateTime> findLatestVisit(String name);
}
