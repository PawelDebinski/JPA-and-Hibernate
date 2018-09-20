package pl.pawel.dbdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pawel.dbdemo.entity.*;
import pl.pawel.dbdemo.repository.CourseRepository;
import pl.pawel.dbdemo.repository.EmployeeRepository;
import pl.pawel.dbdemo.repository.StudentRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DbdemoApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DbdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepository.saveStudentWithPassport();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands-on Stuff"));
//        reviews.add(new Review("5", "Hatsoff."));
//        courseRepository.addReviewsForCourse(10003L, reviews);

//        studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));
//        employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
//        employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//        logger.info("All Full Time Employees ---> {}", employeeRepository.retrieveAllFullTimeEmployees());
//        logger.info("All Part Time Employees ---> {}", employeeRepository.retrieveAllPartTimeEmployees());
    }
}
