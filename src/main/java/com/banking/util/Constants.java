package com.banking.util;

import java.math.BigDecimal;

public interface Constants {
	BigDecimal DAYS_PER_MONTH = BigDecimal.valueOf(30);
	BigDecimal DAYS_PER_YEAR = BigDecimal.valueOf(360);
	int DECIMALS = 2;
	int PAYMENTS_PER_YEAR = 12;
	String AMOUNT_MSG="The loan amount is required and it cannot be a negative number or zero.";
	String NOMINAL_MSG="The nominal rate is required and it cannot be a negative number or zero.";
	String DURATION_MSG="The duration is required and it cannot be a negative number or zero.";
	String START_DATE_MSG="Please provide the start date.";
}
