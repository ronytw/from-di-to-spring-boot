package com.thoughtworks.training.java.di2springboot;

import com.thoughtworks.training.java.di2springboot.beans.GreeterWithMemory;
import com.thoughtworks.training.java.di2springboot.beans.GuestBook;
import com.thoughtworks.training.java.di2springboot.beans.PropertiesGuestBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class GreeterConfiguration {
    @Bean(initMethod = "init")
    public PropertiesGuestBook getGuestBook(Environment env) {
        final String filename = env.getProperty("guestbook.filename", "visits.properties");
        return new PropertiesGuestBook(filename);
    }

    @Bean
    public GreeterWithMemory getGreeter(GuestBook guestBook) {
        return new GreeterWithMemory(guestBook);
    }
}
