package springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.thymeleafdemo.model.Employee;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //    load employee data
    private List<Employee> employeeList;

    @PostConstruct
    private void loadData() {
//        create employees
        Employee employee = new Employee(1, "Saulius", "Vasaris", "savas@gmail.com");
        Employee employee1 = new Employee(2, "Ieva", "Liepaite", "liepa@Yahoo.com");
        Employee employee2 = new Employee(3, "Marius", "Gruodis", "gruma@Ggmail.com");

//       create list
        employeeList = new ArrayList<>();

//        add to list
        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);

//        add mapping for "/list"
    }
    @GetMapping("/list")
    public String listEmployees(Model model) {

//        add spring model
        model.addAttribute("employees", employeeList);
        return "list-employees";
    }
}



