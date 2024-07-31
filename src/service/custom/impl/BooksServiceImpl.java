package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BooksDao;
import dto.BooksDto;
import entity.BooksEntity;
import service.custom.BooksService;

public class BooksServiceImpl implements BooksService {

    private BooksDao booksDao = (BooksDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.Books);

    @Override
    public String save(BooksDto booksDto) throws Exception {
        BooksEntity entity = getBooksEntity(booksDto);
        
      return booksDao.create(entity) ? "Success": "Fail";
    }

    @Override
    public String update(BooksDto booksDto) throws Exception {
        BooksEntity entity = getBooksEntity(booksDto);
        
      return booksDao.update(entity) ? "Success": "Fail";
    }
    

    @Override
    public String delete(BooksDto booksDto) throws Exception {
        return booksDao.delete(booksDto) ? "Success":"Fail" ;
    }

    @Override
    public BooksDto get(String book_id) throws Exception {
        BooksDao entity = (BooksDao) booksDao.get(book_id);
        if(entity != null){
            return getBooksDto ((BooksEntity) entity);
        }
        return null;
    }

    @Override
    public ArrayList<BooksDto> getAll() throws Exception {
        ArrayList<BooksEntity> booksEntities = booksDao.getAll();
        if (booksEntities != null && !booksEntities.isEmpty() ) {
            ArrayList<BooksDto> booksDtos= new ArrayList<>();

            for( BooksEntity booksEntity: booksEntities) {
                booksDtos.add(getBooksDto(booksEntity));
            }
            return booksDtos;
            
        }
        return null;
    }

    private BooksEntity getBooksEntity(BooksDto booksDto){
       return new BooksEntity(
            booksDto.getBook_id(),
            booksDto.getTitle(),
            booksDto.getAuthor(),
            booksDto.getIsbn(),
            booksDto.getCategory_id(),
            booksDto.getAvailable(),
            booksDto.getBook_count());

    }

    private BooksDto getBooksDto(BooksEntity booksEntity){
        return new BooksDto(
             booksEntity.getBook_id(),
             booksEntity.getTitle(),
             booksEntity.getAuthor(),
             booksEntity.getIsbn(),
             booksEntity.getCategory_id(),
             booksEntity.getAvailable(),
             booksEntity.getBook_count());
     }

}
