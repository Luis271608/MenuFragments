package com.example;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menufragments.R;

public class DetailActivity  extends AppCompatActivity {

    private DetailFragment fragmentDetail;
    private Bundle params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        params = getIntent().getBundleExtra("args");

        if (savedInstanceState == null) {

            fragmentDetail = new DetailFragment();

            if(params!=null) {
                fragmentDetail.setArguments(params);
            }

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_detail_container, fragmentDetail)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
