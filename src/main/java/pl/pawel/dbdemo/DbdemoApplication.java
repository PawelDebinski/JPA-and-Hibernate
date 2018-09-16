package pl.pawel.dbdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pawel.dbdemo.entity.Course;
import pl.pawel.dbdemo.repository.CourseRepository;

@SpringBootApplication
public class DbdemoApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository repository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(DbdemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Course course = repository.findById(10001L);
//        logger.info("Course 10001 -> {}", course.toString());
//        repository.save(new Course("Micorservices in 100 steps"));
        repository.playWithEntityManager();
    }
}
