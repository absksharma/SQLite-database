package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context cOntext;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View v, ViewGroup viewGroup) {
        Holder holder;

        LayoutInflater layoutInflater;

        if (v == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = layoutInflater.inflate(R.layout.users_details, null);

            holder = new Holder();


            TextView tv1 = v.findViewById(R.id.tvId);
            TextView tv2 = v.findViewById(R.id.tvName);
            TextView tv3 = v.findViewById(R.id.tvCourse);
            TextView tv4 = v.findViewById(R.id.tvContact);
            TextView tv5 = v.findViewById(R.id.tvFee);

            tv1.setText(String.valueOf(al1.get(position)));
            tv2.setText(al2.get(position));
            tv3.setText(al3.get(position));
            tv4.setText(al4.get(position));
            tv5.setText(al5.get(position));

            return v;
        } }

    public class Holder {
        TextView textviewid;
        TextView textviewname;
        TextView textviewphone_number;
        TextView textviewsubject;
    }
}
