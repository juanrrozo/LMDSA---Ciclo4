package ciclo4.proyecto.repository.crud;


import org.springframework.data.repository.CrudRepository;
import ciclo4.proyecto.model.Movie;


public interface MovieCrudRepository extends CrudRepository <Movie,Integer> {
}
