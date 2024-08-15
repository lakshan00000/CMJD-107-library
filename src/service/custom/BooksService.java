package service.custom;

import java.util.ArrayList;

import dto.BooksDto;
import service.SuperService;

public interface BooksService extends SuperService {
    String save (BooksDto booksDto) throws Exception;
    String update (BooksDto booksDto) throws Exception;
    String delete(String book_id) throws Exception;
    BooksDto get (String book_id) throws Exception;
    ArrayList<BooksDto> getAll () throws Exception;


}
