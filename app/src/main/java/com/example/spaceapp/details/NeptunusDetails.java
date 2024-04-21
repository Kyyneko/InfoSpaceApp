package com.example.spaceapp.details;

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
import com.example.spaceapp.main.Earth;
import com.example.spaceapp.main.Jupiter;
import com.example.spaceapp.main.Mars;
import com.example.spaceapp.main.Merkurius;
import com.example.spaceapp.main.Neptunus;
import com.example.spaceapp.main.Saturnus;
import com.example.spaceapp.main.Uranus;
import com.example.spaceapp.main.Venus;

import java.util.ArrayList;

public class NeptunusDetails extends AppCompatActivity implements View.OnClickListener {

    ImageView earth, saturnus, mars, neptunus, merkurius, uranus, jupiter, venus;
    private ImageView planetImg, image1, image2, image3;
    private TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_neptunus_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi ImageView
        earth = findViewById(R.id.earth);
        saturnus = findViewById(R.id.saturnus);
        mars = findViewById(R.id.mars);
        neptunus = findViewById(R.id.neptunus);
        merkurius = findViewById(R.id.merkurius);
        uranus = findViewById(R.id.uranus);
        jupiter = findViewById(R.id.jupiter);
        venus = findViewById(R.id.venus);

        // Mengatur OnClickListener untuk ImageView dan Button
        earth.setOnClickListener(this);
        saturnus.setOnClickListener(this);
        mars.setOnClickListener(this);
        neptunus.setOnClickListener(this);
        merkurius.setOnClickListener(this);
        uranus.setOnClickListener(this);
        jupiter.setOnClickListener(this);
        venus.setOnClickListener(this);

        // Inisialisasi views
        planetImg = findViewById(R.id.planetImg);
        content = findViewById(R.id.content);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        // Tangkap data yang dikirimkan dari Earth
        ArrayList<Planet> planets = getIntent().getParcelableArrayListExtra("planets");

        // Pastikan data tidak null dan memiliki setidaknya satu item
        if (planets != null && !planets.isEmpty()) {
            // Ambil data planet pertama (misalnya, planet Earth)
            Planet planet = planets.get(0);
            // Set gambar, nama, dan konten planet ke views
            planetImg.setImageResource(planet.getImageId());
            image1.setImageResource(planet.getImage1());
            image2.setImageResource(planet.getImage2());
            image3.setImageResource(planet.getImage3());
            content.setText(planet.getContent());
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        ArrayList<Planet> planets = new ArrayList<>();
        if (v.getId() == R.id.earth) {
            // Menambahkan data planet Earth ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(0));
            intent = new Intent(this, Earth.class);
        } else if (v.getId() == R.id.saturnus) {
            // Menambahkan data planet Saturnus ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(6));
            intent = new Intent(this, Saturnus.class);
        } else if (v.getId() == R.id.mars) {
            // Menambahkan data planet Mars ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(2));
            intent = new Intent(this, Mars.class);
        } else if (v.getId() == R.id.neptunus) {
            // Menambahkan data planet Neptunus ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(4));
            intent = new Intent(this, Neptunus.class);
        } else if (v.getId() == R.id.merkurius) {
            // Menambahkan data planet Merkurius ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(3));
            intent = new Intent(this, Merkurius.class);
        } else if (v.getId() == R.id.uranus) {
            // Menambahkan data planet Uranus ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(7));
            intent = new Intent(this, Uranus.class);
        } else if (v.getId() == R.id.venus) {
            // Menambahkan data planet Venus ke ArrayList planets
            planets.add(DataSourcePlanet.getPlanets().get(5));
            intent = new Intent(this, Venus.class);
        }

        if (intent != null) {
            intent.putParcelableArrayListExtra("planets", planets);
            startActivity(intent);
        }
    }
}
