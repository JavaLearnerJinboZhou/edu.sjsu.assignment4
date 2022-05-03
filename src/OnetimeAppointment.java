import java.time.LocalDate;

public class OnetimeAppointment extends Appointment{
    public OnetimeAppointment(String description, LocalDate start) {
        super(description, start, start);
    }

    @Override
    public boolean occursOn(LocalDate date){
        return date.equals(getStartDate());
    }
}