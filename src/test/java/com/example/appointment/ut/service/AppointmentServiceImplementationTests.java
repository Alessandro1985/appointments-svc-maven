package com.example.appointment.ut.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.service.AppointmentService;
import com.example.appointment.service.AppointmentServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class AppointmentServiceImplementationTests {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
        @Bean
        public AppointmentService appointmentService() {
            return new AppointmentServiceImplementation();
        }
    }

    @Autowired
    private AppointmentService appointmentService;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @Before
    public void setUp() {
        Appointment appointmentFirst = new Appointment("firstAppointment", LocalDate.now());
        Appointment appointmentSecond = new Appointment("secondAppointment", LocalDate.now());
        Appointment appointmentThird = new Appointment("thirdAppointment", LocalDate.now());


        List<Appointment> allAppointments = Arrays.asList(appointmentFirst, appointmentSecond, appointmentThird);

        Mockito.when(appointmentRepository.findAll()).thenReturn(allAppointments);
    }


    @Test
    public void whenFindAll_thenReturnAllRecords() {
        Appointment appointmentFirst = new Appointment("firstAppointment", LocalDate.now());
        Appointment appointmentSecond = new Appointment("secondAppointment", LocalDate.now());
        Appointment appointmentThird = new Appointment("thirdAppointment", LocalDate.now());

        List<Appointment> allAppointments = appointmentService.findAll();
        verifyFindAllEmployeesIsCalledOnce();
        assertThat(allAppointments).hasSize(3).extracting(Appointment::getAppointmentDescription)
                .contains(appointmentFirst.getAppointmentDescription(), appointmentSecond.getAppointmentDescription(), appointmentThird.getAppointmentDescription());
    }

    private void verifyFindAllEmployeesIsCalledOnce() {
        Mockito.verify(appointmentRepository, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(appointmentRepository);
    }

}
