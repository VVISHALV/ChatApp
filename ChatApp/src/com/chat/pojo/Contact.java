package com.chat.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.chat.api.ContactEmailApi;
import com.chat.dao.DataObject;

public class Contact  {
	public enum ContactEnum{
		contact_id, firstname, lastname, phone_number, created_at;
	}
	ContactEmailApi contactEmailApi=new ContactEmailApi();
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String createdAt;
	private List<String> emails;
	

	public Contact() {
	}
	
	public Contact(HashMap<String ,String> map) {
		this.contactID = map.get(ContactEnum.contact_id.toString());
		this.firstName = map.get(ContactEnum.firstname.toString());
		this.lastName = map.get(ContactEnum.lastname.toString());
		this.phoneNumber = map.get(ContactEnum.phone_number.toString());
		this.createdAt = map.get(ContactEnum.created_at.toString());
	}


	public String getContactID() {
		return contactID;
	}

	public void setContactID(String contactID) {
		this.contactID = contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public List<String> getEmails(){
		if(emails==null) {
			emails=new ArrayList<>();
			for(ContactEmail c :  contactEmailApi.getContactEmailById(this.contactID)) {
				emails.add(c.getEmailAddress());
			}
		}
		return emails;
	}
	
	public DataObject toDataObject() {
		HashMap< String,String> map=new HashMap<>();
		map.put(ContactEnum.firstname.toString(),this.firstName);
		map.put(ContactEnum.lastname.toString(),this.lastName);
		map.put(ContactEnum.phone_number.toString(),this.phoneNumber);
		map.put(ContactEnum.created_at.toString(),this.createdAt);
		
		return new DataObject(map);
	}

	@Override
	public String toString() {
		return "Contact [contactID=" + contactID + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", createdAt=" + createdAt + ", emails=" + emails + "]";
	}

}
