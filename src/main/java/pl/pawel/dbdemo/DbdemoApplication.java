package pl.pawel.dbdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pawel.dbdemo.entity.Course;
import pl.pawel.dbdemo.entity.Review;
import pl.pawel.dbdemo.repository.CourseRepository;
import pl.pawel.dbdemo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DbdemoApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DbdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepository.saveStudentWithPassport();
        List<Review> reviews = new ArrayList<>();
        reviews.add(new Review("5", "Great Hands-on Stuff"));
        reviews.add(new Review("5", "Hatsoff."));
        courseRepository.addReviewsForCourse(10003L, reviews);
    }
}
