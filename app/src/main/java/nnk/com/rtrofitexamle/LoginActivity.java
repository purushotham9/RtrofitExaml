package nnk.com.rtrofitexamle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nnk.com.rtrofitexamle.Interface.IService;
import nnk.com.rtrofitexamle.Model.UserAtenticationModel;
import nnk.com.rtrofitexamle.Model.UserModel;
import nnk.com.rtrofitexamle.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private UserAtenticationModel userAutenticationModel; //login
    private Service service; //Conexao
    private ProgressDialog progressDialog;
    private IService iService; //EmpresaService

    private Button loginButton;

    private EditText emailInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iService = service.serviceConnectionRetrofit();

        loginButton = (Button) findViewById(R.id.loginButtonBt);

        emailInput = (EditText) findViewById(R.id.emailInputEd);
        passwordInput = (EditText) findViewById(R.id.passwordInputEd);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticate(emailInput.getText().toString().trim(), passwordInput.getText().toString().trim());
                finish();
            }
        });
    }

    public void authenticate(String email, String password){

        progressDialog = ProgressDialog.show(this, "Entering", "Welcome", true);
        progressDialog.setCancelable(false);

        userAutenticationModel = new UserAtenticationModel(email, password);
        Call call = iService.authenticate(userAutenticationModel);
        call.enqueue(new Callback<UserAtenticationModel>() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.isSuccessful()) {

                    UserModel userModel = new UserModel(response.headers().get("access-token"), response.headers().get("client"),
                            response.headers().get("uid"));

                    Toast.makeText(getBaseContext(), "Welcome", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    intent.putExtra("access-token", userModel.getAccess_token());
                    intent.putExtra("client", userModel.getClient());
                    intent.putExtra("uid", userModel.getUid());

                    //progressDialog.dismiss();
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "User or password is incorrect!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getBaseContext(), "Error Server, try again!", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
