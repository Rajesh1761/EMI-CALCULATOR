package com.banking.loan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.loan.model.PaymentPerMonth;
import com.banking.loan.model.LoanRequest;
import com.banking.loan.model.LoanResponse;
@Service
public class CalculationService {
	
	public List<LoanResponse> generatePaymentPlan(final LoanRequest request) {
		final List<PaymentPerMonth> paymentPerMonthList = generatePaymentPlanList(request);
		return generateResponseList(paymentPerMonthList);

	}

    private List<PaymentPerMonth> generatePaymentPlanList(final LoanRequest request) {

        final List<PaymentPerMonth> paymentPerMonthList = new ArrayList<>();
        paymentPerMonthList.add(firstMonth(request));
        paymentPerMonthList.addAll(remainingMonths(request, paymentPerMonthList.get(0)));
        return paymentPerMonthList;
    }

    private List<PaymentPerMonth> remainingMonths(final LoanRequest request, PaymentPerMonth previousPaymentPerMonth) {

        final List<PaymentPerMonth> paymentPerMonthList = new ArrayList<>();

        for (int counter = 1; counter < request.getDuration(); counter++) {
            previousPaymentPerMonth = new PaymentPerMonth(request, previousPaymentPerMonth, counter);
            paymentPerMonthList.add(previousPaymentPerMonth);
        }

        return paymentPerMonthList;
    }

    private PaymentPerMonth firstMonth(final LoanRequest request) {
        return new PaymentPerMonth(request);
    }

    private List<LoanResponse> generateResponseList(final List<PaymentPerMonth> paymentPerMonthList) {

        final List<LoanResponse> responseList = new ArrayList<>();

        for (final PaymentPerMonth paymentPerMonth : paymentPerMonthList) {
            final LoanResponse response = new LoanResponse(paymentPerMonth);
            responseList.add(response);
        }

        return responseList;
    }
}
