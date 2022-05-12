package com.example.superhot.controller;


import com.example.superhot.entity.Student;
import com.example.superhot.model.MySqlStudentModel;
import com.example.superhot.model.StudentModel;
import com.example.superhot.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateStudentServiet extends HttpServlet {

    private StudentModel studentModel;

    private CreateStudentServiet(){
        this.studentModel = new MySqlStudentModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/students/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String rollNumber = req.getParameter("rollNumber");
        String fullName = req.getParameter("fullName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String stringBirthday = req.getParameter("birthday");
        LocalDateTime birthday = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Student student = new Student(rollNumber,fullName,email,phone,birthday);
        if (studentModel.save(student)!=null){
            resp.sendRedirect("/admin/students/list");
        }else {
            req.getRequestDispatcher("/admin/students/form.jsp").forward(req,resp);
        }
    }
}
