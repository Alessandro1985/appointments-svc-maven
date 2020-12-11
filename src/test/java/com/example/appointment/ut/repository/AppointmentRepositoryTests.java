package com.example.appointment.ut.repository;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AppointmentRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AppointmentRepository appointmentRepository;


    @Test
    public void whenFindAllByAppointmentDateBetweenOrderByPriceAsc_thenReturnAppointmentName() {

        Appointment appointmentFirst = new Appointment("firstAppointment", LocalDate.now());
        Appointment appointmentSecond = new Appointment("secondAppointment", LocalDate.now());
        Appointment appointmentThird = new Appointment("thirdAppointment", LocalDate.now());

        entityManager.persist(appointmentFirst);
        entityManager.persist(appointmentSecond);
        entityManager.persist(appointmentThird);
        entityManager.flush();

        List<Appointment> appointments = appointmentRepository.findAllAppointments(LocalDate.of(2019, 1, 20), LocalDate.of(2019, 2, 3));

        assertThat(appointments).extracting(Appointment::getDate).containsOnly(appointmentFirst.getDate(), appointmentThird.getDate());

    }


}
