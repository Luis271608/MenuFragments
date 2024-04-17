package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.menufragments.R;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListenerFromTheList{

    private static final Integer PORTRAIT_LAYOUT_MODE   = 1;
    private static final Integer LANDSCAPE_LAYOUT_MODE  = 2;

    private Integer layoutMode = PORTRAIT_LAYOUT_MODE;

    DetailFragment fragmentDetail;
    ListFragment fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.fragment_detail)!=null) {

            layoutMode = LANDSCAPE_LAYOUT_MODE;

            if (savedInstanceState == null) {

                fragmentDetail = new DetailFragment();

                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();

                transaction.add(R.id.fragment_detail, fragmentDetail, "frag_detail");
                transaction.commit();
            }
        }

    }

    @Override
    public void OnItemSelectedFromTheList(Integer mPosition) {



        Bundle args = new Bundle();
        args.putInt("Indice", mPosition);

        if (layoutMode == LANDSCAPE_LAYOUT_MODE) {

            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(args);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail, fragment)
                    .commit();
        } else {

            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra("args", args);
            startActivity(i);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

