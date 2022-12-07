package ciclo4.proyecto.service;


import ciclo4.proyecto.model.Movie;
import ciclo4.proyecto.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAll(){
        return movieRepository.getAll();
    }

    public Optional<Movie> getMovie(int id){
        return movieRepository.getMovie(id);
    }
    public Movie save(Movie c){
        if (c.getId() == null){
            return movieRepository.save(c);
        }else{
            Optional<Movie> movieaux= movieRepository.getMovie(c.getId());
            if (movieaux.isEmpty()){
                return movieRepository.save(c);
            }else{
                return c;
            }
        }
    }
    public Movie update(Movie c){
        if(c.getId()!=null){
            Optional<Movie> movieup= movieRepository.getMovie(c.getId());
            if(!movieup.isEmpty()){
                if (c.getName()!=null){
                    movieup.get().setName(c.getName());
                }
                movieRepository.save(movieup.get());
                return movieup.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean deleteMovie(int movieId){
        Boolean succes=getMovie(movieId).map(c ->{
            movieRepository.delete(c);
            return true;
        }).orElse(false);
        return succes;
    }

}
