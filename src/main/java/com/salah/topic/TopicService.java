package com.salah.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TopicService {
    private List<Topic> list = new ArrayList<>(Arrays.asList(
            new Topic("1", "First Topic", "bla bla"),
            new Topic("2", "Second Topic", "bla bla"),
            new Topic("3", "Third Topic", "bla bla"),
            new Topic("4", "Fourth Topic", "bla bla"),
            new Topic("5", "Fifth Topic", "bla bla")
    ));

    public List<Topic> getTopics() {
        return list;
    }

    public Topic getTopic(String id){
        return list.stream().filter(t -> id.equals(t.getId()))
                .findFirst()
                .orElse(null);
    }

    public Topic addTopic(Topic topic){
        list.add(topic);
        return topic;
    }

    public void updateTopic(Topic topic, String id){
        for (int i = 0; i < list.size(); i++) {
            Topic t = list.get(i);
            if(id.equals(t.getId())){
                list.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id){
        list.removeIf(t -> id.equals(t.getId()));
    }

}
