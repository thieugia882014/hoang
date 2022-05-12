package com.example.superhot.controller;

import com.example.superhot.model.MySqlStudentModel;
import com.example.superhot.model.StudentModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListStudentServlet extends HttpServlet {
    private StudentModel studentModel;

    public ListStudentServlet(){
        this.studentModel = new MySqlStudentModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listStudent",studentModel.findAll());
        req.getRequestDispatcher("/admin/studnets/lít.jsp").forward(req,resp);
    }
}
