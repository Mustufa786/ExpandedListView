package com.mustufa.extendedlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Context context;
    ArrayList<Data> dataArrayList;
    OnItemClick itemClick;
    boolean isExpanded = false;

    public ListAdapter(Context context, ArrayList<Data> data, OnItemClick click) {
        this.context = context;
        this.dataArrayList = data;
        this.itemClick = click;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {

        holder.textView.setText(dataArrayList.get(i).getTitle());

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.subItemView.removeAllViews();
                if (!isExpanded) {
                    View view = LayoutInflater.from(context).inflate(R.layout.item_list_sub, null);
                    TextView id, desc;
                    id = view.findViewById(R.id.id);
                    desc = view.findViewById(R.id.desc);
                    id.setText(dataArrayList.get(i).id);
                    desc.setText(dataArrayList.get(i).getDescription());
                    holder.subItemView.addView(view);
                    isExpanded = true;
                } else {
                    holder.subItemView.removeAllViews();
                    isExpanded = false;
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        RelativeLayout mainLayout;
        LinearLayout subItemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            mainLayout = itemView.findViewById(R.id.item);
            subItemView = itemView.findViewById(R.id.layoutForSubItem);
        }
    }

    interface OnItemClick {
        void onClick(Data data);
    }
}
