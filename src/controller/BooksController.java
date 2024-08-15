/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;

import dto.BooksDto;
import service.ServiceFactory;
import service.custom.BooksService;

/**
 *
 * @author laksh
 */
public class BooksController {

    private static BooksService booksService = (BooksService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceType.Books);


    public static String save(BooksDto booksDto) throws Exception{
       return booksService.save(booksDto);
    }
    public static String update(BooksDto booksDto) throws Exception{
        return booksService.update(booksDto); 
    }
    public  String delete(String book_id) throws Exception{
        return booksService.delete(book_id);
    }
    public static ArrayList<BooksDto>getAll() throws Exception{
        return booksService.getAll() ;
    }

    public BooksDto get(String book_id) throws Exception{
        return booksService.get(book_id);
    }
}
