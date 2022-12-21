/*
 @autor Juan
 */
package ciclo4.proyecto.service;

import ciclo4.proyecto.dto.ResponseDto;
import ciclo4.proyecto.entities.Category;
import ciclo4.proyecto.entities.Movie;
import ciclo4.proyecto.repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MovieService {

    private final String MOVIE_REGISTERED="La pelicula ya se encuentra registrada";
    private final String MOVIE_SUCCESS="La pelicula se registró correctamente";

    @Autowired
    MovieRepository repository;

    public Iterable<Movie> get() {
        Iterable<Movie> response = repository.getAll();
        return response;
    }

    public Optional<Movie> getById(String id) {
        Optional<Movie> response = repository.findById(id);
        return response;
    }

    public ResponseDto create(Movie request) {
        ResponseDto response = new ResponseDto();
        List<Movie> movies = repository.getByName(request.getName());
        if(movies.size()>0){
            response.status=false;
            response.message=MOVIE_REGISTERED;
        }else{
            //validar que ese id de la categoría exista y lo consulto, una vez que lo consulte lo agrego al elemento de request
            //
            List<Category> listFromRequest = new ArrayList<>();
            request.setCategories(listFromRequest);
            repository.save(request);
            response.status=true;
            response.message=MOVIE_SUCCESS;
            response.id= request.getId();
        }
        return response;
    }

    public Movie update(Movie movie) {
        Movie movieToUpdate = new Movie();

        Optional<Movie> currentMovie = repository.findById(movie.getId());
        if (!currentMovie.isEmpty()) {
            movieToUpdate = movie;
            movieToUpdate=repository.save(movieToUpdate);
        }
        return movieToUpdate;
    }

    public Boolean delete(String id) {
        repository.deleteById(id);
        Boolean deleted = true;
        return deleted;
    }
}