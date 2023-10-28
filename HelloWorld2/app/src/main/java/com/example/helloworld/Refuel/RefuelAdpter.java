package com.example.helloworld.Refuel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

import java.util.ArrayList;

public class RefuelAdpter extends RecyclerView.Adapter<RefuelAdpter.reViewHolder> {
    ArrayList<RefuleModel> refuel_dataholder;

    public RefuelAdpter(ArrayList<RefuleModel> refuel_dataholder) {
        this.refuel_dataholder = refuel_dataholder;
    }

    @NonNull
    @Override
    public RefuelAdpter.reViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_refuel_row,parent,false);
        return new RefuelAdpter.reViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RefuelAdpter.reViewHolder holder, int position) {
        holder.date.setText(refuel_dataholder.get(position).getDate());
        holder.cost.setText(refuel_dataholder.get(position).getCost());
        holder.location.setText(refuel_dataholder.get(position).getLocation());
        holder.qty.setText(refuel_dataholder.get(position).getQty());

    }

    @Override
    public int getItemCount() {
        return refuel_dataholder.size();
    }

    public class reViewHolder extends RecyclerView.ViewHolder {
        TextView date,cost,location,qty;
        public reViewHolder(@NonNull View itemView) {
            super(itemView);
            date=(TextView) itemView.findViewById(R.id.txtrefueldate);
            cost=(TextView) itemView.findViewById(R.id.txtRefuelcost);
            location=(TextView) itemView.findViewById(R.id.txtRefuelLocation);
            qty=(TextView) itemView.findViewById(R.id.txtRefuleqty);

        }
    }
}
