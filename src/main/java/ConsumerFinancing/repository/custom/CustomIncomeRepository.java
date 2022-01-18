package ConsumerFinancing.repository.custom;

import ConsumerFinancing.entity.Income;

import java.util.List;

public interface CustomIncomeRepository {

    List<Income> getMonthlyExpenses(
            Integer income,
            String region,
            String relationShipStatus,
            Integer dependentsCount
    );

    Integer getTotalMonthlyExpenses(Income income, Integer dependentsCount);

}
