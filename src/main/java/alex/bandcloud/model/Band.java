package alex.bandcloud.model;

import lombok.Data;

@Data
public class Band {
    private int id;
    private String name;
    private Genre genre;

    public static enum Genre {
        ROCK, METAL, CHANSON, POP, JAZZ, HIP_HOP
    }
}
