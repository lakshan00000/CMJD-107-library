package service;

import service.custom.impl.BooksServiceImpl;

public class ServiceFactory {

      private static ServiceFactory serviceFactory;

      private ServiceFactory(){}

      public static ServiceFactory getInstance(){
        if(serviceFactory== null){
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
      }

      public SuperService getService(ServiceType serviceType){
        switch (serviceType){
            case Books:
                return new BooksServiceImpl();
            default:
                return null;    
        }
      }
      public enum ServiceType{
        Books
      }

}
