package com.example.training;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class rec extends AppCompatActivity {
    ListView results;
    EditText search;
    Button find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec);

        results = findViewById(R.id.results);
        search = findViewById(R.id.txtSearch);
        find = findViewById(R.id.btnFind);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = new ProgressDialog(rec.this);
                dialog.setTitle("Loading...");
                dialog.setMessage("please wait");
                dialog.setMax(100);
                dialog.show();

                AsyncHttpClient clinet = new AsyncHttpClient();
                RequestParams params = new RequestParams();
                params.add("search", search.getText().toString());
                clinet.get("http://192.168.100.22/dennis/search.php", params, new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Toast.makeText(rec.this, "Ooop...something went Wrong!!!!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {

                        String[] resultText = responseString.split("#");
                        ArrayAdapter<String> adaper = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, resultText);
                        results.setAdapter(adaper);

                        search.setText("");
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
