package uz.security.security01.model.enums;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 13.06.2022
 * Time : 19:54
 * Project Name : security01
 */

public enum Permission {

    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }

}
