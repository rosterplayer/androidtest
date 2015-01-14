package su.pfm.netlibrary.api;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rumaster on 13.01.2015.
 */
public class Api {

    private RequestQueue mQueue;
    public static final String SERVER_URL = "www.pfm.su/androidtest/data.php?id=";
    private ArrayList<String> mNames;

    public Api(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public ArrayList<String> getData(String id) {
        JsonObjectRequest jsonObjRequest = new JsonObjectRequest(Request.Method.GET, SERVER_URL +  id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {

                try {
                    JSONArray data = json.getJSONArray("players");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject name = data.getJSONObject(i);
                        String n = name.getString("name");
                        mNames.add(n);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.getMessage());
            }
        });
        mQueue.add(jsonObjRequest);
        return mNames;
    }
}
