package com.agung.bp3_m4_games_activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import android.widget.TabHost;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laderboard);

        // Inisialisasi TabHost
        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        // Tab Local
        TabHost.TabSpec localTab = tabHost.newTabSpec("Local");
        localTab.setIndicator("Local");
        localTab.setContent(R.id.tabLocalContainer);
        tabHost.addTab(localTab);

        // Tab Global
        TabHost.TabSpec globalTab = tabHost.newTabSpec("Global");
        globalTab.setIndicator("Global");
        globalTab.setContent(R.id.tabGlobalContainer);
        tabHost.addTab(globalTab);

        // Load fragment ke setiap tab
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.tabLocalContainer, new tablocal())
//                .commit();
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.tabGlobalContainer, new tabglobal())
//                .commit();
    }
}
