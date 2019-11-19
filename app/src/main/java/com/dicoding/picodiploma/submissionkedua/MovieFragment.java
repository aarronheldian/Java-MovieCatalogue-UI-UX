package com.dicoding.picodiploma.submissionkedua;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private String[] dataJudul;
    private String[] dataGenre;
    private String[] dataPh;
    private String[] dataTahun;
    private String[] dataTanggal;
    private String[] dataOverview;
    private String[] dataCover;
    private String[] dataRating;
    private String[] dataWaktu;
    private String[] dataAktor;
    private RecyclerView rvMovie;
    private ArrayList<DataM> listM = new ArrayList<>();

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        prepare();
        addDataM();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        rvMovie = getActivity().findViewById(R.id.rv_movie);
        rvMovie.setHasFixedSize(true);

        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvMovie.setLayoutManager(new LinearLayoutManager(this.getContext()));
        MovieAdapter movieAdapter = new MovieAdapter(listM);
        rvMovie.setAdapter(movieAdapter);

        movieAdapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(DataM datam) {
                showSelectedHero(datam);
            }
        });

    }

    public MovieFragment(ArrayList<DataM> list) {
        this.listM = list;
    }

    private void showSelectedHero(DataM dataM) {
        Intent moveWithObjectIntent = new Intent(this.getContext(), DetailActivity.class);
        moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, dataM);
        startActivity(moveWithObjectIntent);

        Toast.makeText(this.getContext(), "Kamu memilih " + dataM.getJudul(), Toast.LENGTH_SHORT).show();
    }

    public void addDataM(){
        for (int i = 0; i < dataJudul.length; i++) {
            DataM movie = new DataM();

            movie.setJudul(dataJudul[i]);
            movie.setGenre(dataGenre[i]);
            movie.setPh(dataPh[i]);
            movie.setTahun(dataTahun[i]);
            movie.setTanggal(dataTanggal[i]);
            movie.setOverview(dataOverview[i]);
            movie.setPhoto(dataCover[i]);
            movie.setRating(dataRating[i]);
            movie.setWaktu(dataWaktu[i]);
            movie.setAktor(dataAktor[i]);

            listM.add(movie);
        }
    }

    private void prepare() {
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataPh = getResources().getStringArray(R.array.data_ph);
        dataTahun = getResources().getStringArray(R.array.data_tahun);
        dataTanggal = getResources().getStringArray(R.array.data_tanggal);
        dataOverview = getResources().getStringArray(R.array.data_overview);
        dataCover = getResources().getStringArray(R.array.data_cover);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataWaktu = getResources().getStringArray(R.array.data_waktu);
        dataAktor = getResources().getStringArray(R.array.data_aktor);
    }
}
