package uz.security.security01.model.enums;

import com.google.common.collect.Sets;

import java.util.Set;

import static uz.security.security01.model.enums.Permission.*;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 13.06.2022
 * Time : 19:53
 * Project Name : security01
 */

public enum Roles {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<Permission> permissions;

    Roles(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

}
