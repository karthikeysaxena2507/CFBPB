package ConsumerFinancing.util;

import ConsumerFinancing.config.AppConfig;
import ConsumerFinancing.model.customers.Customer;
import ConsumerFinancing.service.LenderFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Slf4j
@Component
public class FormulaeUtil extends AppConfig {

    private final LenderFeeService lenderFeeService;

    public FormulaeUtil(
            LenderFeeService lenderFeeService) {
        this.lenderFeeService = lenderFeeService;
    }

    public double getComparisonRate(String lenderName, Double interestRate) {
        interestRate = interestRate * 0.01;
        double rate = comparisonRate(lenderName, interestRate) * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(rate));
    }

    public long getLoanRepayment(
            String lenderName, Double interestRate, String frequency, Customer customer) {

        int loanAmount = customer.getVehicle().getVehiclePrice()
                - customer.getVehicle().getDeposit();
        int loanTerm = customer.getVehicle().getLoanTerm();
        int totalAmount = loanAmount
                + fees(lenderName, loanAmount, loanTerm);
        interestRate = interestRate * 0.01;
        int frequencyValue = getFrequencyValue(frequency);
        double payment = pmt(interestRate, totalAmount, frequencyValue, loanTerm);
        log.info("Payment is {}", payment);
        return Math.round(payment);
    }

    public double nsr(Integer monthlyIncome, Integer monthlyExpenses, Double repayments) {
        double nsr = ((double) (monthlyIncome - monthlyExpenses) / repayments);
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(nsr));
    }

    private int fees(String lender, int loanSize, int term) {
        return lenderFeeService.getLenderFees(loanSize, lender);
    }

    private double pmt(double apr, int p, int n, int t) {
        return (p * (apr/n) / (1 - Math.pow(1 + (apr / n), -n * t)));
    }

    private double comparisonRate(String lender, double apr) {
        //standardised in AU, comparison rate variables
        int COMPARISON_RATE_TERM = 5;
        int COMPARISON_RATE_FREQUENCY = 12;
        int COMPARISON_RATE_PERIODS = COMPARISON_RATE_TERM * COMPARISON_RATE_FREQUENCY;
        int COMPARISON_RATE_LOAN_SIZE = 30000;

        double loanAndFees = COMPARISON_RATE_LOAN_SIZE +
                fees(lender, COMPARISON_RATE_LOAN_SIZE,
                        COMPARISON_RATE_TERM);

        double pmtMonthly = pmt(apr, loanAndFees,
                COMPARISON_RATE_FREQUENCY,
                COMPARISON_RATE_TERM);

        return rate(COMPARISON_RATE_PERIODS, pmtMonthly,
                COMPARISON_RATE_LOAN_SIZE) * 12;

    }

    private static double pmt(double apr, double p, int n, int t) {
        return (p * (apr / n) / (1 - Math.pow(1 + (apr / n), -n * t)));
    }

    private double rate(double nper, double pmt, double pv) {
        double error = 0.0000001;
        double high =  1.00;
        double low = 0.00;
        double rate = (2.0 * (nper * pmt - pv)) / (pv * nper);

        while (true) {
            // check for error margin
            double calc = Math.pow(1 + rate, nper);
            calc = (rate * calc) / (calc - 1.0);
            calc -= (pmt / pv);

            if (calc > error) {
                // guess too high, lower the guess
                high = rate;
                rate = (high + low) / 2;
            } else if (calc < -error) {
                // guess too low, higher the guess
                low = rate;
                rate = (high + low) / 2;
            } else {
                // acceptable guess
                break;
            }
        }
        return rate;
    }

    private int getFrequencyValue(String frequency) {
        switch (frequency) {
            case MONTHLY:
                return 12;
            case FORTNIGHTLY:
                return 26;
            case WEEKLY:
                return 52;
            default:
                return 1;
        }
    }

}
