package com.example.helloworld.Vehical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;

import java.util.ArrayList;

public class myAdpter extends RecyclerView.Adapter<myAdpter.Myview> {

    ArrayList<model> dataholder;


    public myAdpter(ArrayList<model> dataholder){

        this.dataholder=dataholder;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_singlerow,parent,false);
       return  new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position) {
        holder.name.setText(dataholder.get(position).getName());
        holder.vehNum.setText(dataholder.get(position).getVehNum());
        holder.manufacture.setText(dataholder.get(position).getMaufacture());
        holder.model.setText(dataholder.get(position).getModel());
        holder.fuel.setText(dataholder.get(position).getFuelType());


    }

    @Override
    public int getItemCount() {
        return dataholder.size();

    }

    class Myview extends RecyclerView.ViewHolder{
        TextView name,vehNum,manufacture,model,fuel;

        public Myview(@NonNull View itemView) {
            super(itemView);
            name= (TextView) itemView.findViewById(R.id.txtVehiName);
            vehNum= (TextView) itemView.findViewById(R.id.txtVehiNum);
            manufacture= (TextView) itemView.findViewById(R.id.txtVehiManu);
            model= (TextView) itemView.findViewById(R.id.txtVehiModel);
            fuel= (TextView) itemView.findViewById(R.id.txtVehiFuel);
        }
    }
}
