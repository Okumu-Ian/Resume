package com.company.resume.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.resume.R;
import com.company.resume.fragments.Blue;
import com.company.resume.models.ResumeComponent;

import java.util.List;

public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.ResumeHolder> {

    //view holder for the views in each row of the left sided menu
    class ResumeHolder extends RecyclerView.ViewHolder{
        private AppCompatImageView imageView;
        private AppCompatTextView textView;
        private CardView cardView;
        ResumeHolder(View view){
            super(view);
            textView = view.findViewById(R.id.txt_title);
            cardView = view.findViewById(R.id.side_list_card);
        }
    }

    //Variable for adapter functionality
    private Context mContext;
    private List<ResumeComponent> components;
    private FragmentActivity activity;

    public ResumeAdapter(Context mContext, List<ResumeComponent> components, FragmentActivity activity) {
        this.mContext = mContext;
        this.components = components;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ResumeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_green_row,parent,false);
        return new ResumeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeHolder holder, final int position) {
        ResumeComponent component = components.get(position);
        holder.textView.setText(component.getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext, "Position: "+position, Toast.LENGTH_SHORT).show();
                clickItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return components.size();
    }

    //Implements various navigation events
    private void clickItem(int position){
        //use the fragment manager from the activity to navigate through screens
        FragmentManager manager = activity.getSupportFragmentManager();
        switch (position){
            case 0:
                Fragment blue = new Blue(0);
                manager.beginTransaction().replace(R.id.blue_red_container,blue).commit();
                break;
            case 1:
                Fragment blue1 = new Blue(1);
                manager.beginTransaction().replace(R.id.blue_red_container,blue1).commit();
                break;
            case 2:
                Fragment blue2 = new Blue(2);
                manager.beginTransaction().replace(R.id.blue_red_container,blue2).commit();
                break;
            case 3:
                Fragment blue3 = new Blue(3);
                manager.beginTransaction().replace(R.id.blue_red_container,blue3).commit();
                break;
            case 4:
                Fragment blue4 = new Blue(4);
                manager.beginTransaction().replace(R.id.blue_red_container,blue4).commit();
                break;
        }
    }
}
