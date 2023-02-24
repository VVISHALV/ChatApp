<%

response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if (session.getAttribute("contactID") == null) {
        response.sendRedirect("loginPage.jsp");
    }
%>
