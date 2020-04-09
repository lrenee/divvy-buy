package org.divvybuy.divvybuy.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class ThreadDetails extends AbstractEntity {

    @Size( max = 254, message = "Message is too long!  Maximum message is 254 characters long.")
    private String threadMessage;

    @NotBlank(message = "E-mail is required.")
    @Email(message = "Invalid e-mail.  Please try again.")
    private String contactEmail;

    public ThreadDetails(@Size( max = 254, message = "Description message is too long!  " +
            "Maximum message length is 254 characters long.") String message,
                         @NotBlank(message = "E-mail is required.")
                         @Email(message = "Invalid e-mail.  Please try again.") String contactEmail) {
        this.threadMessage = threadMessage;
        this.contactEmail = contactEmail;
    }

    public ThreadDetails() {}

    public String getThreadMessage() {
        return threadMessage;
    }

    public void setThreadMessage(String threadMessage) {
        this.threadMessage = threadMessage;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

}
