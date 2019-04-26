function openAlipay(success, error, opts) {
  success(opts[0]);
}

module.exports = {
  openAlipay: openAlipay
};

require("cordova/exec/proxy").add("Payment", module.exports);
