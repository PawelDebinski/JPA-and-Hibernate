package pl.pawel.dbdemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.pawel.dbdemo.entity.Course;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    public void findById_CoursePresent() {
        Optional<Course> courseOptional = repository.findById(10001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findById_CourseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001L);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    public void playingAroundWithSpringDataRepository() {
        Course course = new Course("Microservices in 100 Steps");
        repository.save(course);

        course.setName("Microservices in 100 Steps - Update");
        repository.save(course);

        logger.info("Courses -> {} ", repository.findAll());
        logger.info("Count -> {} ", repository.count());
    }

    @Test
    public void sort() {
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        logger.info("Sorted Courses -> {} ", repository.findAll(sort));

        logger.info("Count -> {} ", repository.count());
    }

}