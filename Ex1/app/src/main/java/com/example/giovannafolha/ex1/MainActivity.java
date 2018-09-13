package com.example.giovannafolha.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void executaConsulta(View view)
    {
        String url = "https://jsonplaceholder.typicode.com/todos/";

        EditText edtId = findViewById(R.id.edtId);
        url += edtId.getText().toString();

        EditText edtTitle = findViewById(R.id.edtTitle);
        EditText edtCompleted = findViewById(R.id.edtCompleted);

        new DataGetter(edtTitle,edtCompleted).execute(url);

    }
}
