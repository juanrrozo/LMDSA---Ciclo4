/*
@autor Juan
*/
package ciclo4.proyecto.Crud;


import ciclo4.proyecto.entities.Score;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CrudScoreRepository extends CrudRepository<Score, String> {

    @Query(value= "{$and:[{'movie.id' : ?0},{'client.id':?1}]}")
    List<Score> getScoreByMovieAndClient(String movieId,String clientId);

}
