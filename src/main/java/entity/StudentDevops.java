package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "student_devops")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue(value = "D")
@PrimaryKeyJoinColumn(name = "idstudent")
public class StudentDevops extends Student{
    @Column(name = "level")
    private int level;
    @Column(name = "tools")
    private String tools;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }
}
