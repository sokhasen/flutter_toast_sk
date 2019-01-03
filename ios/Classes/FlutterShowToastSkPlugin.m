#import "FlutterShowToastSkPlugin.h"
#import <flutter_show_toast_sk/flutter_show_toast_sk-Swift.h>

@implementation FlutterShowToastSkPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterShowToastSkPlugin registerWithRegistrar:registrar];
}
@end
