// Main.java
public class Main {
    public static void main(String[] args) {
        Course course= new Course(1, "CSCI 2830", 
                              "OO Software Engineering Fundamentals");
        for (Integer i = 1; i <= 10; i++) {
            Student student = new Student(i,"Student "+i.toString());
            course.addStudent(student);
        }


        System.out.println("Students in course 1:\n");
        for (Student student : course.getStudents()) {
            System.out.println("* " + student.toString());
        }

        System.out.println("\n");
        
        System.out.println(course.getCourseInfo());

        Course course2 = new Course(2, "ICE 1200", 
        "Introduction to Ice Cream");

        for (Integer i = 1; i <= 15; i++) {
            Student student = new Student(i,"Student "+i.toString());
            course2.addStudent(student);
        }

        System.out.println(course2.getCourseInfo());
        System.out.println(String.format("The amount of students that have been created: %d\n", Student.student_num));
        System.out.println(String.format("Total number of courses: %d\n", Course.course_num));

    }
}
