//package com.example.snyxius.mathballoon;
//
//import android.animation.TypeEvaluator;
//import android.animation.ValueAnimator;
//import android.app.Activity;
//import android.app.Dialog;
//import android.content.Intent;
//import android.graphics.Rect;
//import android.graphics.Typeface;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.media.AudioManager;
//import android.media.SoundPool;
//import android.os.Handler;
//import android.os.Message;
//import android.util.DisplayMetrics;
//import android.view.Display;
//import android.view.LayoutInflater;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.Window;
//import android.view.animation.AccelerateInterpolator;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.AnimationSet;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//import android.content.SharedPreferences;
//
///**
// * Created by snyxius on 11/12/15.
// */
//public class Sample1 extends Activity {
//    static int animDuration;
//    static int popupDuration;
//    private MediaPlayer mp;
//    int lifecounter=0;
//    static int i=0;
//    int n;
//     int score_value;
//        private int[] LEAVES = {
//                R.drawable.blankballon1,
//                R.drawable.blankballon2,
//                R.drawable.blankballon3,
//                R.drawable.blankballon4,
//                R.drawable.blankballon5,
//                R.drawable.blankballon6,
//                R.drawable.blankballon7,
//                R.drawable.blankballon8,
//                R.drawable.blankballon9,
//
//        };
//        ValueAnimator animator;
//        private Rect mDisplaySize = new Rect();
//        int mInt;
//        private RelativeLayout mRootLayout;
//        private ArrayList<View> mAllImageViews = new ArrayList<View>();
//        RelativeLayout relativeLayout;
//        private float mScale;
//        ImageView imageView,pausebutton;
//        ImageView resume,level,score,exit;
//        TextView gamescore,gamescorevalue;
//        ImageView replay,menu;
//        ImageView life1,life2,life3;
//        TextView animtext,scorevalue,scoretext;
//        Typeface custom_font;
//         RelativeLayout relativeLayout1;
//         MediaPlayer backgroundmusic;
//        MyTask task2;
//        ExeTimerTask task1;
//
//         private static int SPLASH_TIME_OUT = 100;
//
//    private SharedPreferences gamePrefs;
//    public static final String GAME_PREFS = "ArithmeticFile";
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        gamePrefs = getSharedPreferences(GAME_PREFS, 0);
////        int exScore = savedInstanceState.getInt("score");
////        scoreTxt.setText("Score: "+exScore);
//
//            animDuration=10000;
//            popupDuration=1500;
//
//            Display display = getWindowManager().getDefaultDisplay();
//            display.getRectSize(mDisplaySize);
//
//            DisplayMetrics metrics = new DisplayMetrics();
//            display.getMetrics(metrics);
//            mScale = metrics.density;
//
//
//            mRootLayout = (RelativeLayout) findViewById(R.id.main_layout);
//            life1=(ImageView)findViewById(R.id.life11);
//            life2=(ImageView)findViewById(R.id.life21);
//            life3=(ImageView)findViewById(R.id.life31);
//            scorevalue=(TextView)findViewById(R.id.score_value1);
//            scoretext=(TextView)findViewById(R.id.score1);
//            mRootLayout = (RelativeLayout) findViewById(R.id.main_layout);
//            pausebutton=(ImageView)findViewById(R.id.pause);
//
//            //use for sound effects game
//            setVolumeControlStream(AudioManager.STREAM_MUSIC);
////
//            backgroundmusic=MediaPlayer.create(Sample1.this,R.raw.mysteriouspuzzle);
//            backgroundmusic.setLooping(true);
//            backgroundmusic.start();
//
//
//            pausebutton.setEnabled(true);
//            Bundle b = getIntent().getExtras();
//            mInt= b.getInt("Integer");
//             custom_font = Typeface.createFromAsset(getAssets(),  "font/gretoon.ttf");
//             scoretext.setTypeface(custom_font);
//            scorevalue.setTypeface(custom_font);
//
//            pausebutton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mRootLayout.removeAllViews();
//                    mRootLayout.addView(pausebutton);
//                    task1.cancel();
//                    task2.cancel();
//                Onpausing();
//                }
//            });
//
//
//                task1=new ExeTimerTask();
//            new Timer().schedule(task1,900 , popupDuration);
//
//            task2=new MyTask();
//            new Timer().schedule(task2, 15000, 15000);
////
//        }
//
//    public void startAnimation(final RelativeLayout aniView) {
//
//        aniView.setPivotX(aniView.getWidth()/2);
//        aniView.setPivotY(aniView.getHeight()/2);
//
//        long delay = new Random().nextInt(Constants.MAX_DELAY);
//
//        final ValueAnimator animator = ValueAnimator.ofFloat(1, 0.0f);
////        animator.setDuration(Constants.ANIM_DURATION);
////        animator.setInterpolator(new AccelerateInterpolator());
////        animator.setInterpolator(new MyInterpolator());
//              animator.setStartDelay(delay);
////final int array[]={18000,60000,30000,20000,10000 };
//
////        if(i<duArray.length) {
////            i=0;
//            animator.setDuration(animDuration);
//
//
//
//
//
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            int movex = new Random().nextInt(mDisplaySize.right = 500);
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//
//                float value = ((Float) (animation.getAnimatedValue())).floatValue();
//
////                aniView.setRotation(angle*value);
//                aniView.setTranslationX((movex + getRandom(0, 1) * value));
//                aniView.setTranslationY((mDisplaySize.bottom + (90 * mScale)) * value);
//            }
//        });
//
//        animator.start();
//    }
//
//    public Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(final Message msg) {
//            super.handleMessage(msg);
//
//            int viewId = new Random().nextInt(LEAVES.length);
//            Drawable d = getResources().getDrawable(LEAVES[viewId]);
//            LayoutInflater inflate = LayoutInflater.from(Sample1.this);
//
//            View child = getLayoutInflater().inflate(R.layout.duplicate, null);
//            relativeLayout = (RelativeLayout)child.findViewById(R.id.balloon_container);
//            imageView=(ImageView)child.findViewById(R.id.aniImageView);
//            animtext=(TextView)child.findViewById(R.id.numbertext);
////            animtext.setTypeface(Typeface.createFromAsset(ath));
//            animtext.setTypeface(custom_font);
//
//            imageView.setImageDrawable(d);
//            animtext.setText(String.valueOf(getRandom(2, 100)));
//            relativeLayout.setTag(animtext.getText().toString());
//
//
//            relativeLayout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////
//
//                    int num = Integer.valueOf(v.getTag().toString());
//
//
//
//                    if (num % mInt == 0) {
////                        counter++;
////
//                        n+=10;
//                        scorevalue.setText(String.valueOf(n));
//                         relativeLayout1 = (RelativeLayout) v;
//                        final ImageView imageView1 = (ImageView) relativeLayout1.findViewById(R.id.aniImageView);
//                        imageView1.setImageResource(R.drawable.blast);
//                        TextView numbertext = (TextView) relativeLayout1.findViewById(R.id.numbertext);
////                        sound.play(blastsound,1.0f,1.0f,0,0,1.5f);
//                        mp = MediaPlayer.create(Sample1.this, R.raw.blast);
//                        mp.start();
//
//
//                        // giving fadeout animation
//                        Animation fadeOut = new AlphaAnimation(1, 0);
//                        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
//                        fadeOut.setDuration(250);
//
//                        new Handler().postDelayed(new Runnable() {
//
//            /*
//             * Showing splash screen with a timer. This will be useful when you
//             * want to show case your app logo / company
//             */
//
//                            @Override
//                            public void run() {
//                                // This method will be executed once the timer is over
//                                // Start your app main activity
//                                mRootLayout.removeView(relativeLayout1);
//                                relativeLayout1.setVisibility(View.GONE);
//
//                            }
//                        }, SPLASH_TIME_OUT);
//                        AnimationSet animation = new AnimationSet(false); //change to false
//                        animation.addAnimation(fadeOut);
//                        relativeLayout1.setAnimation(animation);
//                        animation.setAnimationListener(new Animation.AnimationListener() {
//                            @Override
//                            public void onAnimationStart(Animation animation) {
//
////                                relativeLayout1.setVisibility(View.GONE);
//
//                            }
//
//                            @Override
//                            public void onAnimationEnd(Animation animation) {
////                                relativeLayout1.setVisibility(View.GONE);
//
//
//
//
//                            }
//
//                            @Override
//                            public void onAnimationRepeat(Animation animation) {
//
//                            }
//                        });
//
//                    }
//                    else {
//                        relativeLayout1 = (RelativeLayout) v;
//
//                        final ImageView imageView1 = (ImageView) relativeLayout1.findViewById(R.id.aniImageView);
//                        imageView1.setImageResource(R.drawable.wrongblast);
//                        TextView numbertext = (TextView) relativeLayout1.findViewById(R.id.numbertext);
//
//
//                        // giving fadeout animation
//                        Animation fadeOut = new AlphaAnimation(1, 0);
//                        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
//                        fadeOut.setStartOffset(90);
//                        fadeOut.setDuration(250);
//                        new Handler().postDelayed(new Runnable() {
//
//            /*
//             * Showing splash screen with a timer. This will be useful when you
//             * want to show case your app logo / company
//             */
//
//                            @Override
//                            public void run() {
//                                // This method will be executed once the timer is over
//                                // Start your app main activity
//                                mRootLayout.removeView(relativeLayout1);
//                                relativeLayout1.setVisibility(View.GONE);
//
//                            }
//                        }, SPLASH_TIME_OUT);
//
//                        AnimationSet animation = new AnimationSet(false); //change to false
//                        animation.addAnimation(fadeOut);
//                        relativeLayout1.setAnimation(animation);
//                        animation.setAnimationListener(new Animation.AnimationListener() {
//                            @Override
//                            public void onAnimationStart(Animation animation) {
//
//                            }
//
//                            @Override
//                            public void onAnimationEnd(Animation animation) {
//                                relativeLayout1.setVisibility(View.GONE);
//
//
//                            }
//
//                            @Override
//                            public void onAnimationRepeat(Animation animation) {
//
//                            }
//                        });
//                        if(lifecounter==3) {
//                            mp = MediaPlayer.create(Sample1.this, R.raw.gameover);
//                            mp.start();
//                            final Dialog dialog = new Dialog(Sample1.this);
//                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//                            dialog.setContentView(R.layout.gameover);
//                            dialog.setCancelable(false);
//                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//                            gamescore=(TextView)dialog.findViewById(R.id.game_over_score);
//                            gamescorevalue=(TextView)dialog.findViewById(R.id.game_over_scorevalue);
//                            replay=(ImageView)dialog.findViewById(R.id.replay);
//                            menu=(ImageView)dialog.findViewById(R.id.menu);
//                            gamescorevalue.setTypeface(custom_font);
//                            gamescore.setTypeface(custom_font);
//
//                            final int starting=0;
//                             score_value=Integer.parseInt(scorevalue.getText().toString());
//System.out.println("screvalue"+score_value);
//                            ValueAnimator animator = new ValueAnimator();
//                            animator.setObjectValues(0, score_value);
//                            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                                public void onAnimationUpdate(ValueAnimator animation) {
//                                    gamescorevalue.setText(String.valueOf(animation.getAnimatedValue()));
//                                }
//                            });
//                            animator.setEvaluator(new TypeEvaluator<Integer>() {
//                                public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
//                                    return Math.round(startValue + (endValue - startValue) * fraction);
//                                }
//                            });
//                            animator.setDuration(1000);
//                            animator.start();
//
////                            gamescorevalue.setText(scorevalue.getText());
//                            replay.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    dialog.dismiss();
//                                    mRootLayout.removeAllViews();
//                                    mRootLayout.addView(pausebutton);
//                                    life1.setVisibility(View.VISIBLE);
//                                    life2.setVisibility(View.VISIBLE);
//
//                                    life3.setVisibility(View.VISIBLE);
//
//                                    scorevalue.setText(String.valueOf(0));
//                                    n=0;
//                                    task1 = new ExeTimerTask();
//                                    new Timer().schedule(task1, 900, popupDuration);
//                                    task2 = new MyTask();
//
//                                    new Timer().schedule(task2, 15000, 15000);
//
////                                    dialog.dismiss();
//
//                                }
//                            });
//                            menu.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    Intent intent = new Intent(getApplication(), Menupage.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//                            });
//                            dialog.show();
////mHandler.removeCallbacksAndMessages(null);
//task2.cancel();
//                            task1.cancel();
//                            lifecounter=0;
//                        }
//                        else {
//                            if(lifecounter==0)
//                            {
//                                mp = MediaPlayer.create(Sample1.this, R.raw.wrongblast);
//                                mp.start();
//                                life3.setVisibility(View.INVISIBLE);
//                                lifecounter++;
//                            }
//                            else if(lifecounter==1){
//                                mp = MediaPlayer.create(Sample1.this, R.raw.wrongblast);
//                                mp.start();
//                                life2.setVisibility(View.INVISIBLE);
//                                lifecounter++;
//
//                            }
//                            else if(lifecounter==2)
//                            {
//                                mp = MediaPlayer.create(Sample1.this, R.raw.wrongblast);
//                                mp.start();
//                                life1.setVisibility(View.INVISIBLE);
//                                lifecounter++;
//
//                            }
//
//                        }
//
//                    }
//
//
//                }
//            });
//
////            RelativeLayout relativeLayout=(RelativeLayout)inflate.inflate(R.layout.duplicate,null);
////            relativeLayout.setBackgroundResource();
////            relativeLayout.setBackgroundResource(d);
//            mRootLayout.addView(relativeLayout);
//
//
//            RelativeLayout.LayoutParams animationLayout = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
//            animationLayout.setMargins(0, (int)(-200*mScale), 0, 0);
////            animationLayout.width = (int) (150*mScale);
////            animationLayout.height = (int) (150*mScale);
////animationLayout.setd
//            startAnimation(relativeLayout);
//
//        }
//    };
//
//
//    public static int getRandom(int startvalue,int endvalue)
//    {
//
//        Random r=new Random();
//        int values=r.nextInt(endvalue-startvalue)+startvalue;
//        return values;
//    }
//    class MyTask extends TimerTask {
//        @Override
//        public void run() {
//
//            runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//
//                    if (animDuration>=500) {
//                        animDuration=animDuration-500;
//                    } else {
//                        animDuration=10000;
//                    }
////                    Toast.makeText(getApplication(), "speed=" + animDuration, Toast.LENGTH_LONG).show();
//
//                    if (popupDuration>50) {
//                        popupDuration=popupDuration-50;
//                    } else {
//                        popupDuration=1500;
//                    }
////                    Toast.makeText(getApplication(), "pop=" + popupDuration, Toast.LENGTH_LONG).show();
//                }
//            });
//        }
//
//    }
//private  void Onpausing(){
////        mRootLayout.removeView(relativeLayout);
//
//        final Dialog dialog = new Dialog(Sample1.this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//    dialog.setCancelable(false);
//
//        dialog.setContentView(R.layout.menudialog);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        resume = (ImageView) dialog.findViewById(R.id.resume);
////                level = (ImageView) dialog.findViewById(R.id.level);
//        score = (ImageView) dialog.findViewById(R.id.score);
//        exit = (ImageView) dialog.findViewById(R.id.exit);
////    close = (ImageView) dialog.findViewById(R.id.close);
//
//
//        resume.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                       animator.start();
//                task1 = new ExeTimerTask();
//                new Timer().schedule(task1, 900, popupDuration);
//                task2 = new MyTask();
//
//                new Timer().schedule(task2, 15000, 15000);
//                dialog.dismiss();
//            }
//        });
//    score.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
////            setHighScore();
//
////            Intent i = new Intent(getApplication(), HighScore.class);
////            startActivity(i);
////            finish();
//
//        }
//    });
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplication(), Menupage.class);
//                startActivity(i);
//                finish();
//
//            }
//        });
////                    level.setOnClickListener(new View.OnClickListener() {
////                        @Override
////                        public void onClick(View v) {
////                            final Dialog dialog = new Dialog(Sample1.this);
////                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
////
////                            dialog.setContentView(R.layout.levelactivity);
////                            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
////                            dialog.show();
////                        }
////                    });
//        dialog.show();
//
//
//}
//    @Override
//    public void onBackPressed() {
////        finish();
//        mRootLayout.removeAllViews();
//        mRootLayout.addView(pausebutton);
//
//        task1.cancel();
//        task2.cancel();
//        Onpausing();
////        super.onBackPressed();
//    }
//
//    @Override
//    protected void onDestroy() {
//        mHandler.removeCallbacksAndMessages(null);
//        task1.cancel();
//        task2.cancel();
////        setHighScore();
//        super.onDestroy();
//    }
//
////    @Override
////    protected void onStart() {
////
////        task1=new ExeTimerTask();
////        new Timer().schedule(task1,900 , popupDuration);
////        task2=new MyTask();
////
////        new Timer().schedule(task2, 15000, 15000);
////        super.onStart();
////    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        task1.cancel();
//        task2.cancel();
//        backgroundmusic.release();
//        finish();
//    }
//
//    @Override
//    protected void onStop() {
//        mHandler.removeCallbacksAndMessages(null);
//        task1.cancel();
//        task2.cancel();
//
//        super.onStop();
//    }
//
////   private void setHighScore(){
//////set high score
////       System.out.println("insidesethi");
////
////
////       int exScore = getScore();
////        if(exScore>0){
//////we have a valid score
////            SharedPreferences.Editor scoreEdit = gamePrefs.edit();
////            DateFormat dateForm = new SimpleDateFormat("dd MMMM yyyy");
////            String dateOutput = dateForm.format(new Date());
////            String scores = gamePrefs.getString("highScores", "");
////
////            if(scores.length()>0){
////                System.out.println("scores.length()>0");
////
////                List<Score> scoreStrings = new ArrayList<Score>();
////
////                //we have existing scores
////                String[] exScores = scores.split("\\|");
////                System.out.println("exScore"+exScores);
////
////                for(String eSc : exScores){
////                    String[] parts = eSc.split(" - ");
////                    scoreStrings.add(new Score(parts[0], Integer.parseInt(parts[1])));
////                    Score newScore = new Score(dateOutput, exScore);
////                    System.out.println("newScore"+newScore);
////
////                    scoreStrings.add(newScore);
////                    Collections.sort(scoreStrings);
////                    StringBuilder scoreBuild = new StringBuilder("");
////                    for(int s=0; s<scoreStrings.size(); s++){
////                        if(s>=10) break;//only want ten
////                        if(s>0) scoreBuild.append("|");//pipe separate the score strings
////                        scoreBuild.append(scoreStrings.get(s).getScoreText());
////                    }
//////write to prefs
////                    scoreEdit.putString("highScores", scoreBuild.toString());
////                    scoreEdit.commit();
////                }
////            }
////            else{
////                //no existing scores
////                System.out.println("else");
////
////                scoreEdit.putString("highScores", "" + dateOutput + " - " + exScore);
////                scoreEdit.commit();
////            }
////        }
////    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState) {
//
//        int exScore = getScore();
//        savedInstanceState.putInt("score", exScore);
//        super.onSaveInstanceState(savedInstanceState);
//    }
//    private int getScore(){
//        String scoreStr = scorevalue.getText().toString();
////                String scoreStr = Integer.parseInt(score_value.);
//
//        return Integer.parseInt(scoreStr.substring(scoreStr.lastIndexOf(" ")+1));
//    }
//    private class ExeTimerTask extends TimerTask {
//        @Override
//        public void run() {
//            // we don't really use the message 'what' but we have to specify something.
//
//
//            mHandler.sendEmptyMessage(Constants.EMPTY_MESSAGE_WHAT);
//
//        }
//    }
//}
//
