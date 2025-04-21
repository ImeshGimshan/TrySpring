package org.cyklon.tryoutspringboot.Model;


import jakarta.persistence.*;

@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue

    @Column(name="cat_id", length=45)
    private int catId;

    @Column(name="cat_name", length=45)
    private String catName;

    @Column(name="active", columnDefinition = "TINYINT default 1")
    private boolean active;

    public Category(int catId, String catName, boolean active) {
        this.catId = catId;
        this.catName = catName;
        this.active = active;
    }

    public Category() {}

    public Category(String catName, boolean active) {
        this.catName = catName;
        this.active = active;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
