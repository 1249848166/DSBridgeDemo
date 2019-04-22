package su.com.dsbridgedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wendu.dsbridge.DWebView;

public class JsCallAndroidActivity extends AppCompatActivity {

    DWebView dWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_android);

        dWebView=findViewById(R.id.webview);
        DWebView.setWebContentsDebuggingEnabled(true);
        dWebView.addJavascriptObject(new JsApi(), null);
        dWebView.addJavascriptObject(new JsEchoApi(),"echo");
        dWebView.loadUrl("file:///android_asset/js-call-native.html");
    }
}
