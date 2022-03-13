package springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.thymeleafdemo.entity.Employee;
import springboot.thymeleafdemo.service.EmployeeService;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired  // is not severeness
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //        add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model model) {

//        get employees from db
        List<Employee> employeeList = employeeService.findAll();

//        add spring model
        model.addAttribute("employees", employeeList);
        return "/employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

//        create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

//        save employee
        employeeService.save(employee);
//        redirect to prevent dublicate submissions
        return "redirect:/employees/list";

    }
}



