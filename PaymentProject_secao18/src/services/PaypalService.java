package services;

public class PaypalService implements OnlinePaymentService{
    private static final Double taxFee = 0.02;
    private static final Double taxInterest = 0.01;

    @Override
    public Double paymentFee(Double amount) {
        return amount + amount * taxFee;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount + amount * taxInterest * months;
    }
}
