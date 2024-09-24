package dao.custom;

import dao.CrudDao;
import entity.TransactionEntity;

public interface TransactionDao extends CrudDao < TransactionEntity, Integer > {
   
      boolean delete(Integer transaction_id) throws Exception;
}
