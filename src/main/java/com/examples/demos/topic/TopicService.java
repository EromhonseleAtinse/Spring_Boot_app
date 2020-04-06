package com.examples.demos.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(
            Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
                    new Topic("java", "Core java", "Core java Description"),
                    new Topic("javascript", "Core Javascript", "Core javascript Description")));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }
}