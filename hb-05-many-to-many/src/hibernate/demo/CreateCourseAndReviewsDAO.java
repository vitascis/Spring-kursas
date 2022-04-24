package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDAO {

    public static void main(String[] args) {

        // create  factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Instructor.class)
                                                .addAnnotatedClass(InstructorDetail.class)
                                                .addAnnotatedClass(Course.class)
                                                .addAnnotatedClass(Review.class)
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

//            create
            Course course = new Course("HTML");

//            add some reviews
            course.addReview(new Review("Super course"));
            course.addReview(new Review("Nice course"));
            course.addReview(new Review("Dissapointing course, waisting time"));

//            save course and leverage cascade ALL
            System.out.println("Saving course" + course);
            System.out.println("Saving reviews" + course.getReviewList());
            session.save(course);
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
