package uz.security.security01.controller;

import org.springframework.web.bind.annotation.*;
import uz.security.security01.model.Student;

import java.util.Arrays;
import java.util.List;

import static uz.security.security01.utils.Constants.PATH_STUDENT;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 14.06.2022
 * Time : 9:36
 * Project Name : security01
 */

@RestController
@RequestMapping("management" + PATH_STUDENT)
public class ManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jaxongir", "Software Engineer"),
            new Student(2, "Azamat", "Java Backend Developer"),
            new Student(3, "Sardor", "Android Developer")
    );

    @GetMapping
    public List<Student> getAllStudent() {
        return STUDENTS
                .stream()
                .toList();
    }

    @PostMapping(path = "")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("Register New Student!");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable Integer studentId) {
        System.out.println("Delete student!");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println("Update Student!");
        System.out.printf("%s %s%n", studentId, student);
    }

}
