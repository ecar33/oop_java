// Student.java
public class Student {
    private int id;
    private String name;
    public static int student_num;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
        student_num++;
    }
	
    public String toString() {
        return name;
    }

}