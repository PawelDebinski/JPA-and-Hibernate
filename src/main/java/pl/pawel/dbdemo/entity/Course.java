package pl.pawel.dbdemo.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "query_get_all_courses",
                query = "Select c from Course c"),
    @NamedQuery(name = "query_get_50_Step_courses",
                query = "Select c from Course c where name like '%50 Steps'")
})

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    protected Course() {}

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}
