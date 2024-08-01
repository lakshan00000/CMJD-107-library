package service.custom;

import java.util.ArrayList;
import java.util.Locale.Category;

import dto.CategoryDto;

public interface CategoryService {
     String save (CategoryDto categoryDto) throws Exception;
    String update (CategoryDto categoryDto) throws Exception;
    String delete(CategoryDto categoryDto) throws Exception;
    CategoryDto get (String category_id) throws Exception;
    ArrayList<CategoryDto> getAll () throws Exception;


}
