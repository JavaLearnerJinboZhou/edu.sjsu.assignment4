import java.util.Objects;

public class Student {
    private int id;
    private String name;

    public Student(int id) {
        this.id = id;
        name = "Unnamed";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
