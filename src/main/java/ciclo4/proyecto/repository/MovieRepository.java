/*
 @autor Juan
 */
package ciclo4.proyecto.repository;

import ciclo4.proyecto.Crud.CrudMovieRepository;
import ciclo4.proyecto.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class MovieRepository {
    
    @Autowired
    CrudMovieRepository repository;
    
    public Iterable<Movie> getAll(){
        return repository.findAll();
    }

    public List<Movie> getByName(String name){
        return repository.getMoviesByName(name);
    }
    
    public Optional<Movie> findById(String id){
        Optional<Movie> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Movie save(Movie movie){
        return repository.save(movie);
    }
    
}
