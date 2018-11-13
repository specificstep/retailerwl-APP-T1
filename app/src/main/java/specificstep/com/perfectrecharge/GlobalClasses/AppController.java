package specificstep.com.perfectrecharge.GlobalClasses;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import com.crashlytics.android.ndk.CrashlyticsNdk;
import io.fabric.sdk.android.Fabric;

/**
 * Created by admin1 on 21/3/16.
 */

public class AppController extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        /* report crash if any issues with app */
        // Fabric.with(this, new Crashlytics());
    }
}
