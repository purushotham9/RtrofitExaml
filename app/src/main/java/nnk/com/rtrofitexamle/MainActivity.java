package nnk.com.rtrofitexamle;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import nnk.com.rtrofitexamle.Helpers.ListEnterprise;
import nnk.com.rtrofitexamle.Helpers.ListViewAdapter;
import nnk.com.rtrofitexamle.Interface.IService;
import nnk.com.rtrofitexamle.Model.EnterpriseModel;
import nnk.com.rtrofitexamle.Model.UserModel;
import nnk.com.rtrofitexamle.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private UserModel userModel;
    private IService iService; //EmpresaService
    private Service service; //Conexao
    private ListViewAdapter listViewAdapter;


    private ListView listViewEnterprise;
    private TextView txtStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iService = service.serviceConnectionRetrofit();

        listViewEnterprise = (ListView) findViewById(R.id.listViewEnterprise);
        txtStart = (TextView) findViewById(R.id.txtStart);
        listViewEnterprise.setEmptyView(txtStart);

        Bundle bundle = getIntent().getExtras();
        userModel = new UserModel((String) bundle.get("access-token"),(String) bundle.get("client"),(String) bundle.get("uid"));

    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent  intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
    getMenuInflater().inflate(R.menu.main_activity_actions, menu);
    MenuItem searchItem = menu.findItem(R.id.action_search);
    SearchView searchView =
            (SearchView) searchItem.getActionView();
    // Configure the search info and add any event listeners...
    return super.onCreateOptionsMenu(menu);
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtStart.setVisibility(View.VISIBLE);
                txtStart.setText("Wait...");
                txtStart.setBackgroundColor(Color.WHITE);
                searchEnterprise(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                txtStart.setVisibility(View.VISIBLE);
                txtStart.setText("Wait...");
                txtStart.setBackgroundColor(Color.WHITE);
                searchEnterprise(newText);
                return false;
            }
        });

        searchView.setQueryHint("Search");
        return super.onCreateOptionsMenu(menu);
    }

    public void searchEnterprise(String search){
        if(userModel != null){
            Call call = iService.listEnterprises(userModel.getAccess_token(), userModel.getClient(), userModel.getUid(), search);
            call.enqueue(new Callback<ListEnterprise>() {
                @Override
                public void onResponse(Call<ListEnterprise> call, Response<ListEnterprise> response) {
                    showEnterprise(response.body());
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Toast.makeText(getBaseContext(), "Server error, try again!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @SuppressLint("ResourceAsColor")
    public void showEnterprise(final ListEnterprise listEnterprise){
        listViewAdapter = new ListViewAdapter(this, listEnterprise.getListEnterprise());
        listViewEnterprise.setAdapter(listViewAdapter);
        listViewEnterprise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                EnterpriseModel enterpriseModel = (EnterpriseModel) listViewAdapter.getItem(i);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("name", enterpriseModel.getEnterprise_name());
                intent.putExtra("details",  enterpriseModel.getDescription());
                startActivity(intent);
            }
        });
        txtStart.setText("Empty");
        txtStart.setBackgroundColor(R.color.colorAccent);
    }
}
