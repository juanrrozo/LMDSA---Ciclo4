/*
 @autor Juan
 */
package ciclo4.proyecto.Crud;


import ciclo4.proyecto.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CrudMovieRepository extends CrudRepository<Movie, String> {
    @Query(value= "{name : ?0}")
    List<Movie> getMoviesByName(String name);
}
