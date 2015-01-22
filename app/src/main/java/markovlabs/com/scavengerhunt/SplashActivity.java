package markovlabs.com.scavengerhunt;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SplashActivity extends BaseActivity {

    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        router = new Router();
        router.initialize(getApplicationManager(), new AppStatusListener() {
            @Override
            public void applicationNotReady() {
                startActivity(WelcomeActivity.class);
            }

            @Override
            public void applicationReady() {
                startActivity(ApplicationContainer.class);
            }
        });
    }
}
