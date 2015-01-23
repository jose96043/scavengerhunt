package markovlabs.com.scavengerhunt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ApplicationContainer extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_container);

        Bundle bundle = new Bundle();
//        bundle.putString("QUESTION", testArray[0]);
        if (savedInstanceState == null) {
            PlaceholderFragment phf = new PlaceholderFragment();
//            phf.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, phf)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_application_container, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private String[] testArray = {"Jose", "kelly"};
        private int questionCounter;

        private String text;
        private TextView questionTextView;
        private Button checkoutButton;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
//            text = getArguments().getString("QUESTION");
            questionCounter = FragmentCounter.getInstance().getCounter();
            View rootView = inflater.inflate(R.layout.fragment_first_question, container, false);
            questionTextView = (TextView) rootView.findViewById(R.id.question);
            questionTextView.setText(testArray[questionCounter]);

            checkoutButton = (Button) rootView.findViewById(R.id.checkout);
            checkoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int newCounter = questionCounter +1;
                    FragmentCounter.getInstance().setCounter(newCounter);
                    Fragment newFragment = new PlaceholderFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, newFragment);
                    int x = R.id.container;
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
            return rootView;
        }

        @Override
        public void onStart() {
            super.onStart();

//            Bundle args = getArguments();
//            if (args != null) {
//                questionTextView.setText(args.getString("QUESTION"));
//            }
        }
    }
}
