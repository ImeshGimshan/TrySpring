package org.cyklon.tryoutspringboot.Service;

import org.cyklon.tryoutspringboot.DTO.CustomerDTO;
import org.cyklon.tryoutspringboot.Mapper.CustomerMapper;
import org.cyklon.tryoutspringboot.Model.Customer;
import org.cyklon.tryoutspringboot.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO){
        return customerMapper.toDTO(customerRepository.save(customerMapper.toEntity(customerDTO)));
    }

    public CustomerDTO getCustomerById(Long id){
        return customerMapper.toDTO(customerRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("Customer not found")));
    }

    public List<CustomerDTO> getCustomers(Long id){
        return customerRepository.findAll()
                .stream().map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
        customer.setFullName(customerDTO.getFullName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        return customerMapper.toDTO(customerRepository.save(customer));
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
