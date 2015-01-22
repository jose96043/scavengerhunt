package markovlabs.com.scavengerhunt;

/**
 * Created by tecdvp3 on 1/21/15.
 */
public class Router {
    public Router() {
    }

    public void initialize(ApplicationManager sessionManager, AppStatusListener appStatusListener){
        if(sessionManager.applicationIsReady()){
            appStatusListener.applicationReady();
        }else{
            appStatusListener.applicationNotReady();
        }
    }
}
