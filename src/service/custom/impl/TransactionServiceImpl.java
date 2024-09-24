package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.TransactionDao;
import dto.TransactionDto;
import entity.TransactionEntity;
import service.custom.TransactionService;

public class TransactionServiceImpl implements TransactionService {

    private TransactionDao transactionDao = (TransactionDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.Transaction);

    @Override
    public TransactionDto get(Integer transaction_id) throws Exception {
        TransactionEntity entity = transactionDao.get(transaction_id);
        if(entity != null){
            return getTransactionDto ( entity);
        }
        return null;
    }
     

    @Override
    public String save(TransactionDto transactionDto) throws Exception {
        TransactionEntity entity = getTransactionEntity(transactionDto);
        
      return transactionDao.create(entity) ? "Success": "Fail";
    }
    @Override
    public String update(TransactionDto transactionDto) throws Exception {
        TransactionEntity entity = getTransactionEntity(transactionDto);
        
      return transactionDao.update(entity) ? "Success": "Fail";
    }

    @Override
    public String delete(Integer transaction_id) throws Exception {
        return transactionDao.delete(transaction_id) ? "Success": "Fail" ;
    }

    @Override
    public ArrayList<TransactionDto> getAll() throws Exception {
         ArrayList<TransactionEntity> transactionEntities = transactionDao.getAll();
        if (transactionEntities != null && !transactionEntities.isEmpty() ) {
            ArrayList<TransactionDto> transactionDtos= new ArrayList<>();

            for( TransactionEntity transactionEntity: transactionEntities) {
                transactionDtos.add(getTransactionDto(transactionEntity));
            }
            return transactionDtos;
            
        }
        return null;
    }

    private TransactionEntity getTransactionEntity(TransactionDto transactionDto){
        return new TransactionEntity(
             transactionDto.getTransaction_id(),
             transactionDto.getBook_id(),
             transactionDto.getMember_id(),
             transactionDto.getBorrow_date(),
             transactionDto.getDue_date(),
             transactionDto.getReturn_date(),
             transactionDto.getFine());
 
     }
 
     private TransactionDto getTransactionDto(TransactionEntity transactionEntity){
         return new TransactionDto(
              transactionEntity.getTransaction_id(),
              transactionEntity.getBook_id(),
              transactionEntity.getMember_id(),
              transactionEntity.getBorrow_date(),
              transactionEntity.getDue_date(),
              transactionEntity.getReturn_date(),
              transactionEntity.getFine());
      }

}
