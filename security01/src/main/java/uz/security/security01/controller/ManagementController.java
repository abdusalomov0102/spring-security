package uz.security.security01.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.security.security01.model.Student;

import java.util.ArrayList;
import java.util.Comparator;
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

    private static final Logger logger = LogManager.getLogger(ManagementController.class);

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudent() {
        logger.trace("A TRACE Message from Management Controller!");
        logger.debug("A DEBUG Message from Management Controller!");
        logger.info("An INFO Message from Management Controller!");
        logger.warn("A WARN Message from Management Controller!");
        logger.error("An ERROR Message from Management Controller!");
        return STUDENTS
                .stream()
                .toList();
    }

    @PostMapping(path = "")
    @PreAuthorize("hasAuthority('student:write')")
    public List<Student> registerNewStudent(@RequestBody Student student) {
        System.out.println("Register New Student!");
        Student maxStudentId = STUDENTS.stream().max(Comparator.comparing(Student::studentId)).get();
        int i = maxStudentId.studentId() + 1;
        Student newStudent = new Student(i, student.studentName(), student.description());
        List<Student> studentList = new ArrayList<>(STUDENTS);
        studentList.add(newStudent);
        System.out.println(studentList);
        return studentList
                .stream()
                .toList();
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
