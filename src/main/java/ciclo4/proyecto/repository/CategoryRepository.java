/*
 @autor Juan
 */
package ciclo4.proyecto.repository;

import ciclo4.proyecto.Crud.CrudCategoryRepository;
import ciclo4.proyecto.entities.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public class CategoryRepository {
    
    @Autowired
    CrudCategoryRepository repository;
    
    public Iterable<Category> getAll(){
        return repository.findAll();
    }
    
    public Optional<Category> findById(String id){
        Optional<Category> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Category save(Category category){
        return repository.save(category);
    }
    
}
