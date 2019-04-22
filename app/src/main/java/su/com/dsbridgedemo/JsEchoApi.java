package su.com.dsbridgedemo;

import android.webkit.JavascriptInterface;

import org.json.JSONException;

import wendu.dsbridge.CompletionHandler;

public class JsEchoApi {

    @JavascriptInterface
    public Object syn(Object args) throws JSONException {
        return  args;
    }

    @JavascriptInterface
    public void asyn(Object args,CompletionHandler handler){
        handler.complete(args);
    }
}
