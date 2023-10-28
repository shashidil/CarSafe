package com.example.helloworld.Service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworld.R;
import com.example.helloworld.Repair.repairAdpter;


import java.util.ArrayList;

public class ServiceAdpter extends RecyclerView.Adapter<ServiceAdpter.SerViewHolder>{

    ArrayList<ServiceModel> service_dataholder;
    public ServiceAdpter(ArrayList<ServiceModel> service_dataholder){

        this.service_dataholder=service_dataholder;
    }
    @NonNull
    @Override
    public ServiceAdpter.SerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_service_row,parent,false);
        return  new ServiceAdpter.SerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdpter.SerViewHolder holder, int position) {
        holder.ServiceCenter.setText(service_dataholder.get(position).getServicecenter());
        holder.mileage.setText(service_dataholder.get(position).getMileage());
        holder.rbvalue.setText(service_dataholder.get(position).getRbvalue());
        holder.date.setText(service_dataholder.get(position).getDate());


    }

    @Override
    public int getItemCount() {
        return service_dataholder.size();
    }

    public class  SerViewHolder extends RecyclerView.ViewHolder {

        TextView ServiceCenter,mileage,rbvalue,description,date;
        public SerViewHolder(@NonNull View itemView) {
            super(itemView);
            ServiceCenter= (TextView) itemView.findViewById(R.id.txtServiceCenter);
            mileage= (TextView) itemView.findViewById(R.id.txtSerniceMil);
            rbvalue= (TextView) itemView.findViewById(R.id.txtrbValue);
            description= (TextView) itemView.findViewById(R.id.txtServiceDis);
            date= (TextView) itemView.findViewById(R.id.txtServicedate);


        }
    }


}
