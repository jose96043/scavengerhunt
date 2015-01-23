package markovlabs.com.scavengerhunt;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tecdvp3 on 1/23/15.
 */
public class FragmentCounter {
    private static FragmentCounter instance;
    private int counter = 0;
    private Context mContext;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private final String PREF_NAME = "FragmentCounter";
    private final String FRAGMENT_NUMBER = "FragmentNumber";

    private FragmentCounter() {
    }

    public static FragmentCounter getInstance() {
        if (instance == null) {
            synchronized (FragmentCounter.class) {
                if (instance == null) {
                    instance = new FragmentCounter();
                }
            }
        }
        return instance;
    }

    public void setCounter(int counter){
        editor.putInt(FRAGMENT_NUMBER, counter);
        editor.commit();
        this.counter = counter;
    }

    public int getCounter(){
        counter = pref.getInt(FRAGMENT_NUMBER, counter);
        return counter;
    }

    public void setContext(Context context){
        this.mContext = context;
    }

    public Context getContext(){
        return mContext;
    }

    public void setSharedPreferences(){
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

}
