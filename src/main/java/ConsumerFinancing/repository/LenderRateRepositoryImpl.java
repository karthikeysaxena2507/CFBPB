package ConsumerFinancing.repository;

import ConsumerFinancing.entity.LenderRate;
import ConsumerFinancing.repository.custom.CustomLenderRateRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class LenderRateRepositoryImpl implements CustomLenderRateRepository {

    private final MongoTemplate mongoTemplate;

    public LenderRateRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<LenderRate> getLenderRates(
            String livingStatus,
            String lenderName,
            int assetAge,
            int creditScore) {

        Query query = new Query();
        query.addCriteria(Criteria.where("livingStatus").is(livingStatus));
        query.addCriteria(Criteria.where("lenderName").is(lenderName));
        query.addCriteria(Criteria.where("assetAge").is(assetAge));
        query.addCriteria(Criteria.where("maxCreditScore").gte(creditScore));
        query.addCriteria(Criteria.where("minCreditScore").lte(creditScore));
        return mongoTemplate.find(query, LenderRate.class);
    }
}
