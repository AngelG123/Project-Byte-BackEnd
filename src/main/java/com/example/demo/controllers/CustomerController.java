package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CustomerService;
import com.example.demo.models.Customer;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    Map<String,String> errors;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Customer> getAll(){
        return customerService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Cacheable(value = "customer",key = "#id")
    Customer get(@PathVariable Long id){
        return customerService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<Object> register(@RequestBody @Valid Customer customer, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            errors = new HashMap<>();
            for(FieldError error:bindingResult.getFieldErrors()){
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(customerService.register(customer), HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CachePut(value = "customer",key = "#id")
    Customer update(@RequestBody Customer customer){
        return customerService.update(customer);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CacheEvict(value = "customer", allEntries = true)
    int delete(@PathVariable Long id){
        return customerService.delete(id);
    }

    @RequestMapping(value = "/page={pagina}", method = RequestMethod.GET)
    List<Customer> paginate(@PathVariable int page){
        return customerService.paginate(page);
    }
    
}
