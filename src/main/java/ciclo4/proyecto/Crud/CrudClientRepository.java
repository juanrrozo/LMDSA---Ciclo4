/*
 @autor Juan
 */
package ciclo4.proyecto.Crud;


import ciclo4.proyecto.entities.Client;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CrudClientRepository extends CrudRepository<Client, String> {
    @Query(value= "{email : ?0}")
    Optional<Client> findByEmail(String email);
}
