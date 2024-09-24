package dao.custom.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.TransactionDao;
import entity.TransactionEntity;

public class TransactionDaoImpl implements TransactionDao {

    @Override
    public boolean create(TransactionEntity t) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO BorrowingTransaction VALUES(?,?,?,?,?,?,?)", t.getTransaction_id(), t.getBook_id(),  t.getMember_id(), t.getBorrow_date(), t.getDue_date(), t.getReturn_date(), t.getFine());
    }

    @Override
    public boolean update(TransactionEntity t) throws Exception {
         BigDecimal fine = BigDecimal.ZERO;
    if (t.getReturn_date() != null && t.getReturn_date().after(t.getDue_date())) {
        long daysLate = ChronoUnit.DAYS.between(t.getDue_date().toLocalDate(), t.getReturn_date().toLocalDate());
        fine = BigDecimal.valueOf(daysLate).multiply(new BigDecimal("5.00")); // Assuming $5 per day fine
    }

        return CrudUtil.executeUpdate("UPDATE BorrowingTransaction  SET Book_id = ?, Member_id = ?, Borrow_date = ?, Due_date = ?, Return_date = ?, Fine = ? WHERE Transaction_id = ?", 
        t.getBook_id(),  t.getMember_id(), t.getBorrow_date(), t.getDue_date(), t.getReturn_date(), fine, t.getTransaction_id());
    }

    @Override
    public boolean delete(Integer transaction_id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM BorrowingTransaction WHERE Transaction_id = ?", transaction_id);
    }

    @Override
    public TransactionEntity get(Integer transaction_id) throws Exception {
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM  WHERE Transaction_id = ?",transaction_id);
       if (rst.next()) {
        TransactionEntity entity = new TransactionEntity(rst. getInt("Transaction_id"),
                       rst.getString("Book_id"),rst.getString("Member_id"),
                       rst.getDate("Borrow_date"),rst.getDate("Due_date"),
                       rst.getDate("Return_date"),rst.getBigDecimal("Fine"));
          return entity;
        
       }
        return null;
    }

    @Override
    public ArrayList<TransactionEntity> getAll() throws Exception {
        ArrayList<TransactionEntity> transactionEntities = new ArrayList<>();
       ResultSet rst = CrudUtil.executeQuery("SELECT * FROM BorrowingTransaction");
       while ( rst.next()) {
        TransactionEntity entity = new TransactionEntity(rst. getInt("Transaction_id"),
                       rst.getString("Book_id"),rst.getString("Member_id"),
                       rst.getDate("Borrow_date"),rst.getDate("Due_date"),
                       rst.getDate("Return_date"),rst.getBigDecimal("Fine"));
                    transactionEntities.add(entity);

       }
       return transactionEntities;
    }


}
