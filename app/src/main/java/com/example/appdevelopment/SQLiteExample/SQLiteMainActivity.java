package com.example.appdevelopment.SQLiteExample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appdevelopment.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLiteMainActivity extends AppCompatActivity {

    ListView listView;
    DBQueries dbQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqlite_main);
        listView=findViewById(R.id.lstmaincontactlist);
        dbQueries=new DBQueries(getApplicationContext());

        ArrayList<HashMap<String,String>> allContacts= dbQueries.getAllContacts();
        SimpleAdapter adapter=new SimpleAdapter(this,allContacts, R.layout.allcontactslayout, new String[] {
                "_id","firstName","secondName" },new int []{R.id.textViewID,R.id.textViewFirstName,R.id.textViewLastName});
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AddContact(View view) {
        Intent intent=new Intent(this, NewContactActivity.class);
        startActivity(intent);
    }
}