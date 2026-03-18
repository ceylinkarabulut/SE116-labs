import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private ArrayList<Student> enrolledStudents;
    private int count; // student count

    public Course(String courseCode, String courseName) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.enrolledStudents = new ArrayList<>();
        this.count = 0;
    }

    public void addStudent(Student s) {
        enrolledStudents.add(s);
        count = enrolledStudents.size();
    }

    public void displayEnrolledStudents() {
        for (Student s : enrolledStudents) {
            s.printInfo();
        }
    }

    public void removeStudentByID(String id) {
        boolean removed = false;
        for (int i = 0; i < enrolledStudents.size(); i++) {
            if (enrolledStudents.get(i).getStudentId().equals(id)) {
                enrolledStudents.remove(i);
                System.out.println("student " + id + " removed.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("student not found");
        }
    }
}
