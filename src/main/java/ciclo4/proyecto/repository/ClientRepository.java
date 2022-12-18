/*
 @autor Juan
 */
package ciclo4.proyecto.repository;

import ciclo4.proyecto.Crud.CrudClientRepository;
import ciclo4.proyecto.entities.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClientRepository {
    
    @Autowired
    CrudClientRepository repository;
    
    public Iterable<Client> getAll(){
        return repository.findAll();
    }
    
    public Optional<Client> findById(String id){
        Optional<Client> response= repository.findById(id);
        return response;
    }

    public Optional<Client> findByEmail(String email){
        Optional<Client> response= repository.findByEmail(email);
        return response;
    }
    
    public Boolean existsById(String id){
        return repository.existsById(id);
    }
    
    public void deleteById(String id){
        repository.deleteById(id);
    }
    
    public Client save(Client client){
        return repository.save(client);
    }
    
}
