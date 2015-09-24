package work.andrerodrigues.galeriadefilmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by USER01 on 24/09/2015.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private final ArrayList<String> web;

    public MyAdapter(Context c, ArrayList<String> web) {
        context = c;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewVolley;
        TextView textView;
        ImageLoader mImageLoader;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            viewVolley = new View(context);
            viewVolley = inflater.inflate(R.layout.grid_item, null);
        } else {
            viewVolley = (View) convertView;
        }
        textView = (TextView) viewVolley.findViewById(R.id.textView);
        textView.setText(Utils.ARRAY_MOVIES.get(position));
        return viewVolley;
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View viewVolley;
        NetworkImageView mNetworkImageView;
        ImageLoader mImageLoader;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            viewVolley = new View(context);
            viewVolley = inflater.inflate(R.layout.grid_item, null);
        } else {
            viewVolley = (View) convertView;
        }
        mNetworkImageView = (NetworkImageView) viewVolley.findViewById(R.id.networkImageView);
        mImageLoader = MySingleton.getInstance(context).getImageLoader();
        mNetworkImageView.setImageUrl(web.get(position), mImageLoader);
        return viewVolley;
    }
}
