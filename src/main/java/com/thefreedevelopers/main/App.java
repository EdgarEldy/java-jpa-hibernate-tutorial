package com.thefreedevelopers.main;

import com.thefreedevelopers.dao.CategoryDao;

public class App {
    public static void main(String[] args) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.saveCategory("Lemonades");
    }
}
