import entity.Card;
import entity.Course;
import entity.Student;
import entity.StudentDevops;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Type;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Course course = new Course();
        course.setDescription("SXE");


        Course course2 = new Course();
        course2.setBeginDate(LocalDate.of(2025, 9, 8));
        course2.setDescription("Acceso a Datos");

//        Card tarjeta1 = new Card();
//        tarjeta1.setCode("1234");
//        tarjeta1.setTipo(Type.FP);
//        Card tarjeta2 = new Card();
//        tarjeta2.setCode("5678");
//        tarjeta2.setTipo(Type.FP);

        Student davidE = new Student();
        davidE.setName("David E");
        davidE.setPhone("651020567");
        //davidE.setCard(tarjeta1);

        Student miguelon = new Student();
        miguelon.setName("Miguelon R");
        miguelon.setPhone("604088118");
        //miguelon.setCard(tarjeta2);
//
//        tarjeta2.setStudent(miguelon);
//        tarjeta1.setStudent(davidE);
        Set<Student> students1 = course.getStudents();
        Set<Student> students2 = course2.getStudents();
        students2.add(miguelon);
        students1.add(davidE);
        students1.add(miguelon);
        course.setStudents(students1);
        course2.setStudents(students2);

        Set<Course> cursos1 = davidE.getCourses();
        cursos1.add(course);
        davidE.setCourses(cursos1);
        Set<Course> cursos2 = miguelon.getCourses();
        cursos2.add(course2);
        cursos2.add(course);
        miguelon.setCourses(cursos2);

        StudentDevops anton = new StudentDevops();
        anton.setName("Antón");
        anton.setPhone("651020569");
        anton.setLevel(6);


        em.persist(davidE);
        em.persist(miguelon);
        em.persist(anton);
        em.persist(course);
        em.persist(course2);

        System.out.println("Se han persistido los datos");

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}