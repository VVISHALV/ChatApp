package com.chat.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chat.api.ContactApi;
import com.chat.pojo.Contact;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName =request.getParameter("firstName");
		String lastName =request.getParameter("lastName");
		String phoneNumber =request.getParameter("phoneNumber");
		String email_address =request.getParameter("email_address");
		String password =request.getParameter("password");
		
		Contact contact=new Contact();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setPhoneNumber(phoneNumber);
		contact.setCreatedAt(System.currentTimeMillis()+"");
		ContactApi contactApi=new ContactApi();
		System.out.println(contactApi.insertContact(contact));
	}

}
