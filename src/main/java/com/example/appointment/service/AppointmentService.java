package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import java.util.List;

public interface AppointmentService {


    List<Appointment> findAll();

    Appointment create(Appointment appointment);

}
