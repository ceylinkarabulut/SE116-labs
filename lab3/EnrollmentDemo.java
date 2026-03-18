public class EnrollmentDemo {
    public static void main(String[] args) {
        Student s1 = new Student("123", "abc", 3);
        Student s2 = new Student("321", "xyz", 1);
        Student s3 = new Student("987", "zxc", 2);
        Student s4 = new Student("456", "qwe", 4);

        Course c1 = new Course("se116", "programming");

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
        s4.printInfo();

        c1.addStudent(s3);
        c1.addStudent(s2);
        c1.addStudent(s1);
        c1.addStudent(s4);

        c1.removeStudentByID("123");
        c1.removeStudentByID("0000");
    }
}
