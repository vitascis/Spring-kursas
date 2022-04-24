package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDAO {

    public static void main(String[] args) {

        // create  factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Instructor.class)
                                                .addAnnotatedClass(InstructorDetail.class)
                                                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
           // create  objects
Instructor instructor = new Instructor("Jonas", "Jonaitis", "jonas@one.lt");
InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/jonas", "sports");

//        associate objects
            instructor.setInstructorDetail(instructorDetail);

           // start transaction
            session.beginTransaction();

           // save object
                      session.save(instructor);

           //commit transaction
            session.getTransaction().commit();
            System.out.println("New entry was created successfully");
        }
        finally {
            sessionFactory.close();
        }
    }
}
