package dao;

import dao.custom.impl.BooksDaoImpl;
import dao.custom.impl.MemberDaoImpl;

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
            default:
               return null;
        }
    }

    public enum DaoTypes{
        Books,Member,BookCategory,BorrowigTransaction;

    }

  

}
