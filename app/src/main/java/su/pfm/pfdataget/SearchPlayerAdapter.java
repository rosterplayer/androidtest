package su.pfm.pfdataget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rumaster on 15.01.2015.
 */
public class SearchPlayerAdapter extends BaseAdapter {

    private ArrayList<String> mPlayers;
    private LayoutInflater mInflater;

    public SearchPlayerAdapter(Context context, ArrayList<String> players) {

        mPlayers = players;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mPlayers.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlayers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            view = mInflater.inflate(R.layout.list_items, parent, false);
        }
        TextView nameText = (TextView) view.findViewById(R.id.nameText);
        nameText.setText(mPlayers.get(position));
        return view;
    }
}
