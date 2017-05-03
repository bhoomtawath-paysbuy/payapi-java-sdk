# Paysbuy PayAPI - Java SDK

`payapi-sdk` allows you to use [Paysbuy PayAPI]() easily within your PHP projects

# Prerequisite

* Java version > 1.8

# Installation

## Using Maven
Add following part to your dependencies inside pom.xml
```xml
<dependencies>
    ...
    <dependency>
      <groupId>com.paysbuy.payapisdk</groupId>
      <artifactId>payapi-sdk</artifactId>
      <version>1.0</version>
    </dependency>
    ...
</dependencies>
``` 
# Usage

## Charging

A payment can be charged with `PaymentService.charge` method, which will return `PaymentResponse` as a respond.
```java
import com.paysbuy.payapisdk.PaymentService;
import com.paysbuy.payapisdk.models.ChargeAttributes;
import com.paysbuy.payapisdk.models.PaymentResponse;

class App {
    public static void main(String args[]) {
    	try {
    		// Setting an API key for the payment service
            PaymentService paymentService = new PaymentService("<secret api key>");
            
            // Set attributes that define the payment
            ChargeAttributes chargeAttributes = new ChargeAttributes();        
            chargeAttributes.setCurrency("THB");
            chargeAttributes.setAmount(100.5);
            chargeAttributes.setToken("tok_1234");
            // Set a reference to the invoice
            chargeAttributes.setInvoice("invoice no.");
           
            // Capture the payment immediately after the authorization is passed
            chargeAttributes.setCapture(true);
            
            // *Optional* set description and meta for the payment
            chargeAttributes.setDescription("Description");
            chargeAttributes.setMeta("Meta");                      
            
            // Charging a payment with the supplied attributes
            PaymentResponse pr = paymentService.charge(chargeAttributes);
        } catch (java.io.IOException e) {
    		    // Handle an exception
        }
    }
}
```
> **Note:**
> **chargeAttributes's capture is true by default** and will cause the payment to be captured immediately after the payment is authorized.
> If chargeAttributes's capture is set to **false** by `chargeAttributes.setCapture(false);`.
> Then the transaction will not be captured and need to by captured by calling `paymentService.capture("<payment token>");`

## Capturing a payment Manually

A payment that is authorized, but is not captured yet can be captured manually with `paymentService.capture` method.

```java
class App {
    public static void main(String args[]) {
    	try {
    		//Charging without capturing
            ChargeAttributes chargeAttributes = new ChargeAttributes();        
            chargeAttributes.setCurrency("THB");
            chargeAttributes.setAmount(100.5);
            chargeAttributes.setToken("tok_1234");
            chargeAttributes.setInvoice("Invoice");
            //capture is set false to prevent the payment from being captured automatically
            chargeAttributes.setCapture(false);
            PaymentService paymentService = new PaymentService("<secret api key>");
            PaymentResponse pr = paymentService.charge(chargeAttributes);
            
            String paymentToken = pr.getObject().getPayment().getId();
            /*
              ...
              Code for saving paymentToken should be here
              ...
            */
            
            // Now, we capture the payment
            paymentService.capture(paymentToken);
        } catch (java.io.IOException e) {
    		// Handle an error
        }
    }
}
```

## Retrieving a payment

A payment can be retrieved using a paymentId with `paymentService.getPayment` method.
```java
    paymentService.getPayment(paymentId);
```

> **Note:**
> Usage and examples are inside `src/test/java/com/paysbuy/payapisdk/test/payment`

> **Warning:**
> **id** from `paymentResponse.getObject().getPayment().getId()` is ID of the payment and should be saved for later usage such as retrieving or capturing.



