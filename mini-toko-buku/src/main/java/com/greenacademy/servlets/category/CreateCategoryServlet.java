package com.greenacademy.servlets.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.models.Category;
import com.greenacademy.service.CategoryService;


@WebServlet("/categories/create")
public class CreateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/views/categories/create-category.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String categoryName = request.getParameter("name");
        String categoryDescription = request.getParameter("description");

        Category newCategory = new Category(categoryName,categoryDescription);

        CategoryService categoryService = new CategoryService(request);
        categoryService.addCategory(newCategory);
        
        response.sendRedirect(request.getContextPath()+"/categories"); 
    }
}
