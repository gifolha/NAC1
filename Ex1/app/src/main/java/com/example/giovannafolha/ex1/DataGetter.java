package com.example.giovannafolha.ex1;

import android.os.AsyncTask;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

public class DataGetter extends AsyncTask<String,Void,String> {

    public EditText edtTitle;
    public EditText edtCompleted;


    public DataGetter(EditText edtTitle, EditText edtCompleted) {
        this.edtTitle = edtTitle;
        this.edtCompleted = edtCompleted;



    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... strings) {

        String url = strings[0];
        String result = NetworkToolkit.doGet(url);


        return result;
    }

    @Override
    protected void onPostExecute(String s) {

        try{

            JSONObject jsonObject = new JSONObject(s);


            String title = jsonObject.getString("title");
            boolean completed = jsonObject.getBoolean("completed");

            edtTitle.setText(title);
            edtCompleted.setText(String.valueOf(completed));

        }
        catch(JSONException e){
            this.edtTitle.setText(e.toString());
        }
    }

}