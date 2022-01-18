package ConsumerFinancing.repository;

import ConsumerFinancing.entity.LenderFee;
import ConsumerFinancing.repository.custom.CustomLenderFeeRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class LenderFeeRepositoryImpl implements CustomLenderFeeRepository {

    private final MongoTemplate mongoTemplate;

    public LenderFeeRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<LenderFee> getTotalFees(Integer loanRepayment, String lenderName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lenderName").is(lenderName));
        query.addCriteria(Criteria.where("minLoanAmount").lte(loanRepayment));
        query.addCriteria(Criteria.where("maxLoanAmount").gte(loanRepayment));
        return mongoTemplate.find(query, LenderFee.class);
    }
}
