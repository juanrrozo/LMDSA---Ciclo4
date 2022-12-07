package ciclo4.proyecto.web;


import ciclo4.proyecto.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ciclo4.proyecto.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Movie")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getMovies(){
        return movieService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Movie> getMovie(@PathVariable("id")int id){
        return movieService.getMovie(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie save(@RequestBody Movie c){
        return movieService.save(c);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Movie update(@RequestBody Movie c){
        return movieService.update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id")int MovieId){
        return movieService.deleteMovie(MovieId);
    }
}
