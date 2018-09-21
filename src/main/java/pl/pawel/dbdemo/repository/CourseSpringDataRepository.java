package pl.pawel.dbdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pawel.dbdemo.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {


}
