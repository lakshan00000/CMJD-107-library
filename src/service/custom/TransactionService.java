package service.custom;

import java.util.ArrayList;

import dto.TransactionDto;
import service.SuperService;

public interface TransactionService extends SuperService{
    TransactionDto get(Integer transaction_id)throws Exception;
    String save(TransactionDto transactionDto) throws Exception;
    String update(TransactionDto transactionDto) throws Exception;
    String delete(Integer transaction_id) throws Exception;
    ArrayList<TransactionDto> getAll () throws Exception;
   
}
