package com.company.resume.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.resume.R;
import com.company.resume.adapters.ResumeAdapter;
import com.company.resume.models.ResumeComponent;
import com.company.resume.utils.ResumeStorage;

import java.util.ArrayList;
import java.util.List;

public class Green extends Fragment {

    private RecyclerView recyclerView;
    private ResumeAdapter adapter;
    private List<ResumeComponent> components;
    private ResumeStorage storage;
    public static String [] title = {"About Me","Education","Work","Hobbies","Achievements"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_green,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view){
        assert getActivity()!= null;
        recyclerView = view.findViewById(R.id.resume_item_list);
        components = new ArrayList<>();
        storage = new ResumeStorage(getActivity());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false);

        /*DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);*/
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        prepList();

    }

    private void prepValues(ResumeStorage resumeStorage){
    }

    private void prepList(){
        for (String s : title) {
            ResumeComponent component = new ResumeComponent();
            component.setTitle(s);
            components.add(component);
        }
        adapter = new ResumeAdapter(getActivity(),components,getActivity());
        recyclerView.setAdapter(adapter);
    }
}
