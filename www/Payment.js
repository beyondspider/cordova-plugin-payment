var exec = require("cordova/exec");

exports.openAlipay = function(arg0, success, error) {
  exec(success, error, "Payment", "openAlipay", [arg0]);
};
