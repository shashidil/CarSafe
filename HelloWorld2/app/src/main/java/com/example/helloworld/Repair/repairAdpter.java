package com.example.helloworld.Repair;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.Vehical.myAdpter;


import java.util.ArrayList;

public class repairAdpter extends RecyclerView.Adapter<repairAdpter.ViewHolder> {

    ArrayList<RepairModel> repair_dataholder;
    public repairAdpter(ArrayList<RepairModel> repair_dataholder){

        this.repair_dataholder=repair_dataholder;
    }
    @NonNull
    @Override
    public repairAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_repair_row,parent,false);
        return  new repairAdpter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull repairAdpter.ViewHolder holder, int position) {
        holder.repair.setText(repair_dataholder.get(position).getRepair());
        holder.description.setText(repair_dataholder.get(position).getDiscription());
        holder.cost.setText(repair_dataholder.get(position).getCost());
        holder.date.setText(repair_dataholder.get(position).getDate());


    }

    @Override
    public int getItemCount() {
        return repair_dataholder.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView repair,description,cost,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            repair= (TextView) itemView.findViewById(R.id.txtRepair);
            description= (TextView) itemView.findViewById(R.id.txtRepairdes);
            cost= (TextView) itemView.findViewById(R.id.txtRepaircost);
            date= (TextView) itemView.findViewById(R.id.txtRepairdate);

        }
    }
}
