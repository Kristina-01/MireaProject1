package ru.mirea.gribkova.mireaproject1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class acthistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityhistory);

        String name, age;
        name = findViewById(R.id.storyName).toString();
        age = findViewById(R.id.storyAge).toString();

        Intent intent = new Intent(this, History.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        startActivity(intent);
    }
}



