package ConsumerFinancing.repository.custom;

import ConsumerFinancing.entity.LenderFee;

import java.util.List;

public interface CustomLenderFeeRepository {

    List<LenderFee> getTotalFees(Integer loanRepayment, String lenderName);

}
