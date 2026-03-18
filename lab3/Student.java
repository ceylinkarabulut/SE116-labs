public class Student {
    private String studentId;
    private String name;
    private double gpa;

    public Student(String studentId, String name, double gpa) {
        this.name = name;
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void printInfo() {
        System.out.println(getName() + " " + getStudentId() + " " + getGpa());
    }
}
