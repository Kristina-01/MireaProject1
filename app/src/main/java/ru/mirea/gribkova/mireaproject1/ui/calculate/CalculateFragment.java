package ru.mirea.gribkova.mireaproject1.ui.calculate;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ru.mirea.gribkova.mireaproject1.R;
import ru.mirea.gribkova.mireaproject1.databinding.FragmentCalculateBinding;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculateFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculateFragment newInstance(String param1, String param2) {
        CalculateFragment fragment = new CalculateFragment();
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

    //private FragmentCalculateBinding binding;

    TextView textView;
    int a1=-1;
    int a2=-1;
    String str="";
    int res;
    String znak;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculate, container, false);

        textView = view.findViewById(R.id.textView2);

        Button button1= (Button) view.findViewById(R.id.button1);
       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                       str+=1;
                       if(a1==-1){
                           a1=1;
                       }
                       else {
                           a2=1;
                       }
               textView.setText(str);
           }
       });

        Button button2= (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    str+="2";
                    if(a1==-1){
                        a1=2;
                    }
                    else {
                        a2=2;
                    }
                textView.setText(str);
            }
        });

        Button button3= (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="3";
                if(a1==-1){
                    a1=3;
                }
                else {
                    a2=3;
                }
                textView.setText(str);
            }
        });

        Button button4= (Button) view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="4";
                if(a1==-1){
                    a1=4;
                }
                else {
                    a2=4;
                }
                textView.setText(str);
            }
        });

        Button button5= (Button) view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="5";
                if(a1==-1){
                    a1=5;
                }
                else {
                    a2=5;
                }
                textView.setText(str);
            }
        });

        Button button6= (Button) view.findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="6";
                if(a1==-1){
                    a1=6;
                }
                else {
                    a2=6;
                }
                textView.setText(str);
            }
        });

        Button button7= (Button) view.findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="7";
                if(a1==-1){
                    a1=7;
                }
                else {
                    a2=7;
                }
                textView.setText(str);
            }
        });

        Button button8= (Button) view.findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="8";
                if(a1==-1){
                    a1=8;
                }
                else {
                    a2=8;
                }
                textView.setText(str);
            }
        });

        Button button9= (Button) view.findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str+="9";
                if(a1==-1){
                    a1=9;
                }
                else {
                    a2=9;
                }
                textView.setText(str);
            }
        });



        Button buttonmin = (Button) view.findViewById(R.id.buttonmin);
        buttonmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                znak="-";
               str+="-";
               textView.setText(str);
            }
        });

        Button buttonplus = (Button) view.findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                znak="+";
                str+="+";
                textView.setText(str);
            }
        });

        Button buttondivide = (Button) view.findViewById(R.id.buttondivide);
        buttondivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                znak="/";
                str+="/";
                textView.setText(str);
            }
        });


        Button buttonmultiply = (Button) view.findViewById(R.id.buttonmultiply);
        buttonmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                znak="*";
                str+="*";
                textView.setText(str);
            }
        });




        Button buttonequals = (Button) view.findViewById(R.id.buttonequals);
        buttonequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(znak.equals("-")){
                    res=a1-a2;
                }
                else if (znak.equals("+")){
                    res=a1+a2;
                }
                else if(znak.equals("/")){
                    res=a1/a2;
                }
                else if(znak.equals("*")){
                    res=a1*a2;
                }


                str+="="+res;
                textView.setText(str);
            }
        });




        Button buttondel = (Button) view.findViewById(R.id.buttondelete);
        buttondel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               str=new String();
               a1=-1;
               a2=-1;
               znak=new String();
                textView.setText(str);
            }
        });



        return view;



    }
    public void onClick(View view){

    }



}
