package com.sokha.fluttershowtoastsk;

import android.app.Activity;
import android.widget.Toast;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterShowToastSkPlugin */
public class FlutterShowToastSkPlugin implements MethodCallHandler {

  private final MethodChannel _channel;
  private Activity _activity;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_show_toast_sk");
    channel.setMethodCallHandler(new FlutterShowToastSkPlugin(registrar.activity(), channel));
  }


  private FlutterShowToastSkPlugin(Activity activity, MethodChannel channel) {
    this._activity = activity;
    this._channel = channel;
    this._channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    }
    else if (call.method.equals("showToast")) {

        String msg = call.argument("msg").toString();
        Toast.makeText(_activity, msg, Toast.LENGTH_LONG).show();
    }
    else {
      result.notImplemented();
    }
  }
}
