package com.andi.userapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andi.userapp.R;
import com.andi.userapp.data.ListViewData;

import java.util.ArrayList;
import java.util.List;

public class AdapterListView extends RecyclerView.Adapter<AdapterListView.ListViewHolder> {

    private List<ListViewData> listViewData;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public AdapterListView(ArrayList<ListViewData> listViewData) {
        this.listViewData = listViewData;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.template_recycleview, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final ListViewData listViewdata = listViewData.get(position);
        holder.textNotiket.setText(listViewdata.getNotiket());
        holder.textNamaAset.setText(listViewdata.getAsetname());
        holder.textTgl.setText(listViewdata.getTgllapor());
        if(listViewdata.getStatus().equals("3")){
            holder.textStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorButonubhstatus));
            holder.textStatus.setText(holder.itemView.getContext().getResources().getText(R.string.status_sudahditugaskan));
        }else if(listViewdata.getStatus().equals("2")){
            holder.textStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorButonubhstatus));
            holder.textStatus.setText(holder.itemView.getContext().getResources().getText(R.string.status_progres));
        }else if(listViewdata.getStatus().equals("1")){
            holder.textStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorTextgren));
            holder.textStatus.setText(holder.itemView.getContext().getResources().getText(R.string.status_selesai));
        }else if(listViewdata.getStatus().equals("4")){
            holder.textStatus.setTextColor(holder.itemView.getContext().getResources().getColor(R.color.colorTextRed));
            holder.textStatus.setText(holder.itemView.getContext().getResources().getText(R.string.status_antri));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listViewData.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listViewData.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView textNotiket,textNamaAset,textTgl,textStatus;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textNotiket = itemView.findViewById(R.id.textTiket);
            textNamaAset = itemView.findViewById(R.id.textAsetname);
            textTgl = itemView.findViewById(R.id.textTgl);
            textStatus = itemView.findViewById(R.id.textStatus);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ListViewData data);
    }
}
