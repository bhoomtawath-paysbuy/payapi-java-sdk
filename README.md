**Paysbuy PayAPI - Java SDK**
===
`payapi-sdk` allows you to use [Paysbuy PayAPI]() easily within your PHP projects

**Prerequisite**
===
* Java version > 1.8

**Installation**
===
**Using Maven**
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
**Usage**
===
**Charging**

A payment can be charged with `PaymentService.charge` method, which will return `PaymentResponse` as a respond.
```java
import com.paysbuy.payapisdk.PaymentService;
import com.paysbuy.payapisdk.models.ChargeAttributes;
import com.paysbuy.payapisdk.models.PaymentResponse;

class App {
    public static void main(String args[]) {
    	try {
            ChargeAttributes chargeAttributes = new ChargeAttributes();        
            chargeAttributes.setCurrency("THB");
            chargeAttributes.setAmount(100.5);
            chargeAttributes.setToken("tok_1234");
            chargeAttributes.setInvoice("Invoice");
            chargeAttributes.setCapture(true);
            PaymentService paymentService = new PaymentService("<secret api key>");
            PaymentResponse pr = paymentService.charge(chargeAttributes);
        } catch (java.io.IOException e) {
    		// Handle an error
        }
    }
}
```
If chargeAttributes's capture is set to false by `chargeAttributes.setCapture(false);`.
Then the transaction will not be captured and need to by captured by calling `PaymentService.capture("<payment token>");`

**Capturing a payment Manually**

A payment that is authorized, but is not captured yet can be captured manually with `Payment.Service.capture` method.

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
            
            String paymentId = pr.getObject().getPayment().getId();
            // Do something such as saving the paymentId            
            
            paymentService.capture(paymentId);
        } catch (java.io.IOException e) {
    		// Handle an error
        }
    }
}
```

*Retreiving a payment*
A payment can be retrieved using a paymentId with `paymentService.getPayment` method.
```java
    paymentService.getPayment(paymentId);
```

**Note**
Usage and examples are inside `src/test/java/com/paysbuy/payapisdk/test/payment`

**Warning**
*id* from `PaymentResponse.getObject().getPayment().getId()` is ID of the payment and should be saved for later usage such as retrieving or capturing.



