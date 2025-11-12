package entity;


import jakarta.persistence.*;
import model.Type;

@Entity
@Table(name = "card",
        schema = "estudiantes")

public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idcard")
    private Long id;
    // La estrategia seqence es una forma de generar identificadores
    // únicos en JPA/Hibernate usando secuencias de la base de datos.

    @Column(name = "code",
            length = 15,
            nullable = false,
            columnDefinition = "VARCHAR(15)")
    private String code;

    @Transient
    @Enumerated(EnumType.STRING)
    private Type tipo;

    @OneToOne
    @JoinColumn(name = "idstudent")
    private Student student;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getTipo() {
        return tipo;
    }

    public void setTipo(Type tipo) {
        this.tipo = tipo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", code='" + code + '\'' + ", type='" + Type.valueOf(String.valueOf(tipo)) + '\'' + '}';
    }
}


