package ru.mirea.gribkova.mireaproject1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.gribkova.mireaproject1.databinding.ActivityForPr6Binding;

import ru.mirea.gribkova.mireaproject1.R;
import ru.mirea.gribkova.mireaproject1.databinding.ActivityForPr6Binding;

public class activity_for_pr6 extends AppCompatActivity {


    AppDatabase db;
    List<Dog> dogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_pr6);

        db = AppDatabase.getDbInstance(this);
        EditText breed =  findViewById(R.id.Breed);
        EditText namedog = findViewById(R.id.NameDog);
        Button btnsave = findViewById(R.id.savedog);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedog(breed.getText().toString(), namedog.getText().toString() );

            }


        });

        Button btndelete = findViewById(R.id.deletedog);
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteall();
            }
        });





    }

    private List<Dog> savedog(String breed, String namedog){
        DogDao dogDao =db.dogDao();

        Dog dog = new Dog();
        dog.breed=breed;
        dog.name_dog=namedog;

        db.dogDao().insert(dog);
        dogs = dogDao.getAll();
        Log.d("Count dogs", String.valueOf(dogs.size()));
        return dogs;
    }

    private void deleteall(){
        List<Dog> dogs = db.dogDao().getAll();
        if(dogs != null){
            for (int i = 0; i < dogs.size(); i++) {
                db.dogDao().delete(dogs.get(i));
            }
        }
    }




}