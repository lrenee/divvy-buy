package org.divvybuy.divvybuy.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topic extends AbstractEntity {

    @Size(min = 2, max = 50, message = "Topic name must be between 2 and 50 characters.")
    private String topicName;

    @OneToMany(mappedBy = "topic")
    private final List<Thread> threads = new ArrayList<>();

    public Topic(@Size(min = 2, max = 50, message = "Topic name must be between 2 and 50 characters.")
                         String topicName) {
        this.topicName = topicName;
    }

    public Topic() {}

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<Thread> getThreads() {
        return threads;
    }

    @Override
    public String toString() {
        return topicName;
    }

}
