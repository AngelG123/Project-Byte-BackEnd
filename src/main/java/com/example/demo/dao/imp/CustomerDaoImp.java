package com.example.demo.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.CustomerDao;
import com.example.demo.models.Customer;

@Transactional
@Repository
public class CustomerDaoImp implements CustomerDao{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Customer> getAll() {
        List<Customer> resultado = null;

        try{
            String hql = "FROM Customer ";
            resultado = entityManager.createQuery(hql).getResultList();
        }
        catch(Exception ex){ System.out.print(ex.getMessage()); }
        
        return resultado;      
    }

    @Transactional
    @Override
    public Customer get(Long id) {
        Customer resultado = null;

        try{ resultado = entityManager.find(Customer.class, id); }
        catch(Exception ex){ System.out.print(ex.getMessage()); }

        return resultado;
    }

    @Transactional
    @Override
    public Customer register(Customer customer) {
        Customer resultado = null;

        try{ resultado = entityManager.merge(customer); }
        catch(Exception ex){ System.out.print(ex.getMessage()); }

        return resultado;
    }

    @Transactional
    @Override
    public Customer update(Customer customer) {
        Customer resultado = null;

        try{ resultado = entityManager.merge(customer); }
        catch(Exception ex){ System.out.print(ex.getMessage()); }

        return resultado;
    }

    @Transactional
    @Override
    public int delete(Long id) {
        int resultado = 0;

        try{
            Customer customer = get(id);
            entityManager.remove(customer);
            resultado = 1;
        }catch(Exception ex){ System.out.println(ex.getMessage()); }

        return resultado;
    }

    @Override
    public List<Customer> paginate(int page) {
        List<Customer> resultado = null;
        try{
            String hql = "FROM Customer ";
            resultado =  entityManager.createQuery(hql).setFirstResult(page*5).setMaxResults(5).getResultList();
        }
        catch(Exception ex){ System.out.print(ex.getMessage()); }
        return resultado;
    }
    
}
