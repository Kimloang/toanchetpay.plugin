[ToanChetPaySanbox-API-DOC]: https://toanchetpay.acledabank.com.kh/toanchetpay/sandbox
# Toanchet Pay Plugin (Java)

[![Java](https://img.shields.io/badge/Java-8%2B-orange)](https://www.java.com/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

> **⚠️ Disclaimer**: This is an **unofficial** library developed independently based on the official ACLEDA Toanchet Pay API documentation. This project is **not** affiliated with, maintained by, or endorsed by ACLEDA Bank.

A lightweight Java library for integrating **ACLEDA Bank's Toanchet Pay** payment gateway. This plugin simplifies the process of generating payment links, handling KHQR strings, and verifying transaction statuses with automatic HMAC signature generation.

## 📋 Features

* **Payment Link Generation (Deeplink)**: Create secure checkout URLs for mobile app integration.
* **KHQR Support**: Generate KHQR strings for compliant mobile banking scanning.
* **MPGS Integration**: Support for Mastercard Payment Gateway Services transactions.
* **Transaction Status**: Verify payment status programmatically via paymentTokenId ID.
* **Security**: Automatic HMAC signature generation and request validation.

## 🛠 Prerequisites

* **Java**: JDK 8 or higher
* **Build Tool**: Maven or Gradle
* **ACLEDA Credentials**: You must have a Merchant Account with:
    * Merchant ID
    * Login ID
    * Password
    * API Key
    * Secret Key

## 📦 Installation

Since this is a custom plugin, you must install it into your local repository or configure your private Nexus/Artifactory server.

### Maven

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.kimloang</groupId>
    <artifactId>toanchetpay-java-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Gradle

Add the dependency to your `build.gradle`:

```xml
implementation("io.github.kimloang:toanchetpay-java-sdk:1.0.1")
```

## Documentation
Please see the [ToanChetPaySanbox-API-DOC] docs for the most up-to-date **API** documentation.

Configuration (ToanchetPayRoot)
All service calls require an instance of ToanchetPayRoot. This class holds your merchant credentials and acts as the configuration entry point.
```java
ToanchetPayRoot toanchetConfig = new ToanchetPayRoot(
    "[https://epayment.acledabank.com.kh](https://epayment.acledabank.com.kh)", // Base URL (UAT or PROD)
    "YOUR_LOGIN_ID",
    "YOUR_PASSWORD",
    "YOUR_MERCHANT_ID",
    "YOUR_SECRET_KEY"
);
```
Initialize the SDK
Create the master SDK instance using your configuration.
```java
ToanchetPaySdk sdk = new ToanchetPaySdk(toanchetConfig);
```

## Generate a Deeplink Request
Use the apiService to generate a payment request.

```java 
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.ToanchetPaySdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentExample {
    public static void main(String[] args) {
        try {
            // 1. Set Up Credentials
            ToanchetPayRoot toanchetConfig = new ToanchetPayRoot(
                "https://epaymentuat.acledabank.com.kh", // Base URL (Ensure no trailing slash if SDK adds it)
                "YOUR_LOGIN_ID",
                "YOUR_PASSWORD",
                "YOUR_MERCHANT_ID",
                "YOUR_SECRET_KEY"
            );

            // 2. Initialize SDK
            ToanchetPaySdk sdk = new ToanchetPaySdk(toanchetConfig);

            // 3. Setup Request Object
            ToanchetDeeplinkRequest request = new ToanchetDeeplinkRequest(toanchetConfig);
            ToanchetDeeplinkRequest.XPayTransaction transaction = new ToanchetDeeplinkRequest.XPayTransaction();

            // 4. Populate Transaction Details
            String uniqueTxnId = "TXN-" + System.currentTimeMillis();
            String todayDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

            transaction.setTxid(uniqueTxnId);
            transaction.setPurchaseAmount("4000");
            transaction.setPurchaseCurrency("KHR");
            transaction.setPurchaseDate(todayDate); // Dynamic Date
            transaction.setPurchaseDesc("Mobile Payment");
            transaction.setInvoiceid("INV-" + System.currentTimeMillis());
            transaction.setItem(1);
            transaction.setQuantity(1);
            transaction.setExpiryTime(10); // Minutes
            transaction.setPaymentCard("0");
            transaction.setOprDevice("android");
            transaction.setCallBackUrl("appmobile://merchant.com.kh/callback"); 
            transaction.setCompName("YOUR_COMPANY_NAME");

            request.setXpayTransaction(transaction);

            // 5. Execute Call
            ToanChetDeepLinkRespond response = sdk.apiService.deeplink(request);

            // 6. Handle Response
            if (response != null) {
                System.out.println("Payment Link: " + response.getResult().getDeeplinkUrl());
                System.out.println("Status Code: " + response.getResult().getCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
## Generate a KHQR Request
```java 
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.ToanchetPaySdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentExample {
    public static void main(String[] args) {
        try {
            // 1. Set Up Credentials
            ToanchetPayRoot toanchetConfig = new ToanchetPayRoot(
                "https://epaymentuat.acledabank.com.kh", // Base URL (Ensure no trailing slash if SDK adds it)
                "YOUR_LOGIN_ID",
                "YOUR_PASSWORD",
                "YOUR_MERCHANT_ID",
                "YOUR_SECRET_KEY"
            );

            // 2. Initialize SDK
            ToanchetPaySdk sdk = new ToanchetPaySdk(toanchetConfig);

            // 3. Setup Request Object
            ToanchetKhQrRequest request = new ToanchetKhQrRequest(toanchetConfig);
            ToanchetKhQrRequest.XpayTransaction transaction = new ToanchetKhQrRequest.XpayTransaction();

            // 4. Populate Transaction Details
            String uniqueTxnId = "TXN-" + System.currentTimeMillis();
            String todayDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

            transaction.setTxid(uniqueTxnId);
            transaction.setPurchaseAmount("4000");
            transaction.setPurchaseCurrency("KHR");
            transaction.setPurchaseDate(todayDate); // Dynamic Date
            transaction.setPurchaseDesc("Mobile Payment");
            transaction.setInvoiceid("INV-" + System.currentTimeMillis());
            transaction.setItem(1);
            transaction.setQuantity(1);
            transaction.setExpiryTime(10); // Minutes
            request.setXpayTransaction(transaction);

            // 5. Execute Call
            ToanchetKhQrRespond response = sdk.apiService.generateKhQr(request);

            // 6. Handle Response
            if (response != null) {
                System.out.println("KHQR Link: " + response.getResult().getQrValue());
                System.out.println("Status Code: " + response.getResult().getCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

## Check Transaction Status (Standard)
Use this method for standard payment transactions. The response map  to `ToanchetCheckTransactionRespond`.

```java
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.ToanchetPaySdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentExample {
    public static void main(String[] args) {
        try {
            try {
                // 1. Set Up Credentials
                ToanchetPayRoot toanchetConfig = new ToanchetPayRoot(
                        "https://epaymentuat.acledabank.com.kh", // Base URL (Ensure no trailing slash if SDK adds it)
                        "YOUR_LOGIN_ID",
                        "YOUR_PASSWORD",
                        "YOUR_MERCHANT_ID",
                        "YOUR_SECRET_KEY"
                );

                // 2. Initialize SDK
                ToanchetPaySdk sdk = new ToanchetPaySdk(toanchetConfig);

                // 3. Setup Request Object
                ToanChetGetTransactionStatusRequest request = new ToanChetGetTransactionStatusRequest(toanchetConfig,
                        "YOUR_PAYMENT_TOKENID","YOUR_MERCHANT_NAME");
                // 4. Execute Call
                ToanchetCheckTransactionRespond response = sdk.apiService.checkTransactionStatus(request, ToanchetCheckTransactionRespond.class);

                // 5. Handle Response
                if (response != null) {
                    System.out.println("KHQR Link: " + response.getResult().getErrorDetails());
                    System.out.println("Status Code: " + response.getResult().getCode());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

```

##  Check Transaction Status (MPGS)
Since there are two type of Respond of Different of context

Since  **MPGS** Has one Object Call **getTxnStatusMPGS** To archive you have to use this 
Object `ToanchetMPGSCheckTransctaionRespond`

```java
import toanchetpay.plugin.dto.request.ToanchetDeeplinkRequest;
import toanchetpay.plugin.dto.respond.ToanChetDeepLinkRespond;
import toanchetpay.plugin.client.ToanchetPayRoot;
import toanchetpay.plugin.ToanchetPaySdk;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentExample {
    public static void main(String[] args) {
        try {
            try {
                // 1. Set Up Credentials
                ToanchetPayRoot toanchetConfig = new ToanchetPayRoot(
                        "https://epaymentuat.acledabank.com.kh", // Base URL (Ensure no trailing slash if SDK adds it)
                        "YOUR_LOGIN_ID",
                        "YOUR_PASSWORD",
                        "YOUR_MERCHANT_ID",
                        "YOUR_SECRET_KEY"
                );

                // 2. Initialize SDK
                ToanchetPaySdk sdk = new ToanchetPaySdk(toanchetConfig);

                // 3. Setup Request Object
                ToanChetGetTransactionStatusRequest request = new ToanChetGetTransactionStatusRequest(toanchetConfig,
                        "YOUR_PAYMENT_TOKENID","YOUR_MERCHANT_NAME");
                // 4. Execute Call
                ToanchetMPGSCheckTransctaionRespond response = sdk.apiService.checkTransactionStatus(request, ToanchetMPGSCheckTransctaionRespond.class);
                // 5. Handle Response
                if (response != null) {
                    System.out.println("KHQR Link: " + response.getResult().getErrorDetails());
                    System.out.println("Status Code: " + response.getResult().getCode());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}

```


