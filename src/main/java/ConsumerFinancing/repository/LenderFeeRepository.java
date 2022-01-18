package ConsumerFinancing.repository;

import ConsumerFinancing.entity.LenderFee;
import ConsumerFinancing.repository.custom.CustomLenderFeeRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenderFeeRepository
        extends MongoRepository<LenderFee, String>, CustomLenderFeeRepository {
}
