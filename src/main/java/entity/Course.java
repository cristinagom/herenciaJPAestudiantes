package entity;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.*;


@Entity
@Table(name = "course")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse")
    private Long id;

    @Column(name = "description",
            length = 100,
            nullable = false,
            columnDefinition = "VARCHAR(100)")
    private String description;

    @Column(name = "begindate",
            nullable = false)
    private LocalDate beginDate =  LocalDate.now();

    @Column(name = "enddate",
            nullable = true)
    private LocalDate endDate;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" + '\'' +
                "description='" + description + '\'' +
                "beginDate=" + beginDate +
                "endDate=" + endDate +
                '}';
    }
}
