package com.apps.multiboo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    Typeface custom_font;


    TextView skip,next;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screenshotone, container, false);
            skip=(TextView)v.findViewById(R.id.skip);
        next=(TextView)v.findViewById(R.id.next);

        custom_font = Typeface.createFromAsset(getActivity().getAssets(), "font/gretoon.ttf");
        skip.setTypeface(custom_font);
        next.setTypeface(custom_font);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Menupage.class);
                startActivity(intent);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean Firstclick;

                SharedPreferences app_preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());

                SharedPreferences.Editor editor = app_preferences.edit();

                Firstclick = app_preferences.getBoolean("Firstclick", true);

                if (Firstclick) {
                    HowActivity.pageclick(1);
                    editor.putBoolean("Firstclick", false);
                    editor.commit();

                }else{
//app open directly
//                    Musiccontinue=true;
                    HelpActivity.pageclick(1);

                }
            }
        });


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