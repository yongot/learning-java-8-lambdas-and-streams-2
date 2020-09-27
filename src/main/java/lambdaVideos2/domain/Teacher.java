package lambdaVideos2.domain;

import java.util.Optional;

/**
 * @author yongot
 * @created 2020-09-27 : 1:18 PM
 */
public class Teacher {
    private String name = null;
    private Optional<Student> student = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Optional<Student> getStudent() {
        return student;
    }
    public void setStudent(Optional<Student> student) {
        this.student = student;
    }

}
