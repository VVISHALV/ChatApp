package com.chat.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email =request.getParameter("email_address");
		String password = request.getParameter("password");
		ContactEmail contactEmail=contactEmailApi.getContactEmailByPrimaryEmail(email);
		ContactPswd contactPswd=contactPswdApi.getContactPswdByID(contactEmail.getContactID());
		
		
		if(password.equals(contactPswd.getPassword())) {
			Cookie cookie=new Cookie("contactID",contactEmail.getContactID());
			response.addCookie(cookie);
			HttpSession session=request.getSession();
			session.setAttribute("contactID", contactEmail.getContactID());
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("loginPage.jsp");
		}
		
	}

}
