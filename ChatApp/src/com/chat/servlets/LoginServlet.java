package com.chat.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chat.api.ContactApi;
import com.chat.api.ContactEmailApi;
import com.chat.api.ContactPswdApi;
import com.chat.pojo.Contact;
import com.chat.pojo.ContactEmail;
import com.chat.pojo.ContactPswd;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	ContactEmailApi contactEmailApi=new ContactEmailApi();
	ContactPswdApi contactPswdApi=new ContactPswdApi();
	ContactApi contactApi=new ContactApi();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = "test@email.com";
		String password = "test";
//		ContactEmail contactEmail=contactEmailApi.getContactEmailByPrimaryEmail(email);
//		ContactPswd contactPswd=contactPswdApi.getContactPswdByID(contactEmail.getContactID());
		Contact contact=contactApi.getContactByID("22");
		List<String> list=contact.getEmails();
		System.out.println(contact);
//		if(password.equals(contactPswd.getPassword()))
//			System.out.println(true);
//		else {
//			System.out.println(false);
//		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
