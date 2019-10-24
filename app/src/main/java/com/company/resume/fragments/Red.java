package com.company.resume.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.company.resume.R;
import com.company.resume.utils.ResumeStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class Red extends Fragment {

    private int pos;
    private AppCompatTextView textView;

    private FloatingActionButton fab;
    private TextInputEditText something;

    public Red(int pos) {
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_red,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }
    private void initUI(View mView){
        textView = mView.findViewById(R.id.txt_title_edit);
        fab = mView.findViewById(R.id.fab_update);
        something = mView.findViewById(R.id.edt_bio_edit);
        textView.setText(Green.title[pos]);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              updateBio(something.getText().toString());
              something.setText("");
                Snackbar.make(view,"Success!",Snackbar.LENGTH_SHORT).show();
                Fragment blueFragment = new Blue(pos);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.blue_red_container,blueFragment).commit();
            }
        });

    }

    private void updateBio(String text){
        ResumeStorage storage = new ResumeStorage(getActivity());
        switch (pos){
            case 0:
                storage.setUser_details(text);
                break;
            case 1:
                storage.setUser_education(text);
                break;
            case 2:
                storage.setUser_work(text);
                break;
            case 3:
                storage.setUser_skill(text);
                break;
            case 4:
                storage.setUser_achievements(text);
                break;
        }
    }

}
