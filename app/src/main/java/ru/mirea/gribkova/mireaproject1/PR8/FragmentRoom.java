package ru.mirea.gribkova.mireaproject1.PR8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import ru.mirea.gribkova.mireaproject1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRoom#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRoom extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRoom() {
        // Required empty public constructor

    }


    public static FragmentRoom newInstance(String param1, String param2) {
        FragmentRoom fragment = new FragmentRoom();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    AppDatabase db;
    List<Student> items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        db = AppDatabase.getDbInstance(this.getContext());
        View view =  inflater.inflate(R.layout.fragment_room, container, false);

        EditText firstname= view.findViewById(R.id.firstname);
        EditText lastname= view.findViewById(R.id.lastname);
        EditText numberingroup=(EditText) view.findViewById(R.id.numberingroup);

        Button btnsave = view.findViewById(R.id.buttonadd);
        btnsave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nums = numberingroup.getText().toString();

                int a = ConvertIntoNumeric(nums);
                // String newa= String.valueOf(a) ;

                saveStudent(firstname.getText().toString(),lastname.getText().toString(),a);

            }
        });
        Button btnall = view.findViewById(R.id.buttonall);
        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all();
            }
        });
        Button btndel = view.findViewById(R.id.deleteall);
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteall(items);
            }
        });


        return view;
}
    private void all(){

    }



    private void deleteall(List<Student> students){

        List<Student> students1 = db.studentDao().getAll();
        Log.d( "BD", String.valueOf(students1.size()));
        if(students1!=null){
            for(int i =0;i<students1.size();i++){

                db.studentDao().deleteStudent(students1.get(i).numberingroup);
                Log.d("BD-ID", String.valueOf(students1.get(i).numberingroup));

            }
            if(students != null && students.size() > 0) {
                students.clear();
                students1 = db.studentDao().getAll();
                Log.d("BD", String.valueOf(students1.size()));
                Log.d("Items", String.valueOf(students.size()));
            }
        }

    }

    private List<Student> saveStudent(String firstname, String lastname, Integer numberingroup){

       // AppDatabase db = AppDatabase.getDbInstance(this.getContext());
        StudentDao studentDao= db.studentDao();

        Student student = new Student();
        student.firstName=firstname;
        student.lastName = lastname;
        student.numberingroup = numberingroup;
        db.studentDao().insertAll(student);

        items = studentDao.getAll();
        Log.d( "Items", String.valueOf(items.size()));
        Log.d("First name", firstname + " " + lastname+ " " + numberingroup);

        return items;

    }

    private int ConvertIntoNumeric(String xVal)
    {

        try
        {
            return Integer.parseInt(xVal);
        }
        catch(Exception ex)
        {
            return -1;
        }
    }
}