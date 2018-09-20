package pl.pawel.dbdemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pawel.dbdemo.entity.Course;
import pl.pawel.dbdemo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void findAll_basic() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("Select c from Course c -----> {}", resultList);
    }

    @Test
    public void findAll_typed() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c typed -----> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_50_Step_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c where name like '%50 Steps'-----> {}", resultList);
    }

    @Test
    public void jpql_courses_without_students() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_with_atleast_2_students() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_courses_order_by_students() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    @Test
    public void jpql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();

        logger.info("Results -> {}", resultList);
    }

    // like
    // BETWEEN 100 AND 1000
    // IS NULL
    // upper, lower, trim, length


}