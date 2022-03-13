package springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {

//        get employee from service
        Employee employee = employeeService.findById(id);

//        et employee as model attribute to prepopulate form
        model.addAttribute("employee", employee);

//        send to our form
        return "/employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}



