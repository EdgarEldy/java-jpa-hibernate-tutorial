package com.thefreedevelopers.dao;

import com.thefreedevelopers.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author EDGARELDY
 * @Description : Category crud implementation
 */
public class CategoryDao {

    // Save a category
    public void saveCategory(String categoryName) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Category category = new Category();
            category.setCategoryName(categoryName);
            entityManager.persist(category);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager != null) {
                entityManager.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManagerFactory.close();
        }
    }

    // Show categories
    public TypedQuery<Category> showCategories() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Category> categories = entityManager.createNamedQuery("Category.findAll", Category.class);
        for (Category category : categories.getResultList()) {
            System.out.println(category.getCategoryName());
        }

        return categories;
    }
}
