package com.chat.pojo;

import java.util.HashMap;


public class ContactPswd {
	public enum ContactPswdEnum{
		contact_id,
		password,
		modified_at;
	}

	private String contactID;
	private String password;
	private String modifiedAt;
	
	public ContactPswd() {}
	public ContactPswd(HashMap<String ,String> map) {
		this.contactID = map.get(ContactPswdEnum.contact_id.toString());
		this.password = map.get(ContactPswdEnum.password.toString());
		this.modifiedAt = map.get(ContactPswdEnum.modified_at.toString());
	}
	public ContactPswd(String contactID, String password, String modifiedAt) {
		this.contactID = contactID;
		this.password = password;
		this.modifiedAt = modifiedAt;
	}

	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return "ContactPswd [contactID=" + contactID + ", password=" + password + ", modifiedAt=" + modifiedAt + "]";
	}
	
	
}
