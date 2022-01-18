package ConsumerFinancing.repository;

import ConsumerFinancing.entity.Income;
import ConsumerFinancing.repository.custom.CustomIncomeRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository
        extends MongoRepository<Income, String>, CustomIncomeRepository {
}
