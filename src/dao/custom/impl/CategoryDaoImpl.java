package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.CategoryDao;
import entity.CategoryEntity;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean create(CategoryEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO BookCategory VALUES(?,?,?)", t.getCategory_id(), t.getName(), t.getDescription());
    }

    @Override
    public boolean update(CategoryEntity t) throws Exception {
       
        return CrudUtil.executeUpdate("UPDATE BookCategory SET Name = ?, Description = ? WHERE Category_id = ?", 
    t.getName(), t.getDescription(), t.getCategory_id());
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM BookCategory WHERE Category_id = ?", id);
    }

    @Override
    public CategoryEntity get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory WHERE Category_id = ?",id);
         if (rst.next()) {
        CategoryEntity entity = new CategoryEntity(rst. getString("Category_id"),
                       rst.getString("Name"),rst.getString("Description"));
          return entity;
        
       }
        return null;
    }

    @Override
    public ArrayList<CategoryEntity> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BookCategory");
        while ( rst.next()) {
         CategoryEntity entity = new CategoryEntity(rst. getString("Category_id"),
                        rst.getString("Name"),rst.getString("Description"));
                     categoryEntities.add(entity);
 
        }
        return categoryEntities;
     }
 
    

}
