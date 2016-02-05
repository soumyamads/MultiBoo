package com.apps.multiboo;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;

import com.apps.multiboo.R;


/**
 * Created by snyxius on 9/8/2015.
 */
public class SplashActivity extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    Typeface custom_font;
    Animation shake;

    //    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);
        custom_font = Typeface.createFromAsset(getAssets(), "font/gretoon.ttf");
//        TextView loading=(TextView)findViewById(R.id.loading);
//        loading.setTypeface(custom_font);
//        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);
//        shake.setDuration(4000);
//        loading.startAnimation(shake);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, Menupage.class);
                startActivity(i);
                finish();
                //Apply splash exit (fade out) and main entry (fade in) animation transitions.
//                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }


        }, SPLASH_TIME_OUT);
//
//        final Dialog dialog = new  Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.loadingdialog);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        TextView loading=(TextView)dialog.findViewById(R.id.loading);
//        loading.setTypeface(custom_font);
//        dialog.show();
//
//        Runnable progressRunnable = new Runnable() {
//
//            @Override
//            public void run() {
//                dialog.cancel();
//            }
//        };
//
//        Handler pdCanceller = new Handler();
//        pdCanceller.postDelayed(progressRunnable, 3000);
}



}
