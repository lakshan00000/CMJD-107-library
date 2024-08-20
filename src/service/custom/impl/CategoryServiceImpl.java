package service.custom.impl;

import java.util.ArrayList;

import dao.DaoFactory;
import dao.custom.BooksDao;
import dao.custom.CategoryDao;
import dto.BooksDto;
import dto.CategoryDto;
import entity.BooksEntity;
import entity.CategoryEntity;
import service.custom.CategoryService;

public class CategoryServiceImpl implements CategoryService {

      private CategoryDao categoryDao = (CategoryDao)DaoFactory.getInstance().getDao(DaoFactory.DaoTypes.Category);


   @Override
    public String save(CategoryDto categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        
      return categoryDao.create(entity) ? "Success": "Fail";
    }

    @Override
    public String update(CategoryDto categoryDto) throws Exception {
        CategoryEntity entity = getCategoryEntity(categoryDto);
        
      return categoryDao.update(entity) ? "Success": "Fail";
    }
    

    @Override
    public String delete(String category_id) throws Exception {
        return categoryDao.delete(category_id) ? "Success": "Fail" ;
    }

    @Override
    public CategoryDto get(String category_id) throws Exception {
        CategoryEntity entity = categoryDao.get(category_id);
        if(entity != null){
            return getCategoryDto ( entity);
        }
        return null;
    }

    @Override
    public ArrayList<CategoryDto> getAll() throws Exception {
        ArrayList<CategoryEntity> categoryEntities = categoryDao.getAll();
        if (categoryEntities != null && !categoryEntities.isEmpty() ) {
            ArrayList<CategoryDto> categoryDtos= new ArrayList<>();

            for( CategoryEntity categoryEntity: categoryEntities) {
                categoryDtos.add(getCategoryDto(categoryEntity));
            }
            return categoryDtos;
            
        }
        return null;
    }

    private CategoryEntity getCategoryEntity(CategoryDto categoryDto){
       return new CategoryEntity(
            categoryDto.getCategory_id(),
            categoryDto.getName(),
            categoryDto.getDescription()
       );

    }

    private CategoryDto getCategoryDto(CategoryEntity categoryEntity){
        return new CategoryDto(
             categoryEntity.getCategory_id(),
             categoryEntity.getName(),
             categoryEntity.getDescription());
     }

   

}
