package com.example.training;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class save extends AppCompatActivity {

    Button save;
    EditText name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        save = findViewById(R.id.btnSave);
        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog dialog = new ProgressDialog(save.this);
                dialog.setTitle("Loadin...");
                dialog.setMessage("Please wait");
                dialog.setMax(100);
                dialog.show();



                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();

                params.add("name", name.getText().toString());
                params.add("course", email.getText().toString());

                client.post("http://192.168.100.22/dennis/add.php", params, new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Toast.makeText(save.this, "Something went wrong!!!", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Toast.makeText(save.this, "New user added successfully!", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        email.setText("");
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
