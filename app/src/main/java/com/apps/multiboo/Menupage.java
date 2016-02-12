package com.apps.multiboo;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.media.MediaPlayer;

import com.apps.multiboo.R;

/**
 * Created by Snyxius on 11/16/2015.
 */
public class Menupage extends AppCompatActivity {
    LinearLayout play;
    LinearLayout highscore, settings;
    ImageView yes, no;
    TextView quit;
    Typeface custom_font;
    TextView playtext, highcoretext, settingstext;
    MediaPlayer backgroundmusic;
    ImageView sound, mute, help, close,multibooheading;
    protected SQLiteDatabase db;
    String datevalue;
    int scores;
//    static boolean mutes=false;
    SharedPreferences prefs;
    Animation shake;
    Boolean Musiccontinue=false;
    Boolean mutes;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = (new DatabaseHelper(this)).getWritableDatabase();
      multibooheading = (ImageView)findViewById(R.id.multiboo);
//        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);
//        shake.setDuration(2000);
//        multibooheading.startAnimation(shake);
        Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
//        overridePendingTransition(R.anim.mainfadein, R.anim.splashfadeout);



//         prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        System.out.println("prefs"+prefs);
//
//        System.out.println("mute"+mutes);
//        Boolean mutes;


        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(Menupage.this);

        editor = app_preferences.edit();
        mutes = app_preferences.getBoolean("mute", false);

        if (mutes) {
//maybe you want to check it by getting the sharedpreferences. Use this instead if (locked)
// if (prefs.getBoolean("mute", mutes) {

//            prefs.edit().putBoolean("mute", false).commit();
        } else {

            startService(new Intent(this, BackgroundSoundService.class));
        }

        custom_font = Typeface.createFromAsset(getAssets(), "font/gretoon.ttf");
        playtext = (TextView) findViewById(R.id.play_text);
        highcoretext = (TextView) findViewById(R.id.highscore_text);
        settingstext = (TextView) findViewById(R.id.settings_text);
        highscore = (LinearLayout) findViewById(R.id.hihscorelnr);
        settings = (LinearLayout) findViewById(R.id.settinglinear);

        playtext.setTypeface(custom_font);
        highcoretext.setTypeface(custom_font);
        settingstext.setTypeface(custom_font);

        play = (LinearLayout) findViewById(R.id.linearplay);



        play.setAnimation(zoomin);
        settings.setAnimation(zoomin);
        highscore.setAnimation(zoomin);




        highscore.startAnimation(zoomin);
        settings.startAnimation(zoomin);
        play.startAnimation(zoomin);

//

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isFirstTime;

                SharedPreferences app_preferences = PreferenceManager
                        .getDefaultSharedPreferences(Menupage.this);

                SharedPreferences.Editor editor = app_preferences.edit();

                isFirstTime = app_preferences.getBoolean("isFirstTime", true);

                if (isFirstTime) {
                    Musiccontinue=true;
                    Intent intent = new Intent(Menupage.this, HowActivity.class);
                    startActivity(intent);
//                    finish();
//implement your first time logic
                    editor.putBoolean("isFirstTime", false);
                    editor.commit();

                }else{
//app open directly
                    Musiccontinue=true;
                    Intent intent = new Intent(Menupage.this, SelectnumberActivity.class);
                    startActivity(intent);
//                    finish();
                }

            }
        });
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog highscoredialog = new Dialog(Menupage.this);
                highscoredialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                highscoredialog.setCancelable(false);

                highscoredialog.setContentView(R.layout.highscores);
                highscoredialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                LinearLayout date = (LinearLayout) highscoredialog.findViewById(R.id.hihscorelnr);

                TextView topscore = (TextView) highscoredialog.findViewById(R.id.high_head);
                String query = "Select * FROM " + "scoretable" + " ORDER BY " + "Score" + " DESC LIMIT 1";

                topscore.setTypeface(custom_font);

//                int count=0;
                Cursor cursor = db.rawQuery(query, null);


                while (cursor.moveToNext()) {
//                    count++;
//                    datevalue = cursor.getString(cursor.getColumnIndex("Date"));
                    scores = cursor.getInt(cursor.getColumnIndex("Score"));




                    TextView date1 = new TextView(Menupage.this);
//                    date1.setText(count + " " + ":" + "   " + scores);
                    date1.setText(""+scores);
//                    date1.setTypeface(null, Typeface.BOLD);
                    date1.setTypeface(custom_font);

                    date1.setTextSize(20);
                    date1.setTextColor(Color.parseColor("#0000ff"));
                    date.addView(date1);

                }
                cursor.close();

                ImageView back = (ImageView) highscoredialog.findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        highscoredialog.dismiss();
//                        dialog.show();


                    }
                });

                highscoredialog.show();
//                dialog.dismiss();
//
            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog settingsdialog = new Dialog(Menupage.this);
                settingsdialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                settingsdialog.setCancelable(false);

                settingsdialog.setContentView(R.layout.settings);
                settingsdialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                sound = (ImageView) settingsdialog.findViewById(R.id.volume);
                close = (ImageView) settingsdialog.findViewById(R.id.close);
                mute = (ImageView) settingsdialog.findViewById(R.id.mute);
                help = (ImageView) settingsdialog.findViewById(R.id.help);
if(mutes){
    sound.setVisibility(View.GONE);
    mute.setVisibility(View.VISIBLE);
}else{
    sound.setVisibility(View.VISIBLE);
    mute.setVisibility(View.GONE);

}

                sound.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        backgroundmusic.stop();
//                        mutes=false;
                        editor.putBoolean("mute", true);
editor.commit();
//                        mutes=true;
//                        System.out.println("muteb4"+mutes);
//                        prefs.getBoolean("mute", false);
//
//                        prefs.edit().putBoolean("mute", true).commit();
                        System.out.println("mute3" + mutes);

                        sound.setVisibility(View.GONE);
                        mute.setVisibility(View.VISIBLE);

                        stopService(new Intent(Menupage.this, BackgroundSoundService.class));
//                        backgroundmusic.stop();

                    }
                });
                mute.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

//                        backgroundmusic.start();
//                        mutes=false;
                        editor.putBoolean("mute", false);
                        editor.commit();
//                        prefs.edit().getBoolean("mute", true.commit();
//                        prefs.getBoolean("mute", false);
//                        prefs.edit().putBoolean("mute", false).commit();
                        sound.setVisibility(View.VISIBLE);
                        mute.setVisibility(View.GONE);
                        startService(new Intent(Menupage.this, BackgroundSoundService.class));
                    }
                });
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplication(),HelpActivity.class);
                        startActivity(intent);
                        finish();

                    }
                });
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        settingsdialog.dismiss();

                    }
                });

                settingsdialog.show();
            }

        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog1 = new Dialog(Menupage.this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog1.setContentView(R.layout.exit_activity);
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        yes = (ImageView) dialog1.findViewById(R.id.yes);
//                level = (ImageView) dialog.findViewById(R.id.level);
        no = (ImageView) dialog1.findViewById(R.id.no);
        quit = (TextView) dialog1.findViewById(R.id.game_over_scorevalue);
        quit.setTypeface(custom_font);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(startMain);
                stopService(new Intent(Menupage.this, BackgroundSoundService.class));
//                stopService(new Intent(BackgroundSoundService.MEDIA_SESSION_SERVICE));
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        dialog1.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!Musiccontinue) {
if(mutes){

}else {
    Musiccontinue=true;
    stopService(new Intent(this, BackgroundSoundService.class));
}
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        stopService(new Intent(this, BackgroundSoundService.class));

    }

    @Override
    protected void onResume() {

        super.onResume();
        SharedPreferences app_preferences = PreferenceManager
                .getDefaultSharedPreferences(Menupage.this);

        editor = app_preferences.edit();
        mutes = app_preferences.getBoolean("mute", false);
        if (Musiccontinue) {
            if(mutes){

            }else {
                Musiccontinue=false;
                startService(new Intent(this, BackgroundSoundService.class));
            }

        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        stopService(new Intent(this, BackgroundSoundService.class));

    }
}