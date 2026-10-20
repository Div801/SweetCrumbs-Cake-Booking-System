
package com.sweetcrumbs.service;

import org.springframework.stereotype.Service;
import com.sweetcrumbs.model.Customer;
import com.sweetcrumbs.util.FileHandler;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerService {

    private final FileHandler fileHandler;

    public CustomerService() {
        this.fileHandler = new FileHandler();
    }

    // Register a new customer
    public void registerCustomer(Customer customer)
            throws IOException {

        List<Customer> customers =
                fileHandler.readCustomers();

        for (Customer existing : customers) {
            if (existing.getId() == customer.getId()) {
                throw new IllegalArgumentException(
                        "Customer ID already exists."
                );
            }

            if (existing.getEmail().equalsIgnoreCase(
                    customer.getEmail())) {
                throw new IllegalArgumentException(
                        "Email already registered."
                );
            }
        }

        fileHandler.addCustomer(customer);
    }

    // View all registered customers
    public List<Customer> getAllCustomers()
            throws IOException {

        return fileHandler.readCustomers();
    }

    // Search for a customer by ID
    public Customer getCustomerById(int id)
            throws IOException {

        List<Customer> customers =
                fileHandler.readCustomers();

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }
}
