package markovlabs.com.scavengerhunt;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by tecdvp3 on 1/21/15.
 */
public class ApplicationManager {
    private Context _context;
    private Editor editor;
    // Shared Preferences
    SharedPreferences pref;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    private static final String APPLICATION_READY = "ApplicationIsReady";
    private static final String PREF_NAME = "JosePortocarrero";

    // Constructor
    public ApplicationManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createApplicationSession(){
        // Storing login value as TRUE
        editor.putBoolean(APPLICATION_READY, true);

        // commit changes
        editor.commit();
    }

    public void checkApplicationStatus(){
        // Check login status
        if(!this.applicationIsReady()){
            // user is not logged in redirect him to Login Activity
            Intent i = new Intent(_context, ApplicationManager.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Staring Login Activity
            _context.startActivity(i);
        }

    }

    public boolean applicationIsReady(){
        return pref.getBoolean(APPLICATION_READY, false);
    }
}
