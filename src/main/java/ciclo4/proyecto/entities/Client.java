/*
 @autor Juan
 */
package ciclo4.proyecto.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Document("client")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private String id;
    private String email;
    //@JsonIgnore
    private String password;
    private String name;
    private String lastName;
    private String birthDate;
    private String phone;
    
    //@OneToMany(cascade={CascadeType.PERSIST},mappedBy="messa<ge")
    //@JsonIgnoreProperties("message")
//    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
//    @JsonIgnoreProperties({"quadbike","client"})
//    private List<Message> messages;
//
//    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="client")
//    @JsonIgnoreProperties("client")
//    private List<Reservation> reservations;
    
    
    
}
