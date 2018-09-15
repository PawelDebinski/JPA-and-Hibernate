package pl.pawel.dbdemo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.pawel.dbdemo.entity.Course;

import javax.persistence.EntityManager;

@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findByid(Long id) {
        return em.find(Course.class, id);
    }
}
