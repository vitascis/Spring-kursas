package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDAO {

    public static void main(String[] args) {

        // create section factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            // query students
            List<Student> students = session.createQuery("FROM Student").getResultList();
            // display students
            System.out.println("Display all students list");
            displayStudents(students);

//          query students lastName Urbutis
            List<Student> students1 = session.createQuery("FROM Student s Where s.lastName = 'Urbutis'").getResultList();
            System.out.println("Display student with last name Urbutis");
            displayStudents(students1);

//          query students: lastName Rainys or firstName Marius
            List<Student> students2 = session.createQuery("FROM Student s Where s.lastName = 'Rainys'" +
                    " OR s.firstName = 'Marius'").getResultList();
            System.out.println("Student with last name Rainys or first name Marius");
            displayStudents(students2);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            sessionFactory.close();
        }
    }
    public static void displayStudents(List<Student> students) {
        for (Student student: students) {
            System.out.println(student);
        }
    }
}
