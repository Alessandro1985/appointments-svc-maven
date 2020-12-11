package com.example.appointment.repository;

import com.example.appointment.model.Appointment;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
public class LoadDataRepository {

    static final private Logger logger = LoggerFactory.getLogger(LoadDataRepository.class);

    @Bean
    CommandLineRunner initDatabase(AppointmentRepository appointmentRepository) {
        return args -> {
            logger.info("Preloading " + appointmentRepository.save(new Appointment("first appointment", LocalDate.now())));
            logger.info("Preloading " + appointmentRepository.save(new Appointment("second appointment", LocalDate.now())));
            logger.info("Preloading " + appointmentRepository.save(new Appointment("third appointment", LocalDate.now())));
        };
    }



}
