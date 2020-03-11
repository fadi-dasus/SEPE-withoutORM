package payment;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentCreation {

	public static final String clientID = "Aco76YrSixRHvke9vvKJ4vwhivkkklcMA6mMT6LAaUeIN76mrpu5XfjD6AnDlkvnKIC-nfH9EWKBh5xW";
	public static final String clientSecret = "EPnItkPLzQVOK6dmKatRbyCREvhzGcf6VRQHE89nHFN2LSBW4I5QEs7fiXbQKXNNotAI9D469mFG4VwI";
	public static final String mode = "sandbox";

	APIContext apiContext = new APIContext(clientID, clientSecret, mode);

	paymentObject paymentObject = new paymentObject();
	Payment createdPayment = paymentObject.getPayment();

	public PaymentCreation() {
		try {

			
			createdPayment.create(apiContext);

			Iterator links = createdPayment.getLinks().iterator();
			while (links.hasNext()) {
				Links link = (Links) links.next();
				if (link.getRel().equalsIgnoreCase("approval_url")) {
					// Redirect the customer to link.getHref()
				}
			}
		} catch (PayPalRESTException e) {
			System.err.println(e.getDetails());
		}
	}

	public void executePayment(HttpServletRequest req) {
		
		createdPayment.setId(req.getParameter("paymentId"));

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(req.getParameter("PayerID"));
		try {
			createdPayment.execute(apiContext, paymentExecution);
			System.out.println(createdPayment);
		} catch (PayPalRESTException e) {
			System.err.println(e.getDetails());
		}
	}

}
