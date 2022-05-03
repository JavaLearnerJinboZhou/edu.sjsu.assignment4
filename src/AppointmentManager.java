import java.time.LocalDate;
import java.util.*;

public class AppointmentManager {
    private static Set<Appointment> set = new HashSet<>();

    public static void addAppointment(Appointment apmt) {
        if (!set.contains(apmt)) {
            set.add(apmt);
        }
    }

    public static void deleteAppointment(String des) {
        Appointment apmt = new Appointment(des) {
            @Override
            public boolean occursOn(LocalDate date) {
                return false;
            }
        };
        set.remove(apmt);
    }

    public static Set<Appointment> getSet() {
        return set;
    }

    public void viewAppointment(Set<Appointment> appointment_set) {
        for (Appointment apmt : appointment_set) {
            System.out.println(apmt);
        }
    }

    public static void main(String[] args) {
        AppointmentManager appointmentManager = new AppointmentManager();
        boolean loop = true;
        while (loop) {
            System.out.println("(a) for adding an appointment");
            System.out.println("(d) for deleting an appointment");
            System.out.println("(v) for viewing all appointments");
            System.out.println("(q) for quiting the program");
            System.out.println("Please choose an option: ");
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();

            switch (choose) {
                case "a" -> {
                    LocalDate start, end;
                    System.out.println("please enter the type (onetime, daily or monthly):");
                    String type = new Scanner(System.in).nextLine();
                    System.out.println("Please enter description");
                    String description = new Scanner(System.in).nextLine();

                    System.out.println("please enter starting date,format:yyyy-mm-dd");
                    String start_date = new Scanner(System.in).nextLine();
                    start = LocalDate.parse(start_date);

                    if (type.equals("onetime")) {
                        appointmentManager.addAppointment(new OnetimeAppointment(description, start));
                    } else {
                        System.out.println("Please enter ending date,format:yyyy-mm-dd");
                        String end_date = new Scanner(System.in).nextLine();
                        end = LocalDate.parse(end_date);
                        if (type.equals("daily")) {
                            appointmentManager.addAppointment(new DailyAppointment(description, start, end));
                        } else {
                            appointmentManager.addAppointment(new MonthlyAppointment(description, start, end));
                        }
                    }
                    System.out.println("Appointment added!");
                }

                case "d" -> {
                    System.out.println("Please enter the description of the appointment you want to delete");
                    String del = new Scanner(System.in).nextLine();
                    appointmentManager.deleteAppointment(del);
                }
                case "v" -> {
                    appointmentManager.viewAppointment(appointmentManager.getSet());
                }
                case "q" -> {
                    loop = false;
                    System.out.println("Thank you for using the program. Have nice day!");
                }
                default -> {
                    System.out.println("Sorry, wrong option!" + '\n' + "Please enter again:");
                }
            }
        }
    }
}

