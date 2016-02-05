package com.apps.multiboo;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.apps.multiboo.util.IabHelper;
import com.apps.multiboo.util.IabResult;
import com.apps.multiboo.util.Inventory;
import com.apps.multiboo.util.Purchase;
import com.apps.multiboo.util.Security;

import java.security.PublicKey;
import java.util.Random;

/**
 * Created by Snyxius on 11/16/2015.
 */
public class SelectnumberActivity extends AppCompatActivity {


    private static final String TAG =
            "com.apps.multiboo";

    static final String ITEM_SKU = " unlock.level.789";//"android.test.purchased"; //"level789";

    IabHelper mHelper;

    ImageView one,two,three,four,five,six,seven,eight,nine,sevenlock,eightlock,ninelock;
    ImageView close;
    Animation shake;
    TextView picknumber;
    RelativeLayout relative1,relative2,relative3,relative4,relative5,relative9,relative7,relative8;
    MediaPlayer backgroundmusic;
    Typeface custom_font;
//    LinearLayout how;
    TextView howtext,upgradetext,upgradheadg,rs;
    Button buynow;
    //    static boolean mutes=false;
//    SharedPreferences prefs;
    Intent svc;
    Boolean Musiccontinue=false;
    Boolean mutes;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectnumbers);
        shake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);
        shake.setDuration(1000);
        initializeBilling();

//        SharedPreferences app_preferences = PreferenceManager
//                .getDefaultSharedPreferences(SelectnumberActivity.this);
//
//        editor = app_preferences.edit();
//        mutes = app_preferences.getBoolean("mute", false);
        picknumber=(TextView)findViewById(R.id.picknumber);
//        one = (ImageView) findViewById(R.id.balloon11);
        two = (ImageView) findViewById(R.id.balloon12);
        three = (ImageView) findViewById(R.id.balloon13);
        four = (ImageView) findViewById(R.id.balloon21);
        five = (ImageView) findViewById(R.id.balloon22);
        six = (ImageView) findViewById(R.id.balloon23);
        sevenlock = (ImageView) findViewById(R.id.balloon31);
        eightlock = (ImageView) findViewById(R.id.balloon32);
        ninelock = (ImageView) findViewById(R.id.balloon33);
        seven = (ImageView) findViewById(R.id.balloon311);
        eight = (ImageView) findViewById(R.id.balloon322);
        nine = (ImageView) findViewById(R.id.balloon333);

        custom_font = Typeface.createFromAsset(getAssets(),  "font/gretoon.ttf");
        picknumber.setTypeface(custom_font);
//        howtext.setTypeface(custom_font);

//        how.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i=new Intent(SelectnumberActivity.this,Screenshotone.class);
//                startActivity(i);
//
//            }
//        });

        relative1=(RelativeLayout)findViewById(R.id.relative11);
        relative2=(RelativeLayout)findViewById(R.id.relative12);
        relative3=(RelativeLayout)findViewById(R.id.relative13);
        relative4=(RelativeLayout)findViewById(R.id.relative21);
        relative5=(RelativeLayout)findViewById(R.id.relative22);
//        relative6=(RelativeLayout)findViewById(R.id.relative23);
        relative7=(RelativeLayout)findViewById(R.id.relative31);
        relative8=(RelativeLayout)findViewById(R.id.relative32);
        relative9=(RelativeLayout)findViewById(R.id.relative33);


        relative1.startAnimation(shake);
        relative2.startAnimation(shake);
        relative3.startAnimation(shake);
        relative4.startAnimation(shake);
        relative5.startAnimation(shake);
//        relative6.startAnimation(shake);
        relative7.startAnimation(shake);
        relative8.startAnimation(shake);
        relative9.startAnimation(shake);

//        one.setR

//        findViewById(R.id.imageButton1).startAnimation(shake);

//        one.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRandomNumber(1,100);
//
//                setValue(1);
//
//
//            }
//        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomNumber(2,100);

                setValue(2);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomNumber(3,100);

                setValue(3);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomNumber(4,100);
                setValue(4);


            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRandomNumber(5,100);
                setValue(5);
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRandomNumber(6, 100);
                setValue(6);
            }
        });
        sevenlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnUpgrade();

            }
        });
        eightlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnUpgrade();

            }
        });
        ninelock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnUpgrade();

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRandomNumber(7,100);
                setValue(7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRandomNumber(8,100);

                setValue(8);
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setRandomNumber(9,100);
                setValue(9);
            }
        });
    }
    public  void setValue(int Intvalue)
    {
//        int IntValue=9;
        Intent intent = new Intent(SelectnumberActivity.this,Sample2.class);
        Bundle b=new Bundle();
        b.putInt("Integer", Intvalue);
        intent.putExtras(b);
        startActivity(intent);
        Musiccontinue=true;
        finish();
    }
    public static int setRandomNumber(int startvalue,int endvalue)
    {

        Random r=new Random();
        int values=r.nextInt(endvalue-startvalue)+startvalue;
        System.out.println("NO"+values);
        return values;
    }
    @Override
    protected void onPause() {
        super.onPause();
//        backgroundmusic.release();
//        stopService(svc);
//        stopService(new Intent(this, BackgroundSoundService.class));

//        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(!Musiccontinue) {
            Musiccontinue=true;

            stopService(new Intent(this, BackgroundSoundService.class));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Musiccontinue) {
            Musiccontinue=false;
            startService(new Intent(this, BackgroundSoundService.class));
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent=new Intent(getApplicationContext(),Menupage.class);
        startActivity(intent);
        Musiccontinue=true;

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        stopService(new Intent(this, BackgroundSoundService.class));


    }

    private void OnUpgrade(){
        final Dialog dialog = new Dialog(SelectnumberActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.upgrade_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        upgradetext=(TextView)dialog.findViewById(R.id.upgradetxt);
//        upgradheadg=(TextView)dialog.findViewById(R.id.upgrdhead);
        rs=(TextView)dialog.findViewById(R.id.Rs49);

//        upgradheadg.setTypeface(custom_font);
        upgradetext.setTypeface(custom_font);
        rs.setTypeface(custom_font);
        buynow=(Button)dialog.findViewById(R.id.buynw);
        buynow.setTypeface(custom_font);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                mHelper.launchPurchaseFlow(SelectnumberActivity.this, ITEM_SKU, 10001,
                        mPurchaseFinishedListener, "mypurchasetoken");
            }
        });

        close = (ImageView) dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });


        dialog.show();

    }

    private void initializeBilling(){
        String base64EncodedPublicKey =
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyynEURED7D2XZ/xEuX62vWGXFZlv7DpjmKclMOGUK/cQXwX62i8g/Xi5B5Kyuv6naCdKbxj/N901TFUZ1C+RQTM+KvCJYnISy+EJN561n5/mVZOBCRRf0vjU2R2NA9Xo8eMXKT1WCQZPGoyLcKMf9Ju71iwzj3YzwW4u39u7L5whW8jngzOBgTdz5TDFvptTuoYZoJZ9dOSldSdK0r2Z26eeVgZnpQgQu6QzUZDl27dkoZo4qD18s3/XQ/EUrHTImA02/QVILkoRktQy7p1Re8rftRHb4SBdQCEh4mUfHvf+IeT3tpdRmagJ/NhNNvOHoSkhHJjcKqLI0/vlGXLEgQIDAQAB";


        mHelper = new IabHelper(this, base64EncodedPublicKey);

        mHelper.startSetup(new
                                   IabHelper.OnIabSetupFinishedListener() {
                                       public void onIabSetupFinished(IabResult result) {
                                           if (!result.isSuccess()) {
                                               Log.d(TAG, "failed" + result);
                                           } else {
                                               Log.d(TAG, "set up OK");
                                           }
                                       }
                                   });
    }


    public void consumeItem() {
        mHelper.queryInventoryAsync(mReceivedInventoryListener);
    }

IabHelper.QueryInventoryFinishedListener mReceivedInventoryListener
        = new IabHelper.QueryInventoryFinishedListener() {
    public void onQueryInventoryFinished(IabResult result,
                                         Inventory inventory) {

        if (result.isFailure()) {
            // Handle failure
        } else {
            mHelper.consumeAsync(inventory.getPurchase(ITEM_SKU),
                    mConsumeFinishedListener);
        }
    }
};

IabHelper.OnConsumeFinishedListener mConsumeFinishedListener =
        new IabHelper.OnConsumeFinishedListener() {
            public void onConsumeFinished(Purchase purchase,
                                          IabResult result) {

                if (result.isSuccess()) {
                    //clickButton.setEnabled(true);
                    sevenlock.setVisibility(View.INVISIBLE);
                    eightlock.setVisibility(View.INVISIBLE);
                    ninelock.setVisibility(View.INVISIBLE);

                    seven.setVisibility(View.VISIBLE);
                    eight.setVisibility(View.VISIBLE);

                    nine.setVisibility(View.VISIBLE);



                } else {
                    // handle error
                }
            }
        };




    public static boolean verifyPurchase(String base64PublicKey,
                                         String signedData, String signature) {
        if (TextUtils.isEmpty(signedData) ||
                TextUtils.isEmpty(base64PublicKey) ||
                TextUtils.isEmpty(signature)) {
            Log.e(TAG, "Purchase verification failed: missing data.");
            if (BuildConfig.DEBUG) {
                return true;
            }
            return false;
        }

        PublicKey key = Security.generatePublicKey(base64PublicKey);
        return Security.verify(key, signedData, signature);
    }


IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener
        = new IabHelper.OnIabPurchaseFinishedListener() {
    public void onIabPurchaseFinished(IabResult result,
                                      Purchase purchase)
    {
        if (result.isFailure()) {
            // Handle error
            return;
        }
        else if (purchase.getSku().equals(ITEM_SKU)) {
            consumeItem();
            //  buyButton.setEnabled(false);
        }

    }
};




    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data)
    {
        if (!mHelper.handleActivityResult(requestCode,
                resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}