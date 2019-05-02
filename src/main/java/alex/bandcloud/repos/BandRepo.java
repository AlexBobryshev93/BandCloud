package alex.bandcloud.repos;

import alex.bandcloud.model.Band;
import org.springframework.data.repository.CrudRepository;

public interface BandRepo extends CrudRepository<Band, Long> {

}
