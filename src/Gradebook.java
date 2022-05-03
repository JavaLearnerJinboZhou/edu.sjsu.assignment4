import java.util.*;

public class Gradebook extends HashMap<Student, Character> {

    //HashMap<Student, Character> map = new HashMap<>();

    public boolean addStudent(Student student, char grade) {
        if (this.containsKey(student)) {
            return false;
        } else if (grade != 'A' && grade != 'B' && grade != 'C' && grade != 'D' && grade != 'F' && grade != 'N') {
            this.put(student, 'N');
            return true;
        } else {
            this.put(student, grade);
            return true;
        }
    }

    public boolean addStudent(Student student) {
        if (this.containsKey(student)) {
            return false;
        }
        this.addStudent(student, 'N');
        return true;
    }

    public boolean deleteStudent(int id) {
        Student student = new Student(id);
        if (this.remove(student) != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateStudent(int id, String newName) {
        Student student = new Student(id, newName);
        if (this.containsKey(student)) {
            char grade = this.remove(student);
            this.put(student, grade);
            return true;
        }
        return false;
    }

    public boolean updateGrade(int id, char newGrade) {
        Student student = new Student(id);
        if (newGrade != 'A' && newGrade != 'B' && newGrade != 'C' && newGrade != 'D' &&
                newGrade != 'F' && newGrade != 'N') {
            return this.replace(student, newGrade) != null;
        }
        return false;
    }

    public void printGrade(Comparator<Student> comparator) {
        TreeMap<Student, Character> map = new TreeMap<>(comparator);
        map.putAll(this);
        for (Map.Entry<Student, Character> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + entry.getValue());
        }
    }
}
