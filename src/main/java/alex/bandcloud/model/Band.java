package alex.bandcloud.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Band {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private Genre genre;

    public enum Genre {
        ROCK, METAL, CHANSON, POP, JAZZ, HIP_HOP
    }

}
