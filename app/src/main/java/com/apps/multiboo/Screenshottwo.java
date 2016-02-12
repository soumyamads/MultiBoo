package com.apps.multiboo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by soumya on 1/24/2016.
 */
public class Screenshottwo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.screenshotwo, container, false);
        RelativeLayout layout =(RelativeLayout)v.findViewById(R.id.scrren1);
//        layout.setBackgroundResource(R.mipmap.screenshottwo);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean FirstTime;

                SharedPreferences preferences = PreferenceManager
                        .getDefaultSharedPreferences(getActivity());

                SharedPreferences.Editor editor = preferences.edit();

                FirstTime = preferences.getBoolean("FirstTime", true);
                Log.d(String.valueOf(FirstTime), "Firsttime");
                if (FirstTime) {
//                    Musiccontinue=true;
                    Intent intent = new Intent(getActivity(), SelectnumberActivity.class);
                    startActivity(intent);
                    getActivity().finish();
//implement your first time logic
                    editor.putBoolean("FirstTime", false);
                    editor.commit();
                    Log.d(String.valueOf(FirstTime), "fnt");


                }else{
//app open directly
//                    Musiccontinue=true;
                    Intent intent = new Intent(getActivity(), Menupage.class);
                    startActivity(intent);
                    Log.d(String.valueOf(FirstTime), "else");

                   getActivity(). finish();
                }


            }
        });



        return v;
    }

    public static Screenshottwo newInstance(String text) {

        Screenshottwo f = new Screenshottwo();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//
//        f.setArguments(b);

        return f;
    }
}