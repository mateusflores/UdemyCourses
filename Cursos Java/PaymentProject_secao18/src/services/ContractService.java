package services;

import entities.Contract;
import entities.Installment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public OnlinePaymentService getOnlinePaymentService() {
        return onlinePaymentService;
    }

    public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) throws ParseException {
        Double actualFee;
        Double actualInterest;
        Double feeValueWithoutTax = (contract.getTotalValue() / months);
        Date installmentDate;

        for (int i = 1; i <= months; i++) {
            actualInterest = this.onlinePaymentService.interest(feeValueWithoutTax, i);
            actualFee = this.onlinePaymentService.paymentFee(actualInterest);

            // Need to add months to this date !!!
            installmentDate = contract.getDate();

            contract.addInstallment(new Installment(installmentDate, actualFee));
        }
    }
}
