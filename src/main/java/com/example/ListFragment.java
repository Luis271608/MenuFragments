package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.menufragments.R;

public class ListFragment extends Fragment {

        private static final Integer PORTRAIT_LAYOUT_MODE   = 1;
        private static final Integer LANDSCAPE_LAYOUT_MODE  = 2;

        private OnItemSelectedFromTheList mItemListener;

        private Integer layoutMode = PORTRAIT_LAYOUT_MODE;
        private Integer mPosition = -1;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 final Bundle savedInstanceState) {

            Bundle arguments = getArguments();
            if (arguments != null) {
                layoutMode = arguments.getInt("LayoutMode");
            }

            if(savedInstanceState!=null){
                mPosition = savedInstanceState.getInt("position");
            }

            final View rootView = inflater.inflate(R.layout.fragment_list, container, false);

            ListView mylistview = (ListView) rootView.findViewById(R.id.listView);

            String[] alumnos = getResources().getStringArray(R.array.alumnos);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
                    android.R.layout.simple_list_item_1, android.R.id.text1, alumnos);

            mylistview.setAdapter(adapter);

            if(mPosition >= 0)
                mylistview.setSelection(mPosition);

            mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                    mItemListener.OnItemSelectedFromTheList(position);

                }
            });

            return rootView;
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);

            outState.putInt("position", mPosition);
        }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            try {
                mItemListener = (OnItemSelectedFromTheList) activity;

            } catch (ClassCastException castException) {

            }
        }

    }

