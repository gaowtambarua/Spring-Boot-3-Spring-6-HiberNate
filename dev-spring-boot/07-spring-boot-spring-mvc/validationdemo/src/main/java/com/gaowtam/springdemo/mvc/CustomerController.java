package com.gaowtam.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    // add an initbider ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation
    @InitBinder
    public void innitBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @GetMapping("/")
    public String showForm(Model theModel)
    {
        theModel.addAttribute("customer",new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult thBindingResult
    )
    {
        System.out.println("Last name: |"+theCustomer.getLastName()+"|");

            if(thBindingResult.hasErrors())
        {
            return "customer-form";
        }
        else {
            return "customer-confirmation";
        }
    }
}
