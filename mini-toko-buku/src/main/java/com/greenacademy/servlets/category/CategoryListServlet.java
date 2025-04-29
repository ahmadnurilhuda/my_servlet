package com.greenacademy.servlets.category;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.service.CategoryService;
import com.greenacademy.models.Category;


@WebServlet("/categories")
public class CategoryListServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        CategoryService categoryService = new CategoryService(request);
        ArrayList<Category> listCategories = categoryService.getCategory();

        request.setAttribute("listCategories", listCategories);
        request.getRequestDispatcher("/WEB-INF/views/categories/list-category.jsp").forward(request, response);
    }

}