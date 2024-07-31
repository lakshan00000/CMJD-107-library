package dao;

import dao.custom.impl.BooksDaoImpl;

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
            default:
               return null;
        }
    }

    public enum DaoTypes{
        Books,Member,BookCategory,BorrowigTransaction;
    }

}
