/*
 @autor Juan
 */
package ciclo4.proyecto.controller;

import ciclo4.proyecto.dto.AuthDto;
import ciclo4.proyecto.dto.AuthResponseDto;
import ciclo4.proyecto.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    AuthService service;

    @PostMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AuthResponseDto check(@RequestBody AuthDto request) {
        return service.check(request);
    }

}
