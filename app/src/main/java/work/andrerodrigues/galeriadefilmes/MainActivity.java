package work.andrerodrigues.galeriadefilmes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonObjectRequest jsObjRequest;
        jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Utils.URL_GENRES(null), null, new Response.Listener<JSONObject>() {
                    JSONArray jsonArray = new JSONArray();

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonArray = response.getJSONArray("genres");
                            for (int i=0; i<jsonArray.length(); i++) {
                                Utils.ARRAY_GENRES.add(jsonArray.getJSONObject(i).getJSONObject("Genre").getString("name"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);

        jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, Utils.URL_MOVIES("4"), null, new Response.Listener<JSONObject>() {
                    JSONArray jsonArray = new JSONArray();

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonArray = response.getJSONArray("movies");
                            for (int i=0; i<jsonArray.length(); i++) {
                                String filename = Utils.URL_BASE + Utils.DIR_IMAGE;
                                filename += jsonArray.getJSONObject(i).getJSONObject("Movie").getString("filename");
                                Utils.ARRAY_MOVIES.add(filename);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        // Access the RequestQueue through your singleton class.
        MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void showGallery(View view) {
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }
}
