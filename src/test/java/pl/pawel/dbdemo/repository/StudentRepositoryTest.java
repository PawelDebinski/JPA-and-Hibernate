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
import pl.pawel.dbdemo.entity.Passport;
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

    // Session & Session Factory
    // EntityManager % Persistence Context
    // Transaction

    @Test
    @Transactional
    public void someTest() {
        // Database Operation 1 - Retrieve student
        Student student = em.find(Student.class, 20001L);
        // Persistence Context (student)

        // Database Operation 2 - Retrieve passport
        Passport passport = student.getPassport();
        // Persistence Context (student, passport)

        // Database Operation 3 - update passport
        passport.setNumber("E123457");
        // Persistence Context (student, passport++)

        // Database Operation 4 - update student
        student.setName("Ranga - updated");
        // Persistence Context (student++, passport++)
    }

    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

}