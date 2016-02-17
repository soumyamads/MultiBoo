package com.apps.multiboo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by snyxius on 11/12/15.
 */
public class Star_Activity extends Activity {

    Boolean gameover=false;
    static int animDuration;
    static int popupDuration;
    static int delayValue;
    int lifecounter = 0;
    static int i = 0;
    int n;
    static int k = 0;
    int randvalue;
    int scorealue;
    int height=0;
    int width=0;
    static    boolean first_play=true;
    static int highscore=0;
    String datevalue ;
    int scores;
    int num;
    private int[] LEAVES = {
            
            R.drawable.star1,
            R.drawable.bomb,

    };

    private MediaPlayer mp;
    ValueAnimator animator;
    private Rect mDisplaySize = new Rect();
    static int mInt;
    private RelativeLayout mRootLayout;
    private ArrayList<View> mAllImageViews = new ArrayList<View>();
    RelativeLayout relativeLayout;
    private float mScale;
    ImageView imageView, pausebutton;
    ImageView resume, level, score, exit;
    TextView gamescore, gamescorevalue, numbertext;
    ImageView replay, menu;
    ImageView life1, life2, life3;
    TextView scorevalue, scoretext;
    Typeface custom_font;
    RelativeLayout relativeLayout1,relativeLayout3;
    MyTask task2;
    ExeTimerTask task1;

    TextView animtext;
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    private static int SPLASH_TIME_OUT = 50;
    protected SQLiteDatabase db;
    int num1;
    Boolean Musiccontinue=false;
    Boolean pause=false;
    Boolean star=false;


    //    Intent svc;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();





        db = (new DatabaseHelper(this)).getWritableDatabase();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        animDuration = 9500;
        popupDuration = 1200;
        delayValue=800;

        Display display = getWindowManager().getDefaultDisplay();
        display.getRectSize(mDisplaySize);

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        mScale = metrics.density;

        height = metrics.heightPixels;
        width = metrics.widthPixels;

        Log.d(String.valueOf(mDisplaySize.bottom), "top");
        Log.d(String.valueOf(height),"hgt");

        mRootLayout = (RelativeLayout) findViewById(R.id.main_layout);
        life1 = (ImageView) findViewById(R.id.life11);
        life2 = (ImageView) findViewById(R.id.life21);
        life3 = (ImageView) findViewById(R.id.life31);
        scorevalue = (TextView) findViewById(R.id.score_value1);
        scoretext = (TextView) findViewById(R.id.score1);
        pausebutton = (ImageView) findViewById(R.id.pause);
        pausebutton.setEnabled(true);

        //getting balloon number which click

        Bundle b = getIntent().getExtras();
        mInt = b.getInt("Integer");


        custom_font = Typeface.createFromAsset(getAssets(), "font/gretoon.ttf");
        scoretext.setTypeface(custom_font);
        scorevalue.setTypeface(custom_font);

        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                task1.cancel();
//                task2.cancel();
//                pause=true;
//
////mHandler.removeCallbacksAndMessages(animator);
//                mRootLayout.removeAllViews();
//                mRootLayout.addView(pausebutton);
//                stopTask();
                Onpausing();
            }
        });


        task1 = new ExeTimerTask();
        new Timer().schedule(task1, delayValue, popupDuration);

        task2 = new MyTask();
        new Timer().schedule(task2, animDuration, animDuration);


//        Toast.makeText(getApplication(), "speed11=" + animDuration+"pop11=" + popupDuration, Toast.LENGTH_LONG).show();
//        startAnimation(relativeLayout);


    }

    public void startAnimation(final RelativeLayout aniView) {

        aniView.setPivotX(aniView.getWidth() / 2);
        aniView.setPivotY(aniView.getHeight() / 2);

//        long delay = new Random().nextInt(1000);

        animator = ValueAnimator.ofFloat(1, 0.0f);
//        animator.setDuration(Constants.ANIM_DURATION);
//        animator.setInterpolator(new AccelerateInterpolator());
//        animator.setInterpolator(new MyInterpolator());

//        animator.setStartDelay(500);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(animDuration);



        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            //            int movex = new Random().nextInt(mDisplaySize.right);
            int movex = new Random().nextInt(mDisplaySize.right - 200);


            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = ((Float) (animation.getAnimatedValue())).floatValue();

//                aniView.setRotation(angle*value);
                aniView.setTranslationX((movex + getRandom(0, 1) * value));
                aniView.setTranslationY((mDisplaySize.bottom + (90 * mScale)) * value);
//                Log.d("y", "" + (mDisplaySize.bottom + (90 * mScale)) * value);
//                Log.d("x", "" + (movex + getRandom(0, 1) * value));


//                System.out.print("botomscreen"+mDisplaySize.bottom);


            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                if (!gameover) {
                    if (!pause) {
                        RelativeLayout rl = (RelativeLayout) aniView;
                        final ImageView imageView1 = (ImageView) rl.findViewById(R.id.aniImageView);
//        imageView1.setImageResource(R.drawable.blast);
                        final TextView numbertext = (TextView) rl.findViewById(R.id.numbertext);
                        CharSequence value1 = numbertext.getText();

                        num1 = Integer.parseInt(value1.toString());

//            Toast.makeText(getApplication(), "NUmber" + num1+"mint"+mInt, Toast.LENGTH_SHORT).show();
//            mHandler.removeCallbacksAndMessages(null);

                        if (num1 % mInt == 0) {
                            //  gameoverlife();


                        }
                    }

                }
            }


            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                animator.cancel();
                task1.cancel();
                task2.cancel();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

        animator.start();
    }

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(final Message msg) {
            super.handleMessage(msg);

            int viewId = new Random().nextInt(LEAVES.length);
            Drawable d = getResources().getDrawable(LEAVES[viewId]);
            LayoutInflater inflate = LayoutInflater.from(Star_Activity.this);

            View child = getLayoutInflater().inflate(R.layout.duplicate, null);
            relativeLayout = (RelativeLayout) child.findViewById(R.id.balloon_container);
//            relativeLayout3 = (RelativeLayout) child.findViewById(R.id.star_container);

            imageView = (ImageView) child.findViewById(R.id.aniImageView);
            animtext = (TextView) child.findViewById(R.id.numbertext);
//


            animtext.setTypeface(custom_font);
            imageView.setImageDrawable(d);
            if( d.getConstantState().equals
                    (getResources().getDrawable(R.drawable.star1).getConstantState())||d.getConstantState().equals
                    (getResources().getDrawable(R.drawable.bomb).getConstantState()))
            {
                System.out.println("star");
                animtext.setVisibility(View.GONE);
                relativeLayout.removeView(animtext);
//relativeLayout.removeView(animtext);
            }

//            task1 = new ExeTimerTask();
//            new Timer().schedule(task1, delayValue, popupDuration);
//
//            task2 = new MyTask();
//            new Timer().schedule(task2, animDuration, animDuration);


            k++;

// getting random numbers from 1 to 100
            randvalue = Integer.parseInt(String.valueOf(getRandom(2, 100)));


            if (!sharedpreferences.getString("lastValue", "").equals("")) {
                String name = sharedpreferences.getString("lastValue", "");

                num = Integer.valueOf(name);
            }

            if (k == 1) {
                animtext.setText(String.valueOf(randvalue));

                relativeLayout.setTag(animtext.getText().toString());

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("lastValue", animtext.getText().toString());
                editor.commit();

            } else if (k > 1) {


                if (num % mInt == 0) {
                    if (randvalue % mInt == 0) {

                        animtext.setText(String.valueOf(randvalue + 1));
                        int number = randvalue + 1;


                        relativeLayout.setTag(animtext.getText().toString());

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("lastValue", animtext.getText().toString());
                        editor.commit();

                    } else {
                        animtext.setText(String.valueOf(randvalue));

                        relativeLayout.setTag(animtext.getText().toString());
                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("lastValue", animtext.getText().toString());
                        editor.commit();

                    }

                } else {


                    animtext.setText(String.valueOf(getRandomMultplication(1, 11)));
                    relativeLayout.setTag(animtext.getText().toString());

                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString("lastValue", animtext.getText().toString());
                    editor.commit();

                }
            }


            //Balloon click
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView bombs ,stars ;

                    int num = Integer.valueOf(v.getTag().toString());

//correct bursting balloon

                    if (num % mInt == 0) {

                        //seeting score by 10
                        n += 10;

                        scorevalue.setText(String.valueOf(n));

                        relativeLayout1 = (RelativeLayout) v;
                        final ImageView imageView1 = (ImageView) relativeLayout1.findViewById(R.id.aniImageView);
                        if(imageView1.getDrawable().getConstantState()==Star_Activity.this.getResources().getDrawable(R.drawable.star1).getConstantState())
                        {
                            Toast.makeText(getApplicationContext(),"star",Toast.LENGTH_LONG).show();
                            n+=90;
                            scorevalue.setText(String.valueOf(n));

                            imageView1.setImageResource(R.drawable.star_explosion);

                        }
                        else if(imageView1.getDrawable().getConstantState()==Star_Activity.this.getResources().getDrawable(R.drawable.bomb).getConstantState())
                        {
                            Toast.makeText(getApplicationContext(),"bomb",Toast.LENGTH_LONG).show();
                            n+=-10;
                            scorevalue.setText(String.valueOf(n));
                            imageView1.setImageResource(R.drawable.bomb_explosion);


                            gameoverlife();


                        }


                        imageView1.setImageResource(R.drawable.blast);
                        numbertext = (TextView) relativeLayout1.findViewById(R.id.numbertext);
                        mp = MediaPlayer.create(Star_Activity.this, R.raw.correctblast);
                        mp.start();


                        Animation fadeOut = new AlphaAnimation(1, 0);
                        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                        fadeOut.setStartOffset(90);
                        fadeOut.setDuration(250);
                        new Handler().postDelayed(new Runnable() {
//
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                            @Override
                            public void run() {
                                // This method will be executed once the timer is over
                                // Start your app main activity
                                mRootLayout.removeView(relativeLayout1);
                                relativeLayout1.setVisibility(View.GONE);

                            }
                        }, SPLASH_TIME_OUT);

                        AnimationSet animation = new AnimationSet(false); //change to false
                        animation.addAnimation(fadeOut);
                        animation.setFillAfter(true);
                        relativeLayout1.setAnimation(animation);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
//
                                relativeLayout1.setVisibility(View.GONE);

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                relativeLayout1.setVisibility(View.GONE);


                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        CharSequence value1 = numbertext.getText();

                        num1 = Integer.parseInt(value1.toString());
                        numbertext.setText(String.valueOf(num1 + 1));

                    }
                    //wrong blast balloon

                    else {
                        relativeLayout1 = (RelativeLayout) v;

                        final ImageView imageView1 = (ImageView) relativeLayout1.findViewById(R.id.aniImageView);
//                        if(imageView1.getDrawable().getConstantState()==Star_Activity.this.getResources().getDrawable(R.drawable.star1).getConstantState())
                        {
//                            CharSequence value1 = numbertext.getText();

//                            num1 = Integer.parseInt(value1.toString());
//                            numbertext.setText(String.valueOf(0 +mInt ));
                            Toast.makeText(getApplicationContext(),"star",Toast.LENGTH_LONG).show();
                            n+=100;
                            scorevalue.setText(String.valueOf(n));
                            imageView1.setImageResource(R.drawable.star_explosion);




                        }
//                        else  if(imageView1.getDrawable().getConstantState()==Star_Activity.this.getResources().getDrawable(R.drawable.bomb).getConstantState())
//                        {
//                            Toast.makeText(getApplicationContext(),"bomb",Toast.LENGTH_LONG).show();
//
////                            gameoverlife();
//                            imageView1.setImageResource(R.drawable.bomb_explosion);
//
//
//                        }
                        imageView1.setImageResource(R.drawable.wrongblast);

//                        mp = MediaPlayer.create(Star_Activity.this, R.raw.wrongclick);
                        mp.start();
//                         giving fadeout animation
                        Animation fadeOut = new AlphaAnimation(1, 0);
                        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                        fadeOut.setStartOffset(90);

                        fadeOut.setDuration(250);
                        new Handler().postDelayed(new Runnable() {
//
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                            @Override
                            public void run() {
                                // This method will be executed once the timer is over
                                // Start your app main activity
                                mRootLayout.removeView(relativeLayout1);
                                relativeLayout1.setVisibility(View.GONE);

                            }
                        }, SPLASH_TIME_OUT);

                        AnimationSet animation = new AnimationSet(false); //change to false
                        animation.addAnimation(fadeOut);
                        animation.setFillAfter(true);

                        relativeLayout1.setAnimation(animation);
                        animation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                relativeLayout1.setVisibility(View.GONE);


                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        gameoverlife();



                    }


                }
            });

//            RelativeLayout relativeLayout=(RelativeLayout)inflate.inflate(R.layout.duplicate,null);
//            relativeLayout.setBackgroundResource();
//            relativeLayout.setBackgroundResource();
            mRootLayout.addView(relativeLayout);
//            mRootLayout.addView(relativeLayout3);



            RelativeLayout.LayoutParams animationLayout = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            animationLayout.setMargins(0, (int) (-180 * mScale), 0, 0);
//            Log.d("x", "" + (int) (mScale));

            startAnimation(relativeLayout);

//            startAnimation(relativeLayout3);

        }
    };
    //generating multiplication value
    private static int getRandomMultplication(int i, int i1) {
        Random r = new Random();
        int values = r.nextInt((i1 - i) + i) * mInt;

        if (values == 0) {
            values++;
        }
        return values;

    }
//generating random numbers

    public static int getRandom(int startvalue, int endvalue) {


        Random r = new Random();
        int values = r.nextInt((endvalue - startvalue) + startvalue);

        return values;
    }



    class MyTask extends TimerTask {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    task1.cancel();
                    task2.cancel();

                    if (animDuration>3000) {
                        animDuration=animDuration-500;

                        task2 = new MyTask();
                        new Timer().schedule(task2, animDuration, animDuration);



                    }

                    if (popupDuration>200) {
                        popupDuration=popupDuration-60;
                        task1 = new ExeTimerTask();
                        new Timer().schedule(task1, delayValue, popupDuration);

                    }

//                    Toast.makeText(getApplication(), "speed=" + animDuration+"pop=" + popupDuration, Toast.LENGTH_LONG).show();

                }
            });
        }

    }
    private void gameoverlife(){
        if (lifecounter == 3) {
            mp = MediaPlayer.create(this, R.raw.wronganswer);
            mp.start();
            final Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

            dialog.setContentView(R.layout.gameover);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


            gamescore = (TextView) dialog.findViewById(R.id.game_over_score);
            gamescorevalue = (TextView) dialog.findViewById(R.id.game_over_scorevalue);
            replay = (ImageView) dialog.findViewById(R.id.replay);
            menu = (ImageView) dialog.findViewById(R.id.menu);
            gamescorevalue.setTypeface(custom_font);
            gamescore.setTypeface(custom_font);
            stopTask();
            task1.cancel();
            task2.cancel();
            mRootLayout.removeAllViews();

            String dateFormat = "dd/MM";
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            String date = sdf.format(cal.getTime());

            final int starting = 0;
            int score_value = Integer.parseInt(scorevalue.getText().toString());
            SharedPreferences.Editor editor = sharedpreferences.edit();


            if(first_play) {
                highscore = score_value;

                ContentValues values = new ContentValues();
                values.put("Date", date);
                values.put("Score", highscore);
                long res=db.insert("scoretable", null, values);

                first_play=false;
            }
            else
            {
                if(score_value>highscore)
                {

                    highscore=score_value;

                    ContentValues values = new ContentValues();
                    values.put("Date", date);
                    values.put("Score", highscore);
                    long res=db.insert("scoretable", null, values);
//                                    if(res!=-1){
//                                        Toast.makeText(getApplicationContext(),"values insert",Toast.LENGTH_LONG).show();
//                                    }
//                                    else {
//                                        Toast.makeText(getApplicationContext(),"not insert",Toast.LENGTH_LONG).show();
//
//
////                                    }
                }

            }

//animation for highscore inside gameover
            ValueAnimator animator = new ValueAnimator();
            animator.setObjectValues(0, score_value);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator animation) {
                    gamescorevalue.setText(String.valueOf(animation.getAnimatedValue()));
                }
            });
            animator.setEvaluator(new TypeEvaluator<Integer>() {
                public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
                    return Math.round(startValue + (endValue - startValue) * fraction);
                }
            });
            animator.setDuration(1000);
            animator.start();

//                            gamescorevalue.setText(scorevalue.getText());
            replay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                                    mRootLayout.addView(pausebutton);
//                                    life1.setVisibility(View.VISIBLE);
//                                    life2.setVisibility(View.VISIBLE);
//
//                                    life3.setVisibility(View.VISIBLE);
//                                    scorevalue.setText(String.valueOf(0));
//                                    n = 0;
//                                    animDuration=9500;
//                                    popupDuration=1200;
//                                    delayValue=1000;
//                                    task1 = new ExeTimerTask();
//                                    new Timer().schedule(task1, delayValue, popupDuration);
//                                    task2 = new MyTask();
//
//                                    new Timer().schedule(task2, animDuration, animDuration);
//
//                                    dialog.dismiss();

                    dialog.dismiss();
                    task2.cancel();
                    task1.cancel();
//                    Intent intent = new Intent(getApplication(), Star_Activity.class);
                    Bundle b=new Bundle();
                    b.putInt("Integer", mInt);
//                    intent.putExtras(b);
//                    startActivity(intent);
                    Musiccontinue=true;

                    finish();


                }
            });
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), Menupage.class);
                    startActivity(intent);
                    Musiccontinue=true;
                    finish();
                }
            });
            dialog.show();
//mHandler.removeCallbacksAndMessages(null);
            task2.cancel();
            task1.cancel();
            lifecounter = 0;
        } else {
            if (lifecounter == 0) {
//                                mp = MediaPlayer.create(Star_Activity.this, R.raw.wrongblast);
//                                mp.start();
                life3.setVisibility(View.INVISIBLE);
                lifecounter++;
            } else if (lifecounter == 1) {
//                                mp = MediaPlayer.create(Star_Activity.this, R.raw.wrongblast);
//                                mp.start();
                life2.setVisibility(View.INVISIBLE);
                lifecounter++;

            } else if (lifecounter == 2) {
//                                mp = MediaPlayer.create(Star_Activity.this, R.raw.wrongblast);
//                                mp.start();
                life1.setVisibility(View.INVISIBLE);
                lifecounter++;

            }

        }

    }




    private void Onpausing() {
//        mRootLayout.removeView(relativeLayout);
        task1.cancel();
        task2.cancel();
        pause=true;

//mHandler.removeCallbacksAndMessages(animator);
        mRootLayout.removeAllViews();
        mRootLayout.addView(pausebutton);
        stopTask();
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.menudialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        resume = (ImageView) dialog.findViewById(R.id.resume);
//                level = (ImageView) dialog.findViewById(R.id.level);
        score = (ImageView) dialog.findViewById(R.id.score);
        exit = (ImageView) dialog.findViewById(R.id.exit);
//    close = (ImageView) dialog.findViewById(R.id.close);


        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                       animator.start();
                new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

                    @Override
                    public void run() {
                        // This method will be executed once the timer is over
                        // Start your app main activity
                        pause=false;

                        //Apply splash exit (fade out) and main entry (fade in) animation transitions.
//                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    }


                }, animDuration);
                task1 = new ExeTimerTask();
                new Timer().schedule(task1, delayValue, popupDuration);
                task2 = new MyTask();

                new Timer().schedule(task2, animDuration, animDuration);
                dialog.dismiss();
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task1.cancel();
                task2.cancel();
                Intent i = new Intent(getApplication(), Menupage.class);
                Musiccontinue=true;
                startActivity(i);
                finish();

            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setHighScore();
                task2.cancel();
                task1.cancel();
                final Dialog highscoredialog = new Dialog(Star_Activity.this);
                highscoredialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                highscoredialog.setCancelable(false);

                highscoredialog.setContentView(R.layout.highscores);
                highscoredialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//
                TextView topscore = (TextView) highscoredialog.findViewById(R.id.high_head);
                LinearLayout date = (LinearLayout) highscoredialog.findViewById(R.id.hihscorelnr);
                String query = "Select * FROM " + "scoretable" + " ORDER BY " + "Score" + " DESC LIMIT 1";

                topscore.setTypeface(custom_font);

                Cursor cursor = db.rawQuery(query, null);


                while (cursor.moveToNext()) {

                    scores = cursor.getInt(cursor.getColumnIndex("Score"));




                    TextView date1 = new TextView(Star_Activity.this);
                    date1.setText(""+scores);
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
                        dialog.show();


                    }
                });

                highscoredialog.show();
                dialog.dismiss();


            }
        });

        dialog.show();

    }


    @Override
    public void onBackPressed() {
        mRootLayout.removeAllViews();
        mRootLayout.addView(pausebutton);

        task1.cancel();
        task2.cancel();
        Onpausing();
//        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        task1.cancel();
        task2.cancel();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        task1.cancel();
        task2.cancel();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Musiccontinue) {
            Musiccontinue=false;
            startService(new Intent(this, BackgroundSoundService.class));
            mRootLayout.removeAllViews();
            mRootLayout.addView(pausebutton);

            task1.cancel();
            task2.cancel();
            Onpausing();
        }

    }

    @Override
    protected void onStop() {

        super.onStop();
        mHandler.removeCallbacksAndMessages(null);
        task1.cancel();
        task2.cancel();
        if(!Musiccontinue) {
            Musiccontinue=true;

            stopService(new Intent(this, BackgroundSoundService.class));
        }

    }

    private class ExeTimerTask extends TimerTask {
        @Override
        public void run() {
            // we don't really use the message 'what' but we have to specify something.


            mHandler.sendEmptyMessage(Constants.EMPTY_MESSAGE_WHAT);

        }
    }



    public void stopTask() {

        if (task1 != null && task2 != null) {

            task1.cancel();
            task2.cancel();
        }
    }

}