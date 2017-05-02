package com.paysbuy.payapisdk.test.payment;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		AliveTest.class,
		GetTokenTest.class,
		ChargeTest.class,
		CaptureTest.class,
})

public class PaymentServiceTest {
	//Leave it empty. It's just a holder class
}
