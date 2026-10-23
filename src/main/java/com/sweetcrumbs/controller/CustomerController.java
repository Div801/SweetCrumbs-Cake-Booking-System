
package com.sweetcrumbs.controller;

import com.sweetcrumbs.model.Customer;
import com.sweetcrumbs.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/customers")
    public String showCustomers(Model model)
            throws IOException {

        List<Customer> customers =
                customerService.getAllCustomers();

        model.addAttribute("customers", customers);

        return "customers";
    }

    @GetMapping("/customers/new")
    public String showRegistrationForm() {
        return "customer-form";
    }

    @PostMapping("/customers/save")
    public String saveCustomer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            RedirectAttributes redirectAttributes)
            throws IOException {

        List<Customer> customers =
                customerService.getAllCustomers();

        int nextId = 1;

        for (Customer customer : customers) {
            if (customer.getId() >= nextId) {
                nextId = customer.getId() + 1;
            }
        }

        Customer customer = new Customer(
                nextId, name, email, phone);

        try {
            customerService.registerCustomer(customer);

            redirectAttributes.addFlashAttribute(
                    "message",
                    "Customer registered successfully!"
            );

            return "redirect:/customers";

        } catch (IllegalArgumentException e) {

            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "This email is already registered. Please use another email."
            );

            return "redirect:/customers/new";
        }
    }


    // Open the edit form for an existing customer
    @GetMapping("/customers/edit")
    public String editCustomer(
            @RequestParam int id,
            Model model) throws IOException {

        List<Customer> customers =
                customerService.getAllCustomers();

        Customer customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);

        if (customer == null) {
            return "redirect:/customers";
        }

        model.addAttribute("customer", customer);

        return "customer-edit";
    }

    // Save the updated customer details
    @PostMapping("/customers/update")
    public String updateCustomer(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            RedirectAttributes redirectAttributes)
            throws IOException {

        Customer customer = new Customer(
                id, name, email, phone);

        try {
            customerService.updateCustomer(customer);

            redirectAttributes.addFlashAttribute(
                    "message",
                    "Customer updated successfully!");

        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    e.getMessage());

            return "redirect:/customers/edit?id=" + id;
        }

        return "redirect:/customers";
    }

    // Delete a customer
    @PostMapping("/customers/delete")
    public String deleteCustomer(
            @RequestParam int id,
            RedirectAttributes redirectAttributes)
            throws IOException {

        customerService.deleteCustomer(id);

        redirectAttributes.addFlashAttribute(
                "message",
                "Customer deleted successfully!");

        return "redirect:/customers";
    }

}

