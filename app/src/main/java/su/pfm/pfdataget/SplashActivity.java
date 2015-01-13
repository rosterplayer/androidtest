package su.pfm.pfdataget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by rumaster on 13.01.2015.
 */
public class SplashActivity extends Activity {

    private EditText mEditText;
    private Button mButton;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        mEditText = (EditText) findViewById(R.id.idEdit);
        mButton = (Button) findViewById(R.id.getBtn);
        mListView = (ListView) findViewById(R.id.listPlayers);
    }

    public void searchData(View view) {

    }
}
