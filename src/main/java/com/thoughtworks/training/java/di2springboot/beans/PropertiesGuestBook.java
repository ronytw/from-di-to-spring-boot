package com.thoughtworks.training.java.di2springboot.beans;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;

public class PropertiesGuestBook implements GuestBook {
    private static final String BASE_PATH = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private final String databasePath;

    public PropertiesGuestBook(String filename) {
        databasePath = BASE_PATH + filename;
    }

    public void init() {
        System.out.println("I'm going to use " + databasePath + " for storing data");
    }

    @Override
    public Optional<LocalDateTime> findLatestVisit(String name) {
        Properties visitsDatabase = loadDatabase();

        Optional<LocalDateTime> result = getLatestVisit(visitsDatabase, name);

        saveVisitInDatabase(visitsDatabase, name);

        return result;
    }

    private void saveVisitInDatabase(Properties visitsDatabase, String name) {
        visitsDatabase.setProperty(name, LocalDateTime.now().toString());

        saveDatabase(visitsDatabase);
    }

    private void saveDatabase(Properties visitsDatabase) {
        try (OutputStream outputStream = new FileOutputStream(databasePath)) {
            visitsDatabase.store(outputStream, null);
        } catch (IOException e) {
            System.err.println("Could not store visits");
        }
    }

    private Properties loadDatabase() {
        Properties visitsDatabase = new Properties();
        try {
            try (InputStream inputStream = new FileInputStream(databasePath)) {
                visitsDatabase.load(inputStream);
            }
        } catch (IOException e) {
            // we'll just leave the DB empty...
        }
        return visitsDatabase;
    }

    private Optional<LocalDateTime> getLatestVisit(Properties visitsDatabase, String name) {
        String latestVisitString = visitsDatabase.getProperty(name);
        if (latestVisitString == null) {
            return Optional.empty();
        }

        return Optional.of(LocalDateTime.parse(latestVisitString));
    }

}
