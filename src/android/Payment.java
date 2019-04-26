package org.apache.cordova.payment;

import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class Payment extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("openAlipay")) {
            String message = args.getString(0);
            this.openAlipay(message, callbackContext);
            return true;
        }
        return false;
    }

    private void openAlipay(String payUrl, CallbackContext callbackContext) {
        if (payUrl != null && payUrl.length() > 0) {
            try {
              Intent intent = new Intent();
              intent.setAction("android.intent.action.VIEW");
              intent.setData(Uri.parse("alipayqr://platformapi/startapp?saId=10000007&qrcode=" + payUrl));
              cordova.getActivity().startActivity(intent);
            }
            catch (Exception e) {
              callbackContext.error(e.toString());
            }
            callbackContext.success(payUrl);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
