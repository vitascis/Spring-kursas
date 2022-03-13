package com.springmvcdemo;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.xml.ws.Binding;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // add initBinder to convert trim input strings
    // remove leading and trailing whitespaces
    //resolve issues for our validation
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping("processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            // binding result parametras turi eiti po model atributo
            // svarbi tvarka, kitaip bus ignoruotas
            BindingResult bindingResult) {
        System.out.println("lastName: |"+customer.getLastName()+"|");
        System.out.println("binding result:"+bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }
}