package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDAO {

    public static void main(String[] args) {

        // create  factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Instructor.class)
                                                .addAnnotatedClass(InstructorDetail.class)
                                                .addAnnotatedClass(Course.class)
                                                .addAnnotatedClass(Review.class)
                                                .addAnnotatedClass(Student.class)
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

//           save course
            System.out.println("Saving course:" + course);
            session.save(course);
            System.out.println("Saved course:" + course);

//            create students
            Student student = new Student("Povilas", "Makas", "poma@asd.dfg");
            Student student1 = new Student("Diana", "Brown", "diabro@gjh.jlk");

//            add students to the course
            course.addStudent(student);
            course.addStudent(student1);

//            save students
            System.out.println("Saving students");
            session.save(student);
            session.save(student1);
            System.out.println("Saved students:" + course.getStudentList());



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
