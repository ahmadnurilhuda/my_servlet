package com.greenacademy.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.greenacademy.models.Category;

public class CategoryService {

    private ArrayList<Category> listCategories = new ArrayList<Category>();
    private HttpServletRequest request;

    public CategoryService(HttpServletRequest request){
        this.request = request;
        this.listCategories = (ArrayList<Category>) request.getSession().getAttribute("listCategories");
    }

    public ArrayList<Category> getCategory(){
        return listCategories == null ? new ArrayList<Category> () : this.listCategories;
        
    }

    public void addCategory(Category category){
        ArrayList<Category> listCategories = this.getCategory();
        listCategories.add(category);
        // ? Simpan Kembali arraylist dalam session
        this.request.getSession().setAttribute("listCategories", listCategories);
    }

    public void updateCategory(Category updateCategory){
       for(Category category : this.listCategories){
           if(category.getId().equals(updateCategory.getId())){
               category.setName(updateCategory.getName());
               category.setDescription(updateCategory.getDescription());
           }
       }
    }

    public Category getCategoryById(String categoryId){
        for(Category category : this.listCategories){
            if(category.getId().equals(categoryId)){
                return category;
            }
        }
        return null;
    }
    public void deleteCategory(String id) {
        if (listCategories != null) {
            for (int category = 0; category < listCategories.size(); category++) {
                if (listCategories.get(category).getId().equals(id)) {
                    listCategories.remove(category);
                }
            }
            this.request.getSession().setAttribute("listCategories", listCategories);
        }
    }
}




    
