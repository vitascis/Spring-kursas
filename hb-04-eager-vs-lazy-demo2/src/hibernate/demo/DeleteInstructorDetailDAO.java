package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDAO {

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

            // start transaction
            session.beginTransaction();

//            get instructorDetail object
            int id = 7;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

//            print instructor detail
            System.out.println("instructorDetail:" + instructorDetail);

//            print assciated instuctor
            System.out.println("Associated instructor:" + instructorDetail.getInstructor());

//            now let delete instructor detail
            System.out.println("Deleting instructorDetail:" + instructorDetail);

//            remove associated object reference

//            break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);
            session.delete(instructorDetail);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Entry was updated successfully");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
//            handle connection leak issue
            session.close();
            sessionFactory.close();
        }
    }
}