package MyPack;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ControllerServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        processRequest(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        processRequest(request,response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
        String userAction = request.getParameter("action");
        HttpSession session;
        if(userAction.equals("login")){
            logIn(request, response);
        }
        else if(userAction.equals("update")){
            updateJob(request, response);
        }
        else if(userAction.equals("search")){
            searchJob(request, response);
        }
        else if(userAction.equals("delete")){
            deleteJob(request, response);
        }
        else if(userAction.equals("view")){
            retrieveJobs(request, response);
        }
        else if(userAction.equals("signup")){
            signUp(request, response);
        }
        else if(userAction.equals("save")){
            addJob(request, response);
        }
        else if(userAction.equals("show")){
            showProfile(request, response);
        }
        else if(userAction.equals("logout")){
            session = request.getSession(false);
            if(session!=null){
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);
            }
        }
        else if(userAction.equals("apply")){
            applyJob(request, response);
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);
        }
    }
private void addJob(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    int rs = 0;
    try{
        JobDAO jDao = new JobDAO();
        JobInfo job = new JobInfo();
        String id = request.getParameter("id");
        job.setId(id);
        String title = request.getParameter("title");
        job.setTitle(title);
        String salary = request.getParameter("salary");
        int s = Integer.parseInt(salary);
        job.setSalary(s);
        String type = request.getParameter("type");
        job.setType(type);
        String description = request.getParameter("description");
        job.setDescription(description);

        rs = jDao.addJob(job);
        if (rs == 1){
            RequestDispatcher rd = request.getRequestDispatcher("savejob.jsp");
            rd.forward(request,response);
        }
        else{
            String value = "Record Already exists!";
            request.setAttribute("key", value);
            RequestDispatcher rd = request.getRequestDispatcher("recordError.jsp");
            rd.forward(request,response);
        }
     }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void updateJob(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    int rs = 0;
    try{
        JobDAO jDao = new JobDAO();
        JobInfo job = new JobInfo();
        String id = request.getParameter("id");
        job.setId(id);
        String title = request.getParameter("title");
        job.setTitle(title);
        String salary = request.getParameter("salary");
        int s = Integer.parseInt(salary);
        job.setSalary(s);
        String type = request.getParameter("type");
        job.setType(type);
        String description = request.getParameter("description");
        job.setDescription(description);

        rs = jDao.updateJob(job);
        if (rs == 1){
            RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
            rd.forward(request,response);
        }
        else{
            String value = "No Record Error!";
            request.setAttribute("key", value);
            RequestDispatcher rd = request.getRequestDispatcher("recordError.jsp");
            rd.forward(request,response);
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void searchJob(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    try{
        JobDAO jDao = new JobDAO();
        JobInfo job = new JobInfo();
        String title = request.getParameter("title");
        job.setTitle(title);
        ArrayList jList = jDao.searchJob(title);
        request.setAttribute("list",jList);
        if (jList.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("noRecord.jsp");
            rd.forward(request,response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
            rd.forward(request,response);
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void deleteJob(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    int rs = 0;
    try{
        JobDAO jDao = new JobDAO();
        JobInfo job = new JobInfo();
        String id = request.getParameter("id");
        job.setId(id);
        rs = jDao.delete(id);
        if (rs == 1){
            RequestDispatcher rd = request.getRequestDispatcher("delete.jsp");
            rd.forward(request,response);}
        else{
            String value = "No Record Error!";
            request.setAttribute("key", value);
            RequestDispatcher rd = request.getRequestDispatcher("recordError.jsp");
            rd.forward(request,response);
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void retrieveJobs(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    try{
        JobDAO jDao = new JobDAO();
        JobInfo job = new JobInfo();
        ArrayList jList = jDao.retrieveJobs();
        request.setAttribute("list",jList);
        if (jList.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("noRecord.jsp");
            rd.forward(request,response);
        }
        else{
            RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
            rd.forward(request,response);
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void signUp(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    int rs = 0;
    try{
        UserDAO uDao = new UserDAO();
        UserInfo user = new UserInfo();
        String email = request.getParameter("email");
        user.setEmail(email);
        String username = request.getParameter("username");
        user.setUsername(username);
        String password = request.getParameter("password");
        user.setPassword(password);
        String phone = request.getParameter("phone");
        user.setPhone(phone);
        String userType = request.getParameter("user_type");
        user.setUserType(userType);
        rs = uDao.addUser(user);

        if (rs==1){
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);
        }
        else{
            String value = "Already have an account. Please Login!";
            request.setAttribute("key", value);
            RequestDispatcher rd = request.getRequestDispatcher("invalid.jsp");
            rd.forward(request,response);
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void logIn(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    int rs = 0;
    try{
        UserDAO uDao = new UserDAO();
        UserInfo user = new UserInfo();
        String username = request.getParameter("username");
        user.setUsername(username);
        String password = request.getParameter("password");
        user.setPassword(password);
        rs = uDao.authentication(username,password);
        if(rs == 1){
            HttpSession sess = request.getSession(true);
            sess.setAttribute("username",username);
            sess.setAttribute("user_type",rs);
            response.sendRedirect("home.jsp");
        }
        else if(rs == 2){
            HttpSession sess = request.getSession();
            sess.setAttribute("username",username);
            sess.setAttribute("user_type",rs);
            response.sendRedirect("homeUser.jsp");
        }
        else{
            String value = "Invalid Username or Password!";
            request.setAttribute("key", value);
            RequestDispatcher rd = request.getRequestDispatcher("invalid.jsp");
            rd.forward(request,response);

        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void showProfile(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    try{
        HttpSession session = request.getSession(false);
        UserDAO uDao = new UserDAO();
        UserInfo user = new UserInfo();
        if((String)session.getAttribute("username")==null){
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request,response);		
        }
        else{
            if((int)session.getAttribute("user_type")==2){
                String username = (String)session.getAttribute("username");
                user.setUsername(username);
                UserInfo uList = uDao.profile(username);
                request.setAttribute("list",uList);
                if (uList == null){
                    RequestDispatcher rd = request.getRequestDispatcher("noRecord.jsp");
                    rd.forward(request,response);
                }
                else{
                    RequestDispatcher rd = request.getRequestDispatcher("showP.jsp");
                    rd.forward(request,response);
                }
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                    rd.forward(request,response);
            }
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
private void applyJob(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    int rs = 0;
    try{
        JobDAO jDao = new JobDAO();
        String id = request.getParameter("id");
        ArrayList jList = jDao.searchAppJob(id);
        request.setAttribute("list",jList);
        if (jList.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("noRecord.jsp");
            rd.forward(request,response);
        }
        else{
            HttpSession session = request.getSession(false);
            UserDAO uDao = new UserDAO();
            UserInfo user = new UserInfo();
            if(session==null){
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);		
            }
            if((int)session.getAttribute("user_type")==2){
                String username = (String)session.getAttribute("username");
                user.setUsername(username);
                rs = uDao.applyJob(username,id);
                if (rs == 1){
                    RequestDispatcher rd = request.getRequestDispatcher("apply.jsp");
                    rd.forward(request,response);}
                else{
                    String value = "No Record Error!";
                    request.setAttribute("key", value);
                    RequestDispatcher rd = request.getRequestDispatcher("noRecord.jsp");
                    rd.forward(request,response);
                }
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);  
            }
        }
    }
    catch(SQLException s){
        request.setAttribute("javaxservlet.jsp.JspException",s);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
    catch(ClassNotFoundException c){
        request.setAttribute("javaxservlet.jsp.JspException",c);
        RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
        rd.forward(request,response);
    }
}
}