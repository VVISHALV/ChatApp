package com.chat.pojo;

import java.util.HashMap;


public class ContactEmail {
	public enum ContactEmailEnum{
		contact_id,
		email_address,
		added_at,
		is_primary,
		modified_at;
	}

	private String contactID;
	private String emailAddress;
	private String addedAt;
	private String isPrimary;
	private String modifiedAt;
	
	public ContactEmail() {}
	public ContactEmail(HashMap<String ,String> map) {
		this.contactID = map.get(ContactEmailEnum.contact_id.toString());
		this.emailAddress = map.get(ContactEmailEnum.email_address.toString());
		this.addedAt = map.get(ContactEmailEnum.added_at.toString());
		this.isPrimary = map.get(ContactEmailEnum.is_primary.toString());
		this.modifiedAt = map.get(ContactEmailEnum.modified_at.toString());

	}
	public ContactEmail(String contactID, String emailAddress, String addedAt, String isPrimary, String modifiedAt) {
		this.contactID = contactID;
		this.emailAddress = emailAddress;
		this.addedAt = addedAt;
		this.isPrimary = isPrimary;
		this.modifiedAt = modifiedAt;
	}
	
	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(String addedAt) {
		this.addedAt = addedAt;
	}

	public String getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	
	@Override
	public String toString() {
		return "ContactEmail [contactID=" + contactID + ", emailAddress=" + emailAddress + ", addedAt=" + addedAt + ", isPrimary=" + isPrimary + ", modifiedAt=" + modifiedAt + "]";
	}

}
