package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDAO {

    public static void main(String[] args) {

        // create section factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
            int studentId = 6;


//            get session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retriew student based on id: primary key
            System.out.println("Getting student with id " + studentId);

            Student student = session.get(Student.class, studentId);
            System.out.println("Get completed:" + student);

            System.out.println("updating student");
            student.setFirstName("Scooby");
            student.setLastName("Changas");
            session.getTransaction().commit();

            System.out.println("Done!");

//            new code
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            update email for all students
            System.out.println("Updating email for all students");
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
