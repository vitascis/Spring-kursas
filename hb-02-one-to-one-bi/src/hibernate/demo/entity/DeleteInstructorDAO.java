package hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDAO {

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

//          get instructor by primary key/id
            int id = 7;
            Instructor instructor2 = session.get(Instructor.class, id);
            System.out.println("found instructor:" + instructor2);

//            delete instructor
            if(instructor2 != null) {
                System.out.println("deleting:" + instructor2);
//                will also delete associated detail objects, because of cascade type.ALL (class instructor eil.23)
                session.delete(instructor2);
            }

           //commit transaction
            session.getTransaction().commit();
            System.out.println("Entry was updated successfully");
        }
        finally {
            sessionFactory.close();
        }
    }
}
