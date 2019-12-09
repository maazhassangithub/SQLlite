package com.example.myapplication;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Student> list;
    public CustomAdapter(Context context, ArrayList<Student> list){

        this.context =context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 1;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.custom_layout, null);
        TextView tvId = view.findViewById(R.id.txtID);
        TextView tvName = view.findViewById(R.id.txtName);
        TextView tvCourse = view.findViewById(R.id.txtCourse);
        for(int i=0; i<list.size(); i++) {
            Student std = list.get(position);
            tvId.setText(std.getStudentId());
            tvName.setText(std.getStudentName());
            tvCourse.setText(std.getCourseName());
        }
        return view;
    }
}
