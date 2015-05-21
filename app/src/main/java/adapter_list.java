package com.example.senjarp.booklistfull;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class adapter_list extends BaseAdapter{

    private int count;
    private Context context;

    public adapter_list(int count, Context context)
    {
        this.count = count;
        this.context = context;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return count;
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup arg2) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.listview3, null);

        TextView title = (TextView)contentView.findViewById(R.id.inflate_title);
        TextView body = (TextView)contentView.findViewById(R.id.inflate_body);
        TextView hal = (TextView)contentView.findViewById(R.id.inflate_body1);

        title.setText("Title - "+position);
        body.setText("Nama - "+position);
        hal.setText("Halaman - "+position);

        return contentView;
    }

}