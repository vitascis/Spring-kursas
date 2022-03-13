package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDAO {

    public static void main(String[] args) {

        // create section factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                .buildSessionFactory();

        try {
            int studentId = 4;

//            get session and start transaction
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retriew student based on id: primary key
            System.out.println("Getting student with id " + studentId);

            Student student = session.get(Student.class, studentId);

            System.out.println("deleting student");
//            session.delete(student);
//            session.createQuery("delete from Student where id= " +studentId).executeUpdate();
            session.createQuery("delete from Student  where id=5").executeUpdate();
//            session.createQuery("delete  from Student where firstName='Scooby'").executeUpdate();
//            session.createQuery("delete from Student  where email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");


        } finally {
            sessionFactory.close();
        }
    }
}
