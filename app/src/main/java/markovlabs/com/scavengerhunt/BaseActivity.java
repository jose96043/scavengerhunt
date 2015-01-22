package markovlabs.com.scavengerhunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by tecdvp3 on 1/21/15.
 */
public class BaseActivity extends Activity {
    private ApplicationManager applicationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationManager = new ApplicationManager(this);
    }

    public ApplicationManager getApplicationManager() {
        return applicationManager;
    }

    public void startActivity(Class<?> newActivity) {
        Intent i = new Intent(this, newActivity);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        this.startActivity(i);
    }
}
