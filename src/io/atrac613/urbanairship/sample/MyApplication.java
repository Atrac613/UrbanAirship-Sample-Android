package io.atrac613.urbanairship.sample;

import android.app.Application;
import android.util.Log;

import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
 
public class MyApplication extends Application {
 
    @Override
    public void onCreate(){
    	AirshipConfigOptions options = AirshipConfigOptions.loadDefaultOptions(this);

        UAirship.takeOff(this, options);
        Logger.logLevel = Log.VERBOSE;

        PushManager.shared().setIntentReceiver(IntentReceiver.class);
        
        String apid = PushManager.shared().getAPID();
        Logger.info("My Application onCreate - App APID: " + apid);
    }
}
