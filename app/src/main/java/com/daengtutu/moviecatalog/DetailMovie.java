package com.daengtutu.moviecatalog;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovie extends AppCompatActivity {
    TextView tvObjectJudul, tvObjectDesk;
    ImageView tvObjectImage;
    public static final String EXTRA_PERSON = "extra_person";
    private String title ="Movie Details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        setActionBarTitle(title);

        tvObjectJudul = findViewById(R.id.tv_object_recieved_judul);
        tvObjectImage = findViewById(R.id.tv_object_recieved_gambar);
        tvObjectDesk = findViewById(R.id.tv_object_recieved_desk);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);

        int image = person.getPoster();
        String text ="Judul : " + person.getJudul();
        String textdesk = "Deskripsi : " + person.getDeskripsi();
        tvObjectJudul.setText(text);
        tvObjectDesk.setText(textdesk);
        tvObjectImage.setImageResource(image);
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
    }
}
