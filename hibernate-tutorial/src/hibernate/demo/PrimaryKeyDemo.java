package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {

        // create section factory
        SessionFactory sessionFactory = new Configuration()
                                                .configure("hibernate.cfg.xml")
                                                .addAnnotatedClass(Student.class)
                                                .buildSessionFactory();
        // create session
        Session session = sessionFactory.getCurrentSession();
        try {
           //  create three students
            System.out.println("Creating three students object");
            Student student = new Student("Jonas", "Jonaitis", "jonasj@one.lt");
            Student student1 = new Student("Marius", "Javonis", "mariusj@one.lt");
            Student student2 = new Student("Saulius", "Rainys", "sauliusr@one.lt");

           // start transaction
            session.beginTransaction();

           // save student object
            System.out.println("Saving students");
            session.save(student);
            session.save(student1);
            session.save(student2);

           //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            sessionFactory.close();
        }
    }
}
