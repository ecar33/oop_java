// Main.java
public class Main {
    public static void main(String[] args) {
        Course course= new Course(0, "CSCI 2830", 
                              "OO Software Engineering Fundamentals");
        for (Integer i = 1; i <= 10; i++) {
            Student student = new Student(i,"Student"+i.toString());
            course.addStudent(student);
        }

        for (Student student : course.getStudents()) {
            System.out.println(student.toString());
        }

        System.out.println(course.getCourseInfo());
    }
}
