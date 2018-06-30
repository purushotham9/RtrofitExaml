package nnk.com.rtrofitexamle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView textDetailsEnterprise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textDetailsEnterprise = (TextView) findViewById(R.id.txtEnterprise);
        Bundle bundle = getIntent().getExtras();
        String nameEnterprise = (String) bundle.get("name");
        String detailsEnterprise = (String) bundle.get("details");
        setTitle(nameEnterprise);
        textDetailsEnterprise.setMovementMethod(new ScrollingMovementMethod());
        textDetailsEnterprise.setText(detailsEnterprise);
    }
}

