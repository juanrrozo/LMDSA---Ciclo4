package ciclo4.proyecto.repository;


import ciclo4.proyecto.model.Movie;
import ciclo4.proyecto.repository.crud.MovieCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepository {

    @Autowired
    private MovieCrudRepository movieCrudRepository;

    public List<Movie> getAll(){
        return (List<Movie>) movieCrudRepository.findAll();
    }

    public Optional<Movie> getMovie(int id){
        return movieCrudRepository.findById(id);
    }

    public Movie save(Movie c){
        return movieCrudRepository.save(c);
    }

    public void delete(Movie c){
        movieCrudRepository.delete(c);
    }
}


