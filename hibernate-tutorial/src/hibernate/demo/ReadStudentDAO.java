package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDAO {

    public static void main(String[] args) {

        // create section factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
           // create student object
            System.out.println("Creating new student object");
            Student student = new Student("Povilas", "Urbutis", "povilasurbutis@one.lt");
           // start transaction
            session.beginTransaction();
           // save student object

            System.out.println("Saving student");
            System.out.println(student);                                             // ***

            session.save(student);
           //commit transaction
            session.getTransaction().commit();

            // find out students id: primary key
            System.out.println("saved student.Generated id:" + student.getId());     // ***

            // get session and start transaction
            session = sessionFactory.getCurrentSession();                            // ***
            session.beginTransaction();                                              // ***

            // retriew student based on id: primary key
            System.out.println("Getting student with id" + student.getId());         // ***
            Student student1 = session.get(Student.class, student.getId());          // ***

            session.getTransaction().commit();                                       // ***
            System.out.println("Get completed:" + student1);                         // ***

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
