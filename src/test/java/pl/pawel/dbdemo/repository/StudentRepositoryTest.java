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
import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retriveveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

}