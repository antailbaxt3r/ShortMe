package com.antailbaxt3r.shortme.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.antailbaxt3r.shortme.R;
import com.antailbaxt3r.shortme.models.URLResponse;
import com.antailbaxt3r.shortme.retrofit.RetrofitClient;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView generatedText, generatedURLText;
    EditText customEnd, url;
    Button goButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachID();

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(url.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter URL", Toast.LENGTH_SHORT).show();
                return;
                }

                Map<String,String> map = new HashMap<>();
                map.put("longUrl", url.getText().toString());
                if(!customEnd.getText().toString().isEmpty()){
                    map.put("customCode", customEnd.getText().toString());
                }
                Call<URLResponse> call = RetrofitClient .getClient().sendURL(map);
                call.enqueue(new Callback<URLResponse>() {
                    @Override
                    public void onResponse(Call<URLResponse> call, Response<URLResponse> response) {

                        if(!response.isSuccessful()){
                            Toast.makeText(MainActivity.this, "ERROR : Custom Code is already in use", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        final String url = response.body().getShortUrl();
                        generatedText.setVisibility(View.VISIBLE);
                        generatedURLText.setVisibility(View.VISIBLE);
                        generatedURLText.setText(url);
                        generatedURLText.isClickable();
                        generatedURLText.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<URLResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "ERROR : " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void attachID() {
        generatedText = findViewById(R.id.generated_text);
        generatedURLText = findViewById(R.id.short_url);
        customEnd = findViewById(R.id.custom_end);
        url = findViewById(R.id.url);
        goButton = findViewById(R.id.go_button);
    }
}
