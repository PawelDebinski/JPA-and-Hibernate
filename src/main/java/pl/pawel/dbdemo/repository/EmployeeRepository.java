package pl.pawel.dbdemo.repository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.pawel.dbdemo.entity.Course;
import pl.pawel.dbdemo.entity.Employee;
import pl.pawel.dbdemo.entity.Review;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void insert(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> retrieveAllEmployees() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

}
