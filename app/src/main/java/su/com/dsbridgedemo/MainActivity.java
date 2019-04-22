package su.com.dsbridgedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button js调用安卓 = findViewById(R.id.js调用安卓);
        Button 安卓调用js = findViewById(R.id.安卓调用js);

        js调用安卓.setOnClickListener(this);
        安卓调用js.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.js调用安卓:
                startActivity(new Intent(this,JsCallAndroidActivity.class));
                break;
            case R.id.安卓调用js:
                startActivity(new Intent(this,AndroidCallJsActivity.class));
                break;
        }
    }
}
