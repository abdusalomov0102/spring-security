package uz.security.security01.model;

import java.util.Set;

/**
 * Developed by Jaxongir Abdusalomov
 * Date : 15.06.2022
 * Time : 17:15
 * Project Name : security01
 */

public class Group {

    private Integer id;
    private String groupName;
    private Set<Student> students;

    public Group() {
    }

    public Group(Integer id, String groupName, Set<Student> students) {
        this.id = id;
        this.groupName = groupName;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", students=" + students +
                '}';
    }

}
