package com.apps.multiboo.app;

import android.app.Application;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;


import com.apps.multiboo.R;

import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by snyxius on 8/12/15.
 */


@ReportsCrashes(formKey = "", // will not be used
        mailTo = "soumyamekm@gmail.com",
        customReportContent = { ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT },
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text)


public class MultiBooApp extends Application{


        public static String sharedPreferencesName = "MultiBooApp";
        public static MultiBooApp mInstance;
        private static Context context;
        public static Toast toast;

        @Override
        public void onCreate() {
                super.onCreate();
                context = this;
                mInstance = this;
//                ACRA.init(this);

        }
        public static MultiBooApp getInstance() {
                return mInstance;
        }


        public static Context getAppContext() {
                return mInstance.getApplicationContext();
        }

        public static void showAToast(String st) {
                try {
                        toast.getView().isShown();
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.setText(st);
                        //toast = Toast.makeText(context, st, Toast.LENGTH_SHORT);
                } catch (Exception e) { // invisible if exception
                        toast = Toast.makeText(context, st, Toast.LENGTH_SHORT);
                }
                toast.show();
        }

}
