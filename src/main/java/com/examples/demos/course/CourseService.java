package com.examples.demos.course;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    /*
     * private List<Course> topics = new ArrayList<>( Arrays.asList(new
     * Topic("spring", "Spring Framework", "Spring Framework Description"), new
     * Topic("java", "Core java", "Core java Description"), new Topic("javascript",
     * "Core Javascript", "Core javascript Description")));
     */

    public List<Course> getAllCourses(String topicId) {

        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        // courseRepository.findAllById(topicId);

        return courses;

    }

    public Course getCourse(String id) {
        // return topics.stream().filter(topic ->
        // topic.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course) {

        // topics.add(topic);
        courseRepository.save(course);
    }

    /*
     * public Optional<Course> getATopic(String id) { return
     * courses.stream().filter(topic -> topic.getId().equals(id)).findFirst(); }
     */

    public void updateCourse(Course newCourse) {
        /*
         * return getATopic(id).map(t -> { int indexToUpdate = topics.indexOf(t); if
         * (indexToUpdate >= 0) { topics.set(indexToUpdate, newtopic); return 1; }
         * return 0; }).orElse(0);
         */

        courseRepository.save(newCourse);

    }

    public void deleteCourse(String id) {
        // topics.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);

    }
}