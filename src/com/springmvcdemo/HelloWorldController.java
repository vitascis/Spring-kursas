package com.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")               // del konflikto sprendimo su SillyController
public class HelloWorldController {

    //    need controller method to show initial html form
    @RequestMapping("/showForm")
    public String showForm() {

        return "helloworld-form";
    }
//raktai tiek backend'ui tiek frontend'ui turi buti identiski, nes tarpusavyje bendrauja raktu pagalba

    //  reikia Controller metodo html formos apdorojimui
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // pideti nauja Controller metoda, duomenims nuskaityti ir prideti y moduly
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        // nuskaityti uzskaitos parametra is html formos
        String name = request.getParameter("studentName");
        // konvertuoti duomenis y didziasias raides
        name = name.toUpperCase();
        // sukurti zinute
        String result = "Eee!" + name;
        // zinutes pridejimas modeliui
        model.addAttribute("message", result);  // raktas-reiksme (message result
        return "helloworld";
    }

    // pideti nauja Controller metoda, duomenims nuskaityti ir prideti y moduly
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String name,
            Model model) {

        // nuskaityti uzskaitos parametra is html formos        istrinama, kaip ir 49 eil.
 //       String name = request.getParameter("studentName"); istrinama, nes atitinka 45 eil.
        // konvertuoti duomenis y didziasias raides
        name = name.toUpperCase();
        // sukurti zinute
        String result = "Labas, mano drauge!" + name;               // pakeiciama vietoje Eee!
        // zinutes pridejimas modeliui
        model.addAttribute("message", result);  // raktas-reiksme (message result
        return "helloworld";
    }
}


















    // prideti nauja metoda, kad galetum ...
//    @RequestMapping("processFormVersionThree")
//    public String processForVersionThree(
//            @RequestParam("studentName") String name,
//        Model model


        // nuskaityti uzskaitos parametra is html formos
//        String name = request.getParameter ("studentName");
//        name = name.toUpperCase(Locale.ROOT);
        // konvertuoti duomenis y didziasias raides
//        name = name.toUpperCase(Locale.ROOT);
        // sukurti zinute
//        String result = "Eee!" + name;
        // zinutes pridejimas modeliui
//        model.addAttribute("message", result);  // raktas-reiksme (message result
 //       return "helloworld";

