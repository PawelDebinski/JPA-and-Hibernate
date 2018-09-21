package pl.pawel.dbdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.pawel.dbdemo.entity.Course;

import java.util.List;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

    List<Course> findByName(String name);
    List<Course> findByNameAndId(String name, Long id);
    List<Course> countByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);

    @Query("Select c From Course c where name like '%100 Steps'")
    List<Course> courseWith100StepsInName();

    @Query(value="SELECT * FROM COURSE WHERE name LIKE '%50 Steps'", nativeQuery = true)
    List<Course> courseWith50StepsInNameUsingNativeQuery();

    @Query(name="query_get_50_Step_courses", nativeQuery = true)
    List<Course> courseWith100StepsInNameUsingNamedQuery();


}
