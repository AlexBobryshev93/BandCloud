package alex.bandcloud.repos;

import alex.bandcloud.model.Band;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BandRepo extends CrudRepository<Band, Long> {
    List<Band> findDistinctByGenre(Band.Genre genre);
    Band findFirstByName(String name);
}
