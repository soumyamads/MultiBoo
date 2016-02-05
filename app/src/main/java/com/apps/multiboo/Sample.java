//package com.example.snyxius.mathballoon;
//
//import android.animation.Animator;
//import android.animation.ObjectAnimator;
//import android.animation.ValueAnimator;
//import android.app.Activity;
//import android.app.Dialog;
//import android.app.FragmentManager;
//import android.content.Intent;
//import android.graphics.Rect;
//import android.graphics.drawable.ColorDrawable;
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.util.DisplayMetrics;
//import android.view.Display;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.Window;
//import android.view.animation.AccelerateInterpolator;
//import android.view.animation.AlphaAnimation;
//import android.view.animation.Animation;
//import android.view.animation.AnimationSet;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Timer;
//import java.util.TimerTask;
//
///**
// * Created by snyxius on 3/12/15.
// */
//public class Sample extends Activity {
//    int result;
//int counter=0;
//    private int[] LEAVES = {
//            R.drawable.blankballon1,
//            R.drawable.blankballon2,
//            R.drawable.blankballon3,
//            R.drawable.blankballon4,
//            R.drawable.blankballon5,
//            R.drawable.blankballon6,
//            R.drawable.blankballon7,
//            R.drawable.blankballon8,
//            R.drawable.blankballon9,
//
//    };
//    ValueAnimator animator;
//    private Rect mDisplaySize = new Rect();
//    int mInt;
//    private RelativeLayout mRootLayout;
//    private ArrayList<View> mAllImageViews = new ArrayList<View>();
//    RelativeLayout relativeLayout;
//    private float mScale;
//    ImageView imageView,pausebutton;
//    ImageView resume,level,score,exit;
//
//    TextView animtext;
//
//
//    private Handler handler = new Handler();
//    private Runnable runnable = new Runnable() {
//
//        public void run() {
//            int viewId = new Random().nextInt(LEAVES.length);
//            Drawable d = getResources().getDrawable(LEAVES[viewId]);
//            LayoutInflater inflate = LayoutInflater.from(Sample.this);
//
//            View child = getLayoutInflater().inflate(R.layout.duplicate, null);
//            relativeLayout = (RelativeLayout)child.findViewById(R.id.balloon_container);
//            imageView=(ImageView)child.findViewById(R.id.aniImageView);
//            animtext=(TextView)child.findViewById(R.id.numbertext);
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
//                    System.out.println("num" + num);
//                    if (num % mInt == 0) {
//                        counter++;
//                        RelativeLayout relativeLayout1 = (RelativeLayout) v;
//                        final ImageView imageView1 = (ImageView) relativeLayout1.findViewById(R.id.aniImageView);
//                        imageView1.setImageResource(R.drawable.blast);
//                        TextView numbertext = (TextView) relativeLayout1.findViewById(R.id.numbertext);
//                        numbertext.setVisibility(View.INVISIBLE);
//
//                        // giving fadeout animation
//                        Animation fadeOut = new AlphaAnimation(1, 0);
//                        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
//                        fadeOut.setStartOffset(500);
//                        fadeOut.setDuration(500);
//
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
//                                imageView1.setVisibility(View.INVISIBLE);
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
//                    } else {
//                        final Dialog dialog = new Dialog(Sample.this);
//                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//                        dialog.setContentView(R.layout.gameover);
//                        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//                        dialog.show();
//                        handler.removeCallbacks(runnable);
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
//            animationLayout.width = (int) (150*mScale);
//            animationLayout.height = (int) (150*mScale);
////animationLayout.setd
//            startAnimation(relativeLayout);
//
//        }
//    };
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//
//        Display display = getWindowManager().getDefaultDisplay();
//        display.getRectSize(mDisplaySize);
//
//        DisplayMetrics metrics = new DisplayMetrics();
//        display.getMetrics(metrics);
//        mScale = metrics.density;
//        mRootLayout = (RelativeLayout) findViewById(R.id.main_layout);
//        pausebutton=(ImageView)findViewById(R.id.pause);
//        pausebutton.setEnabled(true);
//        Bundle b = getIntent().getExtras();
//        mInt= b.getInt("Integer");
//        System.out.println("Value" + mInt);
//
//        new Timer().schedule(new ExeTimerTask(), 0, 5000);
//
//        handler.post(runnable);
//        pausebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                stopAnimation();
////                relativeLayout.clearAnimation();
////                final Dialog dialog = new Dialog(Sample.this);
////                                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
////
////                dialog.setContentView(R.layout.menudialog);
////                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
////                resume = (ImageView) dialog.findViewById(R.id.resume);
////                level = (ImageView) dialog.findViewById(R.id.level);
////                score = (ImageView) dialog.findViewById(R.id.score);
////                exit = (ImageView) dialog.findViewById(R.id.exit);
//
//
////                resume.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
//////                       animator.start();
////                        handler.postDelayed(runnable, 1000);
////                        dialog.dismiss();
////                    }
////                });
////                exit.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        Intent startMain = new Intent(Intent.ACTION_MAIN);
////                        startMain.addCategory(Intent.CATEGORY_HOME);
////                        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////
////                        startActivity(startMain);
////                    }
////                });
////                dialog.show();
//
//
//            }
//        });
////        new Timer().schedule(new ExeTimerTask(), 0, 1000);
//    }
//    private void stopAnimation(){
//        animator.addPauseListener(new Animator.AnimatorPauseListener() {
//            @Override
//            public void onAnimationPause(Animator animation) {
//                animation.pause();
//
//            }
//
//            @Override
//            public void onAnimationResume(Animator animation) {
////        relativeLayout.setVisibility(View.VISIBLE);
//                animation.resume();
//
//            }
//        });
//        animator.start();
//    }
//
//    public void startAnimation(final RelativeLayout aniView) {
//
//        aniView.setPivotX(aniView.getWidth() / 2);
//        aniView.setPivotY(aniView.getHeight() / 2);
//
//        // long delay = new Random().nextInt(Constants.MAX_DELAY);
//
//        //speed for ballon increasing here
//        animator = ValueAnimator.ofFloat(1.1f, 0.0f);
//        animator.setDuration(Constants.ANIM_DURATION);
////        animator.setInterpolator(new AccelerateInterpolator());
//        if(counter<=3)
//        {
//            animator.setDuration(11000);
//            handler.postDelayed(runnable, 5000);
//
//        }
//        else if(counter<=6)
//        {
//            animator.setDuration(10000);
//            handler.postDelayed(runnable, 4500);
//        }
//        else if(counter<=9)
//        {
//            animator.setDuration(9500);
//            handler.postDelayed(runnable,4000 );
//        }
//
//        else if(counter<=12)
//        {
//            animator.setDuration(8000);
//            handler.postDelayed(runnable, 2000);
//        }
//        else if(counter<=15)
//        {
//            animator.setDuration(7000);
//            handler.postDelayed(runnable, 1000);
//        }
//        else if(counter<=18)
//        {
//            animator.setDuration(6000);
//            handler.postDelayed(runnable, 900);
//        }
//        else if(counter<=21)
//        {
//            animator.setDuration(4000);
//            handler.postDelayed(runnable, 850);
//
//        }
//        else if(counter<=25)
//        {
//            animator.setDuration(2000);
//            handler.postDelayed(runnable, 800);
//
//        }
//        else if(counter<=90)
//        {
//            animator.setDuration(1000);
//            handler.postDelayed(runnable, 750);
//
//        }
//        else if(counter<=101)
//        {
//            animator.setDuration(1000);
//            handler.postDelayed(runnable, 700);
//
//        }
//        animator.setStartDelay(0);
//
//        final int movex = new Random().nextInt(mDisplaySize.right);
////
//
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
////            int angle = 90 + (int)(Math.random() * 101);
//
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                float value = ((Float) (animation.getAnimatedValue())).floatValue();
//
//                aniView.setTranslationX((movex+getRandom(0,1)*value));
//                aniView.setTranslationY((mDisplaySize.bottom + (150*mScale))*value);
//            }
//        });
//
//        animator.start();
//    }
//
//
//
//    public static int getRandom(int startvalue,int endvalue)
//    {
//
//        Random r=new Random();
//        int values=r.nextInt(endvalue-startvalue)+startvalue;
//        return values;
//    }
//
//
//
//    @Override
//    protected void onDestroy() {
//        handler.removeCallbacks(runnable);
//        super.onDestroy();
//    }
//    private class ExeTimerTask extends TimerTask {
//        @Override
//        public void run() {
//            // we don't really use the message 'what' but we have to specify something.
//            handler.sendEmptyMessage(Constants.EMPTY_MESSAGE_WHAT);
//        }
//    }
//}