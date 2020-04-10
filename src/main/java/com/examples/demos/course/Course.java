package com.examples.demos.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.examples.demos.topic.Topic;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Course {

    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private Topic topic;

    public Course() {

    }

    public Course(@JsonProperty("id") String id, @JsonProperty("name") String name,
            @JsonProperty("description") String description, String topicId) {
        this.id = id;
        this.name = name;
        this.description = description;

        this.topic = new Topic(topicId, "", "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}