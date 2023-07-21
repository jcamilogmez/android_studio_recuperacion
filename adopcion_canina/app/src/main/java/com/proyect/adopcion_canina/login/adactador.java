package com.proyect.adopcion_canina.login;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyect.adopcion_canina.R;
import com.proyect.adopcion_canina.item_can;

import java.util.List;

public class adactador extends RecyclerView.Adapter<adactador.ViewHolder> {

    private List<item_can> itemList;

    private OnItemClickListener itemClickListener;

    public adactador ( List<item_can> itemList) {
        this.itemList = itemList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.layaut_can, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item_can item = itemList.get(position);
        holder.id_can.setText(String.valueOf(item.getId_can ()));
        holder.edad_can.setText(String.valueOf(item.getEdad ()));
        holder.nombre_can.setText(item.getNombre_can ());
        holder.descrip_can.setText(item.getDescripcion ());
        holder.estado_can.setText(item.getEstado_adopcion ());
        holder.raza_can.setText(item.getRaza_can ());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id_can ,nombre_can, edad_can, descrip_can, estado_can, raza_can;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id_can = itemView.findViewById(R.id.txt_id_can);
            nombre_can = itemView.findViewById(R.id.txt_nombre_can);
            edad_can= itemView.findViewById(R.id.txt_edad_can);
            descrip_can = itemView.findViewById(R.id.txt_descrip_can);
            estado_can = itemView.findViewById(R.id.txt_estado_can);
            raza_can= itemView.findViewById(R.id.txt_estado_can);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(item_can item);
    }
}