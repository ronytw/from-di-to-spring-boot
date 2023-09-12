package com.thoughtworks.training.java.di2springboot;

import com.thoughtworks.training.java.di2springboot.beans.GreeterWithMemory;
import com.thoughtworks.training.java.di2springboot.beans.GuestBook;
import com.thoughtworks.training.java.di2springboot.beans.PropertiesGuestBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreeterConfiguration {
    @Bean(initMethod = "init")
    public PropertiesGuestBook getGuestBook() {
        return new PropertiesGuestBook();
    }

    @Bean
    public GreeterWithMemory getGreeter(GuestBook guestBook) {
        return new GreeterWithMemory(guestBook);
    }
}
