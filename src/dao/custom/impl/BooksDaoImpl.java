package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.BooksDao;
import entity.BooksEntity;


public class BooksDaoImpl implements BooksDao {

    @Override
    public boolean create(BooksEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Books VALUES(?,?,?,?,?,?,?)", t.getBook_id(), t.getTitle(), t.getAuthor(), t.getIsbn(), t.getCategory_id(), t.getAvailable(), t.getBook_count());
    }
    @Override
    public boolean update(BooksEntity t) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Books SET Title = ?, Author = ?, Isbn = ?, Category_id = ?, Available = ?, Book_count = ? WHERE Book_id = ?", 
        t.getTitle(), t.getAuthor(), t.getIsbn(), t.getCategory_id(), t.getAvailable(), t.getBook_count(), t.getBook_id());
        
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM books WHERE Book_id = ?", id);
       
    }

    @Override
    public BooksEntity get(String id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Books WHERE Book_id = ?",id);
       if (rst.next()) {
        BooksEntity entity = new BooksEntity(rst. getString("Book_id"),
                       rst.getString("Title"),rst.getString("Author"),
                       rst.getString("Isbn"),rst.getString("Category_id"),
                       rst.getBoolean("Available"),rst.getInt("Book_count"));
          return entity;
        
       }
        return null;
    }

    @Override
    public ArrayList<BooksEntity> getAll() throws Exception {
       ArrayList<BooksEntity> booksEntities = new ArrayList<>();
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Books");
       while ( rst.next()) {
        BooksEntity entity = new BooksEntity(rst. getString("Book_id"),
                       rst.getString("Title"),rst.getString("Author"),
                       rst.getString("Isbn"),rst.getString("Category_id"),
                       rst.getBoolean("Available"),rst.getInt("Book_count"));
                    booksEntities.add(entity);

       }
       return booksEntities;
    }
   

 

 
}