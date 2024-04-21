package com.example.spaceapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.spaceapp.DataSourcePlanet;
import com.example.spaceapp.Planet;
import com.example.spaceapp.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Mendapatkan data planet pertama (Earth) dari DataSourcePlanet
        List<Planet> planets = DataSourcePlanet.getPlanets();
        Planet earth = planets.get(0);

        ImageView ivArrowDown = findViewById(R.id.arrow_down);

        ivArrowDown.setOnClickListener(v -> {

            // Membuat intent untuk EarthDetails
            Intent intent = new Intent(this, Earth.class);
            intent.putExtra("NAME", earth.getName());
            intent.putExtra("IMG", earth.getImageId());
            intent.putExtra("CONTENT", earth.getContent());
            startActivity(intent);
        });
    }
}
