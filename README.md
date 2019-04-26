---
title: Payment
description: Payment Alipay.
---

# cordova-plugin-payment

Payment for cordova plugin.

## Supported Platforms

- Android
- iOS

## Install

```bash
cordova plugin add git+https://github.com/beyondspider/cordova-plugin-payment.git
cordova plugin rm cordova-plugin-payment
```

## Use

```javascript
cordova.plugins.Payment.openAlipay(
  "https://qr.alipay.com/xxxxyyyyzzzz",
  function(data) {
    alert("Payment:" + data);
    console.log("Payment:" + data);
  },
  function(error) {
    console.error(error);
  }
);
```

## License

Copyright (c) 2019 beyondspider

[MIT License](http://en.wikipedia.org/wiki/MIT_License)
