package payment;

import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;

public class paymentObject {

	private Payment payment;
	private Payer payer;
	private Details details;
	private Amount amount;
	Transaction transaction;
	private List<Transaction> transactions;
	private RedirectUrls redirectUrls;

	public paymentObject() {

	}

	public Payer setPayerDetails() {
		// Set payer details
		payer = new Payer();
		payer.setPaymentMethod("paypal");
		return payer;
	}

	// Set redirect URLs
	public void getLinks() {
		redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:3000/cancel");
		redirectUrls.setReturnUrl("http://localhost:3000/process");
		
	}

	// Set payment details
	public Details setPaymentDetails() {

		details = new Details();
		details.setShipping("1");
		details.setSubtotal("5");
		details.setTax("1");
		return details;
	}

	// Payment amount
	// we have to get the details object ready before calling this methods
	public Amount paymentsAmount() {
		amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("7");
		amount.setDetails(this.details);
		return amount;
	}

	// Transaction information
//	 we need the amount object before calling this method 
	public Transaction getTransactionInformation() {
		transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("This is the payment transaction description.");
		return transaction;
	}

	// Add transaction to a list
	// we need to pass the transaction object that we have created above to this
	// method
	public List<Transaction> AddTransactionToList() {
		transactions = new ArrayList<Transaction>();
		transactions.add(transaction);
		return transactions;
	}

	// Add payment details
	// we need the transaction and the redirectURL to be initialised before this method 
	public Payment addPaymentDetails() {

		payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setRedirectUrls(redirectUrls);
		payment.setTransactions(transactions);
		return payment;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Payer getPayer() {
		return payer;
	}

	public void setPayer(Payer payer) {
		this.payer = payer;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public RedirectUrls getRedirectUrls() {
		return redirectUrls;
	}

	public void setRedirectUrls(RedirectUrls redirectUrls) {
		this.redirectUrls = redirectUrls;
	}

}
