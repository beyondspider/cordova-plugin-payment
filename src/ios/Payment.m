/********* Payment.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface Payment : CDVPlugin {
  // Member variables go here.
}

- (void)openAlipay:(CDVInvokedUrlCommand*)command;
@end

@implementation Payment

- (void)openAlipay:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* payUrl = [command.arguments objectAtIndex:0];

    if (payUrl != nil && [payUrl length] > 0) {
        NSString *url = [NSString stringWithFormat:@"alipayqr://platformapi/startapp?saId=10000007&qrcode=%@", payUrl];
        
        BOOL ret =[[UIApplication sharedApplication] openURL:[NSURL URLWithString:url]];
        if (ret == YES) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:payUrl];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
