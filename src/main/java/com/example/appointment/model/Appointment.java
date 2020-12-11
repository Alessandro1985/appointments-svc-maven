package com.example.appointment.model;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
public class Appointment {

    private String appointmentDescription;
    private LocalDate date;

    public Appointment(String appointmentDescription, LocalDate date) {
        this.appointmentDescription = appointmentDescription;
        this.date = date;
    }


    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentDescription, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return Objects.equals(appointmentDescription, appointment.appointmentDescription) &&
                Objects.equals(date, appointment.date);
    }
}
