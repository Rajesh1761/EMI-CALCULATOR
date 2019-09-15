package com.banking.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.banking.loan.exception.ApiException;
import com.banking.loan.model.LoanRequest;
import com.banking.loan.model.LoanResponse;
import com.banking.loan.service.CalculationService;
import com.banking.util.Constants;

@RestController
public class CalculationController {
	
	@Autowired
	CalculationService calculationService;

	@PostMapping("generate-plan")
    @ResponseStatus(code = HttpStatus.OK)
    public List<LoanResponse> generatePaymentPlan(@RequestBody final LoanRequest request) {
		validationRequestObject(request);
        return calculationService.generatePaymentPlan(request);
    }
	
	private void validationRequestObject(LoanRequest request){
		if (request.getLoanAmount() <= 0)
			throw new ApiException(
					Constants.AMOUNT_MSG,
					HttpStatus.BAD_REQUEST);

		if (request.getNominalRate() <= 0)
			throw new ApiException(
					Constants.NOMINAL_MSG,
					HttpStatus.BAD_REQUEST);

		if (request.getDuration() <= 0)
			throw new ApiException(Constants.DURATION_MSG
					,
					HttpStatus.BAD_REQUEST);

		if (request.getStartDate() == null || request.getStartDate().isEmpty())
			throw new ApiException(Constants.START_DATE_MSG,
					HttpStatus.BAD_REQUEST);
	}
}
