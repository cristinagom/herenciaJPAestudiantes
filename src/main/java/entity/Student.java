package entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idstudent")
    private Long id;

    @Column(name = "name",
            length = 128,
            nullable = false,
            columnDefinition = "VARCHAR(128)")
    private String name;

    @Column(name = "identification",
            length = 9,
            columnDefinition = "VARCHAR(9)")
    private String dni;

    @Column(name = "phone",
            length = 9,
            nullable = false,
            columnDefinition = "VARCHAR(9)")
    private String phone;

    @OneToOne
    @JoinColumn(name = "idcard")
    private Card card;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "idstudent"),
            inverseJoinColumns = @JoinColumn(name = "idcurse"))
    private Set<Course> courses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + '\'' +
                " name='" + name + '\'' +
                " dni='" + dni + '\'' +
                " phone='" + phone + '\'' +
                '}';
    }
}
