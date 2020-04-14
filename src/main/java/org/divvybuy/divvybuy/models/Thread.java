package org.divvybuy.divvybuy.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Thread extends AbstractEntity {

    @NotBlank(message = "Thread name is required.")
    @Size(min = 2, max = 50, message = "Thread name must be between 2 and 50 characters.")
    private String threadName;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull(message = "Thread details are required.")
    private ThreadDetails threadDetails;

    @ManyToOne
    @NotNull(message = "Topic is required.")
    private Topic topic;

    public Thread(String threadName, Topic topic) {
        this.threadName = threadName;
        this.topic = topic;
    }

    public Thread() {

    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public ThreadDetails getThreadDetails() {
        return threadDetails;
    }

    public void setThreadDetails(ThreadDetails threadDetails) {
        this.threadDetails = threadDetails;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return threadName;
    }

}
