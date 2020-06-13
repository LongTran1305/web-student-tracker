package com.longtran.web.jdbc;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentControllerServlet",urlPatterns = {"/StudentControllerServlet"})
public class StudentControllerServlet extends HttpServlet {

    private StudentDbUtil studentDbUtil;
    @Resource(name = "jdbc/web_student_tracker")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            studentDbUtil = new StudentDbUtil(dataSource);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            listStudent(request,response);
        } catch (Exception e) {
           throw new ServletException(e);
        }
    }

    private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // get student from dbUtils
        List<Student> students = StudentDbUtil.getStudents();
        // add student to request
        request.setAttribute("STUDENT_LIST",students);
        // send to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("../web/list-students.jsp");
        dispatcher.forward(request,response);
        
    }
}
