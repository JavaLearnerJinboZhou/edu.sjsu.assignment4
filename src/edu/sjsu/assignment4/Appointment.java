package edu.sjsu.assignment4;

import java.time.LocalDate;

import java.util.Objects;

public abstract class Appointment implements Comparable<Appointment> {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public Appointment(String description) {
        this.description = description;
        startDate = LocalDate.MIN;
        endDate = LocalDate.MIN;
    }

    public Appointment(String description, LocalDate start, LocalDate end) {
        this.description = description;
        this.startDate = start;
        this.endDate = end;
    }

    /**
     * set the private variable description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * set the private variable start
     */
    public void setStartDate(LocalDate start) {
        this.startDate = start;
    }

    /**
     * set the private variable start
     */
    public void setEndDate(LocalDate end) {
        this.endDate = end;
    }

    /**
     * get the private variable description
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * get the private variable start(start date)
     *
     * @return LocalDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * get the private variable end(end date)
     *
     * @return LocalDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Appointment) == false) {
            return false;
        }
        Appointment that = (Appointment) obj;
        return Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription());
    }


    /**
     * compares appointments.
     * @param apmt compares startDates first, if startDates are same, then compares end Date.
     * @return description
     */
    @Override
    public int compareTo(Appointment apmt) {
        return this.description.compareTo(apmt.description);
    }

    public boolean between(LocalDate date) {
        return date.isBefore(getStartDate()) == false && date.isAfter(getEndDate()) == false;
    }

    public abstract boolean occursOn(LocalDate date);


    @Override
    public String toString() {
        return "Appointment{" + "description='" + description + '\'' + ", startDate=" + startDate +
                ", endDate=" + endDate + '}';
    }
}