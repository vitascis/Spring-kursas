package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDAO {

    public static void main(String[] args) {

        // create  factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Instructor.class)
                                                .addAnnotatedClass(InstructorDetail.class)
                                                .addAnnotatedClass(Course.class)
                                                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
           // create  objects
Instructor instructor = new Instructor("Jonas", "Jonaitis", "jonas@one.lt");
InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/jonas", "sports");


            instructor.setInstructorDetail(instructorDetail);

           // start transaction
            session.beginTransaction();

//            get instructor from db
            int id = 1;

            Instructor instructor1 = session.get(Instructor.class,id);

//            create some courses
            Course course = new Course("Spring");
            Course course1 = new Course("DB");
            Course course2 = new Course("Java");

//            add courses to instructor
            instructor1.add(course);
            instructor1.add(course1);
            instructor1.add(course2);

//            save courses
            session.save(course);
            session.save(course1);
            session.save(course2);
           //commit transaction
            session.getTransaction().commit();
            System.out.println("New entry was created successfully");
        }
        finally {
//            add clean-up code
            session.close();
            sessionFactory.close();
        }
    }
}
