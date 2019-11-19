package com.dicoding.picodiploma.submissionkedua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvJudul;
    TextView tvGenre;
    TextView tvPh;
    TextView tvTanggal;
    TextView tvOverview;
    ImageView imgCover;
    TextView tvRating;
    TextView tvWaktu;
    TextView tvAktor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvJudul = findViewById(R.id.tv_judul);
        tvGenre = findViewById(R.id.tv_genre);
        tvPh = findViewById(R.id.tv_ph);
        tvTanggal = findViewById(R.id.tv_tanggal);
        tvOverview = findViewById(R.id.tv_deskripsi);
        imgCover = findViewById(R.id.img_photo);
        tvRating = findViewById(R.id.tv_rating);
        tvWaktu = findViewById(R.id.tv_time);
        tvAktor = findViewById(R.id.tv_aktor);

        DataM dataM = getIntent().getParcelableExtra(EXTRA_MOVIE);
        assert dataM != null;
        tvJudul.setText(dataM.getJudul());
        tvGenre.setText(dataM.getGenre());
        tvPh.setText(dataM.getPh());
        tvTanggal.setText(dataM.getTanggal());
        tvOverview.setText(dataM.getOverview());

        Glide.with(this)
                .load(dataM.getPhoto())
                .apply(new RequestOptions().override(450, 650))
                .into(imgCover);

        tvRating.setText(dataM.getRating());
        tvWaktu.setText(dataM.getWaktu());
        tvAktor.setText(dataM.getAktor());
    }
}
