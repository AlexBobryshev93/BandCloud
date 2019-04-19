package alex.bandcloud;

import lombok.Data;

@Data
public class Band {

    private String name;
    private Genre genre;

    public static enum Genre {
        ROCK, METAL, CHANSON, POP, JAZZ, HIP_HOP
    }
}
