package uz.security.security01.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.security.security01.model.Student;

import java.util.List;

import static uz.security.security01.utils.Constants.*;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 14.06.2022
 * Time : 9:36
 * Project Name : security01
 */

@RestController
@RequestMapping("management" + PATH_STUDENT)
public class ManagementController {


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudent() {
        return STUDENTS
                .stream()
                .toList();
    }

    @PostMapping(path = "")
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println("Register New Student!");
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer studentId) {
        System.out.println("Delete student!");
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println("Update Student!");
        System.out.printf("%s %s%n", studentId, student);
    }

}
