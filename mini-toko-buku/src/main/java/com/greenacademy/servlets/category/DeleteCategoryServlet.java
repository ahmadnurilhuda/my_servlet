package com.greenacademy.servlets.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.greenacademy.service.CategoryService;

@WebServlet("/categories/delete/*")
public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
            categoryService.deleteCategory(categoryId);

            response.sendRedirect(request.getContextPath() + "/categories");
        }
    }    
}
