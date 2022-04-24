package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDAO {

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
            int id2 = 1;
            Query<Instructor> query = session.createQuery("select  i from  Instructor i "
            + "join fetch i.courseList where i.id=:id2", Instructor.class);
//            set parameter on query
            query.setParameter("id2", id2);

//            execute query and get instructor
           Instructor instructor1 = query.getSingleResult();
            System.out.println("Instructor:" + instructor1);

            System.out.println("Courses:" + instructor1.getCourseList());

           //commit transaction
            session.getTransaction().commit();
            session.close();

//            get courses for instructor
            System.out.println("session is closed");
            System.out.println("Courses:" + instructor1.getCourseList());  // po to perkeliama y 38 eilute

            System.out.println("New entry was created successfully");
        }
        finally {
//            add clean-up code
            session.close();
            sessionFactory.close();
        }
    }
}
