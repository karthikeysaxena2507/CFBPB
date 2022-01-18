package ConsumerFinancing.repository;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.entity.Income;
import ConsumerFinancing.repository.custom.CustomIncomeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@Slf4j
public class IncomeRepositoryImpl
        extends AppConfig implements CustomIncomeRepository {

    private final MongoTemplate mongoTemplate;

    public IncomeRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Income> getMonthlyExpenses(
            Integer income,
            String region,
            String relationshipStatus,
            Integer dependentsCount) {

        log.info("income: {} \n", income);
        log.info("region: {} \n", region);
        log.info("relationshipStatus: {}", relationshipStatus);
        log.info("count of dependents: {}", getDependentsCount(dependentsCount));
        Query query = new Query();
        query.addCriteria(Criteria.where("region").is(region));
        query.addCriteria(Criteria.where("relationshipStatus").is(relationshipStatus));
        query.addCriteria(Criteria.where("dependentsCount").is(getDependentsCount(dependentsCount)));
        query.addCriteria(Criteria.where("minIncome").lte(income));
        query.addCriteria(Criteria.where("maxIncome").gte(income));
        return mongoTemplate.find(query, Income.class);
    }

    public Integer getTotalMonthlyExpenses(Income income, Integer dependentsCount) {
        Integer totalMonthlyIncome = income.getMonthlyIncome();
        log.info("Current Income is {}", income);
        Integer extraDependents = getExtraDependents(dependentsCount);
        log.info("No of Extra Dependents: {}", extraDependents);
        if (extraDependents > 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("region").is(income.getRegion()));
            query.addCriteria(Criteria.where("relationshipStatus").is(income.getRelationshipStatus()));
            query.addCriteria(Criteria.where("dependentsCount").is(ABOVE_4));
            query.addCriteria(Criteria.where("minIncome").lte(income.getMinIncome()));
            query.addCriteria(Criteria.where("maxIncome").gte(income.getMaxIncome()));
            List<Income> incomes = mongoTemplate.find(query, Income.class);
            if (!incomes.isEmpty()) {
                log.info("Extra Income is {}", incomes.get(0).getMonthlyIncome());
                totalMonthlyIncome += (incomes.get(0).getMonthlyIncome() * extraDependents);
            }
        }
        return totalMonthlyIncome;
    }

    public String getDependentsCount(Integer dependentsCount) {
        return (dependentsCount > 4) ? "4.0" : dependentsCount + ".0";
    }

    public Integer getExtraDependents(Integer dependentsCount) {
        return (dependentsCount <= 4) ? 0 : dependentsCount - 4;
    }

}
