package ru.mirea.gribkova.mireaproject1.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.mirea.gribkova.mireaproject1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Settings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Settings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Settings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Settings.
     */
    // TODO: Rename and change types and number of parameters
    public static Settings newInstance(String param1, String param2) {
        Settings fragment = new Settings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private Button btnSave;
    private EditText surname;
    private EditText name;
    private EditText studyText;
    private SharedPreferences preferences;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        btnSave = view.findViewById(R.id.save);
        btnSave.setOnClickListener(this::updateButoonClick);

        name = view.findViewById(R.id.name);
        surname = view.findViewById(R.id.surname);
        studyText = view.findViewById(R.id.studygroup);

        preferences = getActivity().getPreferences(Context.MODE_PRIVATE);;

        try {
            name.setText(preferences.getString("name", null));
            surname.setText(preferences.getString("age", null));
            studyText.setText(preferences.getString("job", null));
        }catch (Exception e){
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        return view;
    }

    private void updateButoonClick(View view) {
        Log.d("TAG", "button clicked");
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name", name.getText().toString());
        editor.putString("age", surname.getText().toString());
        editor.putString("job", studyText.getText().toString());
        editor.apply();
        Toast.makeText(getActivity(), "Update saved", Toast.LENGTH_SHORT).show();
    }
}