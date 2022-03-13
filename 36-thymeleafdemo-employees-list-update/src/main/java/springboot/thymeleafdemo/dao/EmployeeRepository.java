package springboot.thymeleafdemo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
//    that's it. No need t write any code

//    add method to sort by last name
    List<Employee> findAllByOrderByLastNameDesc();
}
