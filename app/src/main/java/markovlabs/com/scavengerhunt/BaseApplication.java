package markovlabs.com.scavengerhunt;

import android.app.Application;

/**
 * Created by tecdvp3 on 1/23/15.
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        FragmentCounter.getInstance().setContext(getApplicationContext());
        FragmentCounter.getInstance().setSharedPreferences();
    }

}
