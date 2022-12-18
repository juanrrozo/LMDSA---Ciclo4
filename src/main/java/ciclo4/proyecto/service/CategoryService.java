/*
 @autor Juan
 */
package ciclo4.proyecto.service;

import ciclo4.proyecto.Crud.CrudCategoryRepository;
import ciclo4.proyecto.Crud.CrudMovieRepository;
import ciclo4.proyecto.dto.ResponseDto;
import ciclo4.proyecto.entities.Category;
import ciclo4.proyecto.entities.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryService {

    @Autowired
    CrudCategoryRepository repository;

    @Autowired
    CrudMovieRepository movieRepository;

    public Iterable<Category> get() {
        Iterable<Category> response;

        Iterable<Movie> movies = movieRepository.findAll();
        List<Category> categories = new ArrayList<>();
        for (Movie movie: movies) {
            if(movie.getCategories()!=null){
                for (Category cat:movie.getCategories()) {
                    if(!categories.stream().anyMatch(x->x.getName().equals(cat.getName()))){
                        Category currentCategory= new Category();
                        currentCategory.setName(cat.getName());
                        currentCategory.setDescription(cat.getDescription());
                        currentCategory.setAgeMinimum(cat.getAgeMinimum());
                        categories.add(currentCategory);
                    }
                }
            }
        }

        return categories;
    }

    public ResponseDto create(Category request) {

        Category newCategory = repository.save(request);

        ResponseDto responseDto = new ResponseDto();
        responseDto.status=true;
        responseDto.message="Categoría creada correctamente";
        responseDto.id= newCategory.getId();
        return responseDto;

    }

    public Category update(Category category) {
        Category categoryToUpdate = new Category();
        if (repository.existsById(category.getId())) {
            categoryToUpdate = category;
            repository.save(categoryToUpdate);
        }
        return categoryToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}
