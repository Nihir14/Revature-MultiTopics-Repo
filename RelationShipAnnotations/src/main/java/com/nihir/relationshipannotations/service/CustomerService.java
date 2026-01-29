package com.nihir.relationshipannotations.service;

import org.springframework.stereotype.Service;
import com.nihir.relationshipannotations.entity.Customer;
import com.nihir.relationshipannotations.entity.Order;
import com.nihir.relationshipannotations.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // CREATE
    // CREATE
    public Customer createCustomer(Customer customer) {

        if (customer.getOrders() != null) {
            for (Order order : customer.getOrders()) {
                order.setCustomer(customer); // 👈 CRITICAL LINE
            }
        }

        return customerRepository.save(customer);
    }


    // READ ALL
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // READ BY ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // UPDATE
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existing = getCustomerById(id);

        existing.setName(updatedCustomer.getName());

        // clear old orders
        existing.getOrders().clear();

        // add new orders
        for (Order order : updatedCustomer.getOrders()) {
            existing.addOrder(order);
        }

        return customerRepository.save(existing);
    }

    // DELETE
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}