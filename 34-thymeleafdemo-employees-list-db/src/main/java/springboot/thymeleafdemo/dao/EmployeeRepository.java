package springboot.thymeleafdemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    that's it. No need t write any code
}
