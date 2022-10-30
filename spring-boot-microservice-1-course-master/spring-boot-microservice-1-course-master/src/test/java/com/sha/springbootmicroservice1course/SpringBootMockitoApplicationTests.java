package com.sha.springbootmicroservice1course;

import com.sha.springbootmicroservice1course.model.Course;
import com.sha.springbootmicroservice1course.repository.CourseRepository;
import com.sha.springbootmicroservice1course.service.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMockitoApplicationTests {

    @Autowired
    private CourseServiceImpl service;

    @MockBean
    private CourseRepository repository;

    @Test
    public void findCourseTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Course(1L, "test-course-1", " this is a test course", 80.0, LocalDateTime.now())).collect(Collectors.toList()));
        Assert.assertEquals(1, service.findAllCourses().size());
    }

    @Test
    public void saveCourseTest() {
        Course course = new Course(2L, "test-course-2", "This is a test course", 100.0, LocalDateTime.now());
        when(repository.save(course)).thenReturn(course);
        Assert.assertEquals(course, service.saveCourse(course));
    }

    @Test
    public void deleteCourseTest() {
        Course course = new Course(2L, "test-course-2", "This is a test course", 100.0, LocalDateTime.now());
        service.deleteCourse(course.getId());
        verify(repository, times(1)).delete(course);
    }

}
