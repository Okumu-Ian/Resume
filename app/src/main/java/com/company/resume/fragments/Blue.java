package com.company.resume.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.company.resume.R;
import com.company.resume.utils.ResumeStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Blue extends Fragment {

    private int pos;
    private TextView textView;
    private FloatingActionButton fabEdit;

    public Blue(int pos) {
        this.pos = pos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blue,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View mView){
        textView = mView.findViewById(R.id.txt_resume_content);
        fabEdit = mView.findViewById(R.id.fab_edit);


        ResumeStorage storage = new ResumeStorage(getActivity());
        switch (pos){
            case 0:
                textView.setText(storage.getUser_details());
                break;
            case 1:
                textView.setText(storage.getUser_education());
                break;
            case 2:
                textView.setText(storage.getUser_work());
                break;
            case 3:
                textView.setText(storage.getUser_skill());
                break;
            case 4:
                textView.setText(storage.getUser_achievements());
                break;
                default:
                    break;
        }

        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editDetails(pos);
            }
        });
    }

    private void editDetails(int position){
        assert getActivity()!= null;
        Fragment redFragment = new Red(position);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.blue_red_container,redFragment).commit();
    }

}
