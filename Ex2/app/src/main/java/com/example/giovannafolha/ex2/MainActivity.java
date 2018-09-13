package com.example.giovannafolha.ex2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaPost(View view){

        TextView edtUserId = findViewById(R.id.edtUserId);
        TextView edtTitle = findViewById(R.id.edtTitle);
        TextView edtBody = findViewById(R.id.edtBody);
        TextView txtMensagem = findViewById(R.id.txtMensagem);

        String url = "https://jsonplaceholder.typicode.com/posts/";
        String json =
                "{\n"+
                        "    \"userid\": \""+edtUserId.getText().toString()+"\",\n" +
                        "    \"title\": \""+edtTitle.getText().toString()+"\"\n" +
                        "    \"body\":  \""+edtBody.getText().toString()+"\"\n" +
                        "}";

        new DataGetterPost(txtMensagem).execute(url,json);
    }
}

