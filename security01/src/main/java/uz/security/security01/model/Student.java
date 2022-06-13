package uz.security.security01.model;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 10.06.2022
 * Time : 16:53
 * Project Name : security01
 */

public class Student {

    private final Integer studentId;
    private final String studentName;

    public Student(Integer studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

}
