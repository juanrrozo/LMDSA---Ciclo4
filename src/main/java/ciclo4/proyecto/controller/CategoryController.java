/*
 @autor Juan
 */
package ciclo4.proyecto.controller;

import ciclo4.proyecto.dto.ResponseDto;
import ciclo4.proyecto.entities.Category;
import ciclo4.proyecto.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping("")
    public Iterable<Category> get() {
        Iterable<Category> response = service.get();
        return response;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto create(@RequestBody Category request) {
        return service.create(request);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Category update(@RequestBody Category request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}
