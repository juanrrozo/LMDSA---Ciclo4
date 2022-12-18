/*
 @autor Juan
 */
package ciclo4.proyecto.Crud;

import ciclo4.proyecto.entities.Category;
import org.springframework.data.repository.CrudRepository;


public interface CrudCategoryRepository extends CrudRepository<Category, String> {
    
}
