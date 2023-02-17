package com.chat.pojo;

public class Message {
	public enum MessageEnum{
		message_id,
		from_contact,
		group_id,
		message,
		sent_at;
	}

	private String messageID;
	private String fromContact;
	private String groupID;
	private String message;
	private String sentAt;
	
	public Message(String messageID, String fromContact, String groupID, String message, String sentAt) {
		this.messageID = messageID;
		this.fromContact = fromContact;
		this.groupID = groupID;
		this.message = message;
		this.sentAt = sentAt;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public String getFromContact() {
		return fromContact;
	}

	public void setFromContact(String fromContact) {
		this.fromContact = fromContact;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	@Override
	public String toString() {
		return "Messages [messageID=" + messageID + ", fromContact=" + fromContact + ", groupID=" + groupID + ", message=" + message + ", sentAt=" + sentAt + "]";
	}
	
	
	
	
}
