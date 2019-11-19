package com.dicoding.picodiploma.submissionkedua;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.CardViewViewHolder> {

    private ArrayList<DataT> listTv;

    public TvAdapter(ArrayList<DataT> list){
        this.listTv = list;
    }

    private TvAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(TvAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public TvAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new TvAdapter.CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvAdapter.CardViewViewHolder holder, int position) {
        DataT dataT = listTv.get(position);

        holder.tvJudul.setText(dataT.getJudul());
        holder.tvGenre.setText(dataT.getGenre());
        holder.tvPh.setText(dataT.getPh());
        holder.tvTahun.setText(dataT.getTahun());
        holder.tvDeskripsi.setText(dataT.getOverview());

        Glide.with(holder.itemView.getContext())
                .load(listTv.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvRating.setText(dataT.getRating());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listTv.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvJudul, tvGenre, tvPh, tvTahun, tvTanggal , tvDeskripsi, tvRating, tvWaktu, tvAktor;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvGenre = itemView.findViewById(R.id.tv_genre);
            tvPh = itemView.findViewById(R.id.tv_ph);
            tvTahun = itemView.findViewById(R.id.tv_tahun);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvRating = itemView.findViewById(R.id.tv_rating);
            tvWaktu = itemView.findViewById(R.id.tv_time);
            tvAktor = itemView.findViewById(R.id.tv_aktor);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(DataT datat);
    }
}
