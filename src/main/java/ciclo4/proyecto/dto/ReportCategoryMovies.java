/*
 @autor Juan
 */
package ciclo4.proyecto.dto;

import ciclo4.proyecto.entities.Category;
import ciclo4.proyecto.service.MovieService;


import java.util.List;

public class ReportCategoryMovies {
    Category category;
    List<MovieService> moviesList;
}
