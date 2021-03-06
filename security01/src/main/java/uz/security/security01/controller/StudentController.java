package uz.security.security01.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.security.security01.model.Student;

import static uz.security.security01.utils.Constants.*;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 10.06.2022
 * Time : 16:50
 * Project Name : security01
 */

@RestController
@RequestMapping(PATH_STUDENT)
public class StudentController {

    private static final Logger logger = LogManager.getLogger(StudentController.class);

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        logger.info("An INFO Message from Student Controller!");
        logger.warn("This is get student by Id!");
        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.studentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Student " + studentId + " does not exists!"));
    }

}
