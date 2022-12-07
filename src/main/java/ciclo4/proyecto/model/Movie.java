package ciclo4.proyecto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "Movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Category categories;
    @ManyToOne
    @JoinColumn(name = "staff_list_id")
    private Staff staffList;

    public Staff getStaffList() {
        return staffList;
    }

    public void setStaffList(Staff staffList) {
        this.staffList = staffList;
    }

    public Category getCategories() {
        return categories;
    }

    public void setCategories(Category categories) {
        this.categories = categories;
    }

    public Movie() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}









