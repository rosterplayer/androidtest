package su.pfm.netlibrary.api;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import volley.Request;
import volley.RequestQueue;
import volley.Response;
import volley.VolleyError;
import volley.toolbox.JsonObjectRequest;
import volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rumaster on 13.01.2015.
 */
public class Api {

    private RequestQueue mQueue;
    public static final String SERVER_URL = "http://www.pfm.su/androidtest/data.php?id=";

    private OnPlayerSearchListener mListener;

    public Api(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void getData(String id) {
        JsonObjectRequest jsonObjRequest = new JsonObjectRequest(Request.Method.GET, SERVER_URL +  id, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject json) {

                ArrayList<String> players = new ArrayList<>();

                try {
                    JSONArray data = json.getJSONArray("players");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject name = data.getJSONObject(i);
                        String n = name.getString("name");
                        players.add(n);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mListener.onPlayerSearch(players);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.getMessage());
            }
        });
        mQueue.add(jsonObjRequest);
    }

    public void setOnPlayerChangeListener(OnPlayerSearchListener listener) {

        mListener = listener;
    }
}
