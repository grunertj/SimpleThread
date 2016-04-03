package com.jwg.grunert.simplethread;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    Button buttonStart, buttonStop;
    TextView textViewTime, textViewCounter,textViewAudio;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        buttonStart = (Button) view.findViewById(R.id.buttonStart);
        buttonStop = (Button) view.findViewById(R.id.buttonStop);

        textViewTime = (TextView) view.findViewById(R.id.textViewTime);
        textViewCounter = (TextView) view.findViewById(R.id.textViewCounter);
        textViewAudio = (TextView) view.findViewById(R.id.textViewAudio);

        return view;
    }

}
