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
import com.example.spaceapp.details.JupiterDetails;
import com.example.spaceapp.details.MarsDetails;
import com.example.spaceapp.details.MerkuriusDetails;
import com.example.spaceapp.details.NeptunusDetails;
import com.example.spaceapp.details.SaturnusDetails;

import java.util.ArrayList;

public class Saturnus extends AppCompatActivity implements View.OnClickListener {

    private TextView content, planetName;
    private ImageView planetImg, arrow_down;
    private ImageView neptunus, jupiter, merkurius, mars, uranus, venus, earth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saturnus);

        // Mengatur padding agar konten tidak terpotong oleh edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi elemen teks dan gambar
        content = findViewById(R.id.content);
        planetName = findViewById(R.id.planetName);
        planetImg = findViewById(R.id.planetImg);
        arrow_down = findViewById(R.id.btn_detail);

        neptunus = findViewById(R.id.neptunus);
        jupiter = findViewById(R.id.jupiter);
        merkurius = findViewById(R.id.merkurius);
        mars = findViewById(R.id.mars);
        uranus = findViewById(R.id.uranus);
        venus = findViewById(R.id.venus);
        earth = findViewById(R.id.earth);

        // Mengatur OnClickListener untuk ImageView dan Button
        neptunus.setOnClickListener(this);
        jupiter.setOnClickListener(this);
        merkurius.setOnClickListener(this);
        mars.setOnClickListener(this);
        uranus.setOnClickListener(this);
        venus.setOnClickListener(this);
        earth.setOnClickListener(this);
        arrow_down.setOnClickListener(this);

        // Tangkap data yang dikirimkan dari Earth
        ArrayList<Planet> planets = getIntent().getParcelableArrayListExtra("planets");

        // Pastikan data tidak null dan memiliki setidaknya satu item
        if (planets != null && !planets.isEmpty()) {
            // Ambil planet pertama dari ArrayList
            Planet planet = planets.get(0);
            // Set gambar, nama, dan konten planet ke views
            planetImg.setImageResource(planet.getImageId());
            planetName.setText(planet.getName());

            // Potong konten planet menjadi 100 karakter
            String truncatedContent = planet.getContent().substring(0, Math.min(planet.getContent().length(), 100));
            content.setText(truncatedContent);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        ArrayList<Planet> planets = new ArrayList<>();

        if (v.getId() == R.id.neptunus) {
            planets.add(DataSourcePlanet.getPlanets().get(4));
            intent = new Intent(this, Neptunus.class);
        } else if (v.getId() == R.id.jupiter) {
            planets.add(DataSourcePlanet.getPlanets().get(1));
            intent = new Intent(this, Jupiter.class);
        } else if (v.getId() == R.id.merkurius) {
            planets.add(DataSourcePlanet.getPlanets().get(3));
            intent = new Intent(this, Merkurius.class);
        } else if (v.getId() == R.id.mars) {
            planets.add(DataSourcePlanet.getPlanets().get(2));
            intent = new Intent(this, Mars.class);
        } else if (v.getId() == R.id.uranus) {
            planets.add(DataSourcePlanet.getPlanets().get(6));
            intent = new Intent(this, Uranus.class);
        } else if (v.getId() == R.id.earth) {
            planets.add(DataSourcePlanet.getPlanets().get(0));
            intent = new Intent(this, Earth.class);
        } else if (v.getId() == R.id.venus) {
            planets.add(DataSourcePlanet.getPlanets().get(7));
            intent = new Intent(this, Venus.class);
        } else if (v.getId() == R.id.btn_detail) {
            planets.add(DataSourcePlanet.getPlanets().get(5));
            intent = new Intent(this, SaturnusDetails.class);
        }

        // Mengirim data planet yang dipilih ke aktivitas detail
        if (intent != null) {
            // Mengirim data planet yang dipilih ke aktivitas detail
            intent.putParcelableArrayListExtra("planets", planets);
            startActivity(intent);
        }
    }
}
