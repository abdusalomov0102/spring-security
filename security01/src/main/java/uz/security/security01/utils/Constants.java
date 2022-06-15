package uz.security.security01.utils;

import uz.security.security01.model.Group;
import uz.security.security01.model.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 10.06.2022
 * Time : 16:49
 * Project Name : security01
 */

public class Constants {

    public static final String PATH_STUDENT = "/api/v1/students";

    public static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Jaxongir", "Software Engineer"),
            new Student(2, "Azamat", "Java Backend Developer"),
            new Student(3, "Sardor", "Android Developer")
    );

    public static final List<Group> GROUPS = Arrays.asList(
            new Group(1, "Jaxongir", Collections.singleton(STUDENTS.get(0))),
            new Group(2, "Azamat", Collections.singleton(STUDENTS.get(1))),
            new Group(3, "Sardor", Collections.singleton(STUDENTS.get(2)))
    );

}
