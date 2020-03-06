package jmsexample.model;

import java.io.Serializable;

public class EmailMessage implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7551478484872312426L;

	private String to;

    private String content;

    public EmailMessage() {

    }

    public EmailMessage(String to, String content) {
        this.to = to;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
