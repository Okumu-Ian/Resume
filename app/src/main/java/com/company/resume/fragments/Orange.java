package com.company.resume.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.company.resume.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Orange extends Fragment {

    private CircleImageView profile_image;
    private AppCompatTextView txt_profile_name;
    private AppCompatTextView txt_profile_location;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orange,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profile_image = view.findViewById(R.id.img_profile);
        txt_profile_name = view.findViewById(R.id.txt_name);
        txt_profile_location = view.findViewById(R.id.txt_location);

        assert getActivity()!=null;
        Glide.with(getActivity()).load("https://images.unsplash.com/photo-1545912452-8aea7e25a3d3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=334&q=80")
                .into(profile_image);
    }
}
