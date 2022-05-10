package edu.sjsu.assignment4;

import java.time.LocalDate;

public class MonthlyAppointment extends Appointment{
    public MonthlyAppointment(String description, LocalDate start, LocalDate end) {
        super(description, start, end);
    }

    @Override
    public boolean occursOn(LocalDate date){
        return super.between(date)&&date.getDayOfMonth()==getStartDate().getDayOfMonth();

    }
}