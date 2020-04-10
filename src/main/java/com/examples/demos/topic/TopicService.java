package com.examples.demos.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(
            Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
                    new Topic("java", "Core java", "Core java Description"),
                    new Topic("javascript", "Core Javascript", "Core javascript Description")));

    public List<Topic> getAllTopics() {
        // return topics;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);

        return topics;
    }

    public Topic getTopic(String id) {
        // return topics.stream().filter(topic ->
        // topic.getId().equals(id)).findFirst().get();
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {

        // topics.add(topic);
        topicRepository.save(topic);
    }

    public Optional<Topic> getATopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst();
    }

    public void updateTopic(String id, Topic newtopic) {
        /*
         * return getATopic(id).map(t -> { int indexToUpdate = topics.indexOf(t); if
         * (indexToUpdate >= 0) { topics.set(indexToUpdate, newtopic); return 1; }
         * return 0; }).orElse(0);
         */

        topicRepository.save(newtopic);

    }

    public void deleteTopic(String id) {
        // topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);

    }
}