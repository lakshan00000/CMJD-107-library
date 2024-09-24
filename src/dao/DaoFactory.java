package dao;

import dao.custom.impl.BooksDaoImpl;
import dao.custom.impl.CategoryDaoImpl;
import dao.custom.impl.MemberDaoImpl;
import dao.custom.impl.TransactionDaoImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {}

    public static DaoFactory getInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public SuperDao getDao(DaoTypes type){
        switch(type){
            case Books:
               return new BooksDaoImpl();
               case Member:
               return new MemberDaoImpl();
               case Category:
               return new CategoryDaoImpl();
               case Transaction:
               return new TransactionDaoImpl();
            default:
               return null;
        }
    }

    public enum DaoTypes{
        Books,Member,Category,Transaction;

    }

  

}
