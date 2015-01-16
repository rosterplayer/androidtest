package su.pfm.pfdataget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import su.pfm.netlibrary.api.Api;
import su.pfm.netlibrary.api.OnPlayerSearchListener;

/**
 * Created by rumaster on 13.01.2015.
 */
public class SplashActivity extends Activity implements OnPlayerSearchListener {

    private EditText mEditText;
    private ListView mListView;
    private Api mApi;
    private SearchPlayerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        mEditText = (EditText) findViewById(R.id.idEdit);
        mListView = (ListView) findViewById(R.id.listPlayers);

        mApi = new Api(getApplicationContext());
        mApi.setOnPlayerChangeListener(this);


    }

    public void searchData(View view) {

        mApi.getData(mEditText.getText().toString());
    }

    @Override
    public void onPlayerSearch(ArrayList<String> players) {

        mAdapter = new SearchPlayerAdapter(getApplicationContext(), players);
        mListView.setAdapter(mAdapter);
    }
}
