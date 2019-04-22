package su.com.dsbridgedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import wendu.dsbridge.DWebView;
import wendu.dsbridge.OnReturnValue;

public class AndroidCallJsActivity extends AppCompatActivity implements View.OnClickListener {

    DWebView dWebView;
    Button addValue,append,startTimer,synAddValue,synGetInfo,asynAddValue,asynGetInfo,
            hasMethodAddValue,hasMethodXX,hasMethodAsynAddValue,hasMethodAsynXX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_call_js);

        DWebView.setWebContentsDebuggingEnabled(true);
        dWebView= findViewById(R.id.webview);
        dWebView.loadUrl("file:///android_asset/native-call-js.html");

        addValue=findViewById(R.id.addValue);
        append=findViewById(R.id.append);
        startTimer=findViewById(R.id.startTimer);
        synAddValue=findViewById(R.id.synAddValue);
        synGetInfo=findViewById(R.id.synGetInfo);
        asynAddValue=findViewById(R.id.asynAddValue);
        asynGetInfo=findViewById(R.id.asynGetInfo);
        hasMethodAddValue=findViewById(R.id.hasMethodAddValue);
        hasMethodXX=findViewById(R.id.hasMethodXX);
        hasMethodAsynAddValue=findViewById(R.id.hasMethodAsynAddValue);
        hasMethodAsynXX=findViewById(R.id.hasMethodAsynXX);

        addValue.setOnClickListener(this);
        append.setOnClickListener(this);
        startTimer.setOnClickListener(this);
        synAddValue.setOnClickListener(this);
        synGetInfo.setOnClickListener(this);
        asynAddValue.setOnClickListener(this);
        asynGetInfo.setOnClickListener(this);
        hasMethodAddValue.setOnClickListener(this);
        hasMethodXX.setOnClickListener(this);
        hasMethodAsynAddValue.setOnClickListener(this);
        hasMethodAsynXX.setOnClickListener(this);
    }

    void showToast(Object o) {
        Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addValue:
                dWebView.callHandler("addValue", new Object[]{3, 4}, new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.append:
                dWebView.callHandler("append", new Object[]{"I", "love", "you"}, new OnReturnValue<String>() {
                    @Override
                    public void onValue(String retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.startTimer:
                dWebView.callHandler("startTimer", new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.synAddValue:
                dWebView.callHandler("syn.addValue", new Object[]{5, 6}, new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.synGetInfo:
                dWebView.callHandler("syn.getInfo", new OnReturnValue<JSONObject>() {
                    @Override
                    public void onValue(JSONObject retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.asynAddValue:
                dWebView.callHandler("asyn.addValue", new Object[]{5, 6}, new OnReturnValue<Integer>() {
                    @Override
                    public void onValue(Integer retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.asynGetInfo:
                dWebView.callHandler("asyn.getInfo", new OnReturnValue<JSONObject>() {
                    @Override
                    public void onValue(JSONObject retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodAddValue:
                dWebView.hasJavascriptMethod("addValue", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodXX:
                dWebView.hasJavascriptMethod("XX", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodAsynAddValue:
                dWebView.hasJavascriptMethod("asyn.addValue", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
            case R.id.hasMethodAsynXX:
                dWebView.hasJavascriptMethod("asyn.XX", new OnReturnValue<Boolean>() {
                    @Override
                    public void onValue(Boolean retValue) {
                        showToast(retValue);
                    }
                });
                break;
        }
    }
}
