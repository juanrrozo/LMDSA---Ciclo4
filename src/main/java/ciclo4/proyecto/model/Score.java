package ciclo4.proyecto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Score")
public class Score implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

     private Integer id;
    private Integer score;
    private String state;

    private String testdata;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTestdata() {
        return testdata;
    }

    public void setTestdata(String testdata) {
        this.testdata = testdata;
    }

    @ManyToOne
    @JoinColumn(name = "client_id_client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
