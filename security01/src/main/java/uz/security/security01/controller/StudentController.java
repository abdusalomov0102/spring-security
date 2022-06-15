package uz.security.security01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.security.security01.model.Student;

import java.util.Arrays;
import java.util.List;

import static uz.security.security01.utils.Constants.PATH_STUDENT;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 10.06.2022
 * Time : 16:50
 * Project Name : security01
 */

@RestController
@RequestMapping(PATH_STUDENT)
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jaxongir", "Software Engineer"),
            new Student(2, "Azamatjon", "Java Backend Developer"),
            new Student(3, "Sardor", "Android Developer")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.studentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + " does not exists!"));
    }

}
