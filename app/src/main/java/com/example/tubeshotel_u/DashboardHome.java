/*package com.example.tubeshotel_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DashboardHome extends AppCompatActivity {
    ImageView imagejayakarta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_home);

        imagejayakarta=(ImageView) findViewById(R.id.jayakartaHotel);
        imagejayakarta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHotelmenu1();
            }
        });
    }
    public void openHotelmenu1(){
        Intent intent = new Intent(this,Hotelmenu1.class);
        startActivity(intent);
    }
}
*/