// Course.java
import java.util.ArrayList;

public class Course {
    private int id;
    private String name;
    private String title;
    private ArrayList<Student> students;
    private int student_count;
    public static int course_num;
    

    public Course(Integer id, String name, String title) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.students = new ArrayList<Student>();
        course_num++;
    }

    public String getCourseInfo() {
        return String.format("*********************\nCourse information\n*********************\n" +
        "ID: %d\nName: %s\nTitle: %s\nStudent Count: %s\n", id, name, title, student_count);
    }

    public void addStudent(Student student) {
        students.add(student);
        student_count++;
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return student_count;
    }
}
