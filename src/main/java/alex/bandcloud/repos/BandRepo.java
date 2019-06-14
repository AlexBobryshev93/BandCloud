package alex.bandcloud.repos;

import alex.bandcloud.model.Band;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BandRepo extends CrudRepository<Band, Long> {
    Band findFirstByName(String name);
}
