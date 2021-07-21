package com.example.hospitalmanagementsystem1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.FragmentActivity;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder>{

    int[] images;

    public SliderAdapter(int[] images) {
        this.images = images;
    }

    public SliderAdapter(FragmentActivity activity) {
    }


    @Override
    public SliderAdapter.Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sliderview,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SliderAdapter.Holder viewHolder, int position) {

        viewHolder.imageView.setImageResource(images[position]);

    }

    @Override
    public int getCount() {
        return images.length;
    }
    public class Holder extends SliderViewAdapter.ViewHolder{
        ImageView imageView;
        public Holder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);


        }
    }

}

