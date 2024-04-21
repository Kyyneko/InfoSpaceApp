package com.example.spaceapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spaceapp.DataSourcePlanet;
import com.example.spaceapp.Planet;
import com.example.spaceapp.R;
import com.example.spaceapp.details.EarthDetails;
import com.example.spaceapp.details.JupiterDetails;
import com.example.spaceapp.details.MarsDetails;
import com.example.spaceapp.details.MerkuriusDetails;
import com.example.spaceapp.details.NeptunusDetails;
import com.example.spaceapp.details.SaturnusDetails;
import com.example.spaceapp.details.UranusDetails;
import com.example.spaceapp.details.VenusDetails;

import java.util.ArrayList;
import java.util.List;

public class Earth extends AppCompatActivity implements View.OnClickListener {

    // Inisialisasi ImageView
    private ImageView saturnus, mars, neptunus, merkurius, uranus, jupiter, venus, btn_detail, planetImg;
    private TextView planetName, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_earth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi views
        saturnus = findViewById(R.id.saturnus);
        mars = findViewById(R.id.mars);
        neptunus = findViewById(R.id.neptunus);
        merkurius = findViewById(R.id.merkurius);
        uranus = findViewById(R.id.uranus);
        jupiter = findViewById(R.id.jupiter);
        venus = findViewById(R.id.venus);
        btn_detail = findViewById(R.id.btn_detail);
        planetImg = findViewById(R.id.planetImg);
        planetName = findViewById(R.id.planetName);
        content = findViewById(R.id.content);

        // Mengatur OnClickListener untuk ImageView dan Button
        saturnus.setOnClickListener(this);
        mars.setOnClickListener(this);
        neptunus.setOnClickListener(this);
        merkurius.setOnClickListener(this);
        uranus.setOnClickListener(this);
        jupiter.setOnClickListener(this);
        venus.setOnClickListener(this);
        btn_detail.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null) {
            // Periksa apakah intent memiliki ekstra data
            if (intent.hasExtra("NAME") && intent.hasExtra("IMG") && intent.hasExtra("CONTENT")) {
                // Ambil data dari intent
                String name = intent.getStringExtra("NAME");
                int imageId = intent.getIntExtra("IMG", 0);
                String contentText = intent.getStringExtra("CONTENT");

                // Set gambar, nama, dan konten planet ke views
                planetImg.setImageResource(imageId);
                planetName.setText(name);

                // Memeriksa apakah konten lebih dari 100 karakter
                if (contentText.length() > 100) {
                    // Jika lebih dari 100 karakter, ambil hanya 100 karakter pertama
                    contentText = contentText.substring(0, 100);
                    // Tambahkan ellipsis (...) untuk menandakan bahwa konten dipotong
                    contentText += "...";
                }
                content.setText(contentText);
            } else {
                // Jika tidak, periksa apakah ada data planets yang dikirimkan
                ArrayList<Planet> planets = intent.getParcelableArrayListExtra("planets");
                if (planets != null && !planets.isEmpty()) {
                    // Ambil data planet pertama dari planets
                    Planet planet = planets.get(0);
                    // Set gambar, nama, dan konten planet ke views
                    planetImg.setImageResource(planet.getImageId());
                    planetName.setText(planet.getName());

                    // Memeriksa apakah konten lebih dari 100 karakter
                    String planetContent = planet.getContent();
                    if (planetContent.length() > 100) {
                        // Jika lebih dari 100 karakter, ambil hanya 100 karakter pertama
                        planetContent = planetContent.substring(0, 100);
                        // Tambahkan ellipsis (...) untuk menandakan bahwa konten dipotong
                        planetContent += "...";
                    }
                    content.setText(planetContent);
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        Intent intent = null;
        ArrayList<Planet> planets = new ArrayList<>();

        if (v.getId() == R.id.saturnus) {
            // Mendapatkan data planet Saturnus dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(6));
            intent = new Intent(this, Saturnus.class);
        } else if (v.getId() == R.id.mars) {
            // Mendapatkan data planet Mars dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(2));
            intent = new Intent(this, Mars.class);
        } else if (v.getId() == R.id.neptunus) {
            // Mendapatkan data planet Neptunus dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(4));
            intent = new Intent(this, Neptunus.class);
        } else if (v.getId() == R.id.merkurius) {
            // Mendapatkan data planet Merkurius dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(3));
            intent = new Intent(this, Merkurius.class);
        } else if (v.getId() == R.id.uranus) {
            // Mendapatkan data planet Uranus dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(7));
            intent = new Intent(this, Uranus.class);
        } else if (v.getId() == R.id.jupiter) {
            // Mendapatkan data planet Jupiter dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(1));
            intent = new Intent(this, Jupiter.class);
        } else if (v.getId() == R.id.venus) {
            // Mendapatkan data planet Venus dari DataSourcePlanet
            planets.add(DataSourcePlanet.getPlanets().get(5));
            intent = new Intent(this, Venus.class);
        } else if (v.getId() == R.id.btn_detail) {
            // Menambahkan data planet Earth ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(0));
            intent = new Intent(this, EarthDetails.class);
        }

        // Mengirim data planet yang dipilih ke aktivitas detail
        intent.putParcelableArrayListExtra("planets", planets);
        startActivity(intent);
    }

}
