
package com.sweetcrumbs.util;

import com.sweetcrumbs.model.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final Path CUSTOMER_FILE =
            Path.of("data", "customers.txt");

    // Save a new customer to the text file
    public void addCustomer(Customer customer)
            throws IOException {

        Files.createDirectories(CUSTOMER_FILE.getParent());

        String line = customer.getId() + "|"
                + customer.getName() + "|"
                + customer.getEmail() + "|"
                + customer.getPhone()
                + System.lineSeparator();

        Files.writeString(
                CUSTOMER_FILE,
                line,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        );
    }

    // Read all customers from the text file
    public List<Customer> readCustomers()
            throws IOException {

        List<Customer> customers = new ArrayList<>();

        if (!Files.exists(CUSTOMER_FILE)) {
            return customers;
        }

        List<String> lines = Files.readAllLines(CUSTOMER_FILE);

        for (String line : lines) {
            String[] data = line.split("\\|", -1);

            if (data.length == 4) {
                try {
                    int id = Integer.parseInt(data[0]);

                    Customer customer = new Customer(
                            id,
                            data[1],
                            data[2],
                            data[3]
                    );

                    customers.add(customer);

                } catch (NumberFormatException e) {
                    System.out.println(
                            "Skipping invalid customer record."
                    );
                }
            }
        }

        return customers;
    }

    // Update an existing customer
    public boolean updateCustomer(Customer updatedCustomer)
            throws IOException {

        List<Customer> customers = readCustomers();
        boolean found = false;

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == updatedCustomer.getId()) {
                customers.set(i, updatedCustomer);
                found = true;
                break;
            }
        }

        if (found) {
            writeAllCustomers(customers);
        }

        return found;
    }

    // Delete a customer by ID
    public boolean deleteCustomer(int id) throws IOException {

        List<Customer> customers = readCustomers();

        boolean removed = customers.removeIf(
                customer -> customer.getId() == id
        );

        if (removed) {
            writeAllCustomers(customers);
        }

        return removed;
    }

    // Rewrite the file with the current customer records
    private void writeAllCustomers(List<Customer> customers)
            throws IOException {

        Files.createDirectories(CUSTOMER_FILE.getParent());

        List<String> lines = new ArrayList<>();

        for (Customer customer : customers) {
            String line = customer.getId() + "|"
                    + customer.getName() + "|"
                    + customer.getEmail() + "|"
                    + customer.getPhone();

            lines.add(line);
        }

        Files.write(
                CUSTOMER_FILE,
                lines,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING
        );
    }

}

