package com.apps.multiboo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.multiboo.R;

/**
 * Created by soumya on 1/24/2016.
 */
public class Screenshotone extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screenshotone, container, false);



        return v;
    }

    public static Screenshotone newInstance(String text) {

        Screenshotone f = new Screenshotone();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }
}