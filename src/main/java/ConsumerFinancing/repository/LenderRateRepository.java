package ConsumerFinancing.repository;

import ConsumerFinancing.entity.LenderRate;
import ConsumerFinancing.repository.custom.CustomLenderRateRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderRateRepository
        extends MongoRepository<LenderRate, String>, CustomLenderRateRepository {

}
