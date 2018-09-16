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
        Query query = em.createQuery("Select c from Course c");
        List resultList = query.getResultList();
        logger.info("Select c from Course c -----> {}", resultList);
    }

    @Test
    public void findAll_typed() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c typed -----> {}", resultList);
    }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%50 Steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c where name like '%50 Steps'-----> {}", resultList);
    }


}