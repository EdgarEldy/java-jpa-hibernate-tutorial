package com.thefreedevelopers.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "category_name", nullable = true, length = 50, unique = true)
    private String categoryName;

    // Define a one-to-many relationship to Product
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    // Generate getters and setters for products
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * Compares this Category object to another object to determine equality.
     * Two Category objects are considered equal if:
     * 1. They are the same instance (reference comparison).
     * 2. They are of the same class (Category).
     * 3. Their id fields are equal.
     * 4. Their categoryName fields are both null or have the same value.
     *
     * @param o the object to compare this Category against.
     * @return true if the objects are equal according to the above conditions, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;

        return true;
    }

    /**
     * Generates a hash code for the Category object based on its fields.
     * The hash code is computed using the id and the categoryName fields.
     * A prime number (31) is used to combine the values of these fields,
     * ensuring a well-distributed hash code for the object.
     *
     * @return an integer representing the hash code of this Category object.
     * If the categoryName is null, its contribution to the hash code is 0.
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        return result;
    }

    /**
     * Returns a string representation of the Category object.
     * The string includes the id and categoryName fields.
     *
     * @return a string in the format:
     * "Category{id=<id>, categoryName='<categoryName>'}"
     */
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
