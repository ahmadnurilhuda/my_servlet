package com.greenacademy.servlets.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.models.Category;
import com.greenacademy.service.CategoryService;

@WebServlet("/categories/edit/*")
public class EditCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        // ! ambil id kategori dari URL
        String pathInfo = request.getPathInfo();
        String categoryId = pathInfo != null ? pathInfo.substring(1) : null;

        // ! kondisi jika id kategori tidak ditemukan
        if (categoryId == null || categoryId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Category ID is Missing");
            return;
        } else {
            // ! setelah dipastikan id kategori ada, lanjut cari kategori berdasarkan id
            CategoryService categoryService = new CategoryService(request);
            Category categoryById = categoryService.getCategoryById(categoryId);

            if (categoryById == null) {
                response.sendRedirect(request.getContextPath() + "/categories");
                return;
            }

            request.setAttribute("category", categoryById);
            request.getRequestDispatcher("/WEB-INF/views/categories/edit-category.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");

        // ! ambil id kategori dari URL
        String pathInfo = request.getPathInfo();
        String categoryId = pathInfo != null ? pathInfo.substring(1) : null;

        // ! kondisi jika id kategori tidak ditemukan
        if (categoryId == null || categoryId.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Category ID is Missing");
            return;
        } else {
            // ! setelah dipastikan id kategori ada, lanjut cari kategori berdasarkan id
            CategoryService categoryService = new CategoryService(request);
            Category categoryById = categoryService.getCategoryById(categoryId);

            if (categoryById == null) {
                response.sendRedirect(request.getContextPath() + "/categories");
                return;
            }

            // ! ambil data dari form
            String categoryName = request.getParameter("name");
            String categoryDescription = request.getParameter("description");

            categoryById.setName(categoryName);
            categoryById.setDescription(categoryDescription);

            categoryService.updateCategory(categoryById);

            response.sendRedirect(request.getContextPath() + "/categories");
        }


    }
}
