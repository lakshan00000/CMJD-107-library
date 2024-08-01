package entity;

public class CategoryEntity {
    private String category_id;
    private String name;
    private String description;
    
    public CategoryEntity(String category_id, String name, String description) {
        this.category_id = category_id;
        this.name = name;
        this.description = description;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryEntity [category_id=" + category_id + ", name=" + name + ", description=" + description + "]";
    }



    

}
