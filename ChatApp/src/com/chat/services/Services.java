package com.chat.services;


import com.chat.api.ContactEmailApi;
import com.chat.api.ContactPswdApi;
import com.chat.pojo.ContactEmail;
import com.chat.pojo.ContactPswd;

public class Services {
	ContactEmailApi contactEmailApi=new ContactEmailApi();
	ContactPswdApi contactPswdApi=new ContactPswdApi();
	
	
	public boolean validateContact(String email,String password) {
		ContactEmail contactEmail=contactEmailApi.getContactEmailByPrimaryEmail(email);
		ContactPswd contactPswd=contactPswdApi.getContactPswdByID(contactEmail.getContactID());
		if(password.equals(contactPswd.getPassword()))
			return true;
		return false;
	}
}
