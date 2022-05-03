import java.time.LocalDate;

public class DailyAppointment extends Appointment{
    public DailyAppointment(String description, LocalDate start, LocalDate end) {
        super(description, start, end);
    }

    @Override
    public boolean occursOn(LocalDate date){
        return super.between(date);
    }
}