package xyz.tunlinaung.movielist.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.greenrobot.eventbus.EventBus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import xyz.tunlinaung.movielist.events.LoadedMoviesEvent;
import xyz.tunlinaung.movielist.network.responses.GetMoviesResponse;

/**
 * Created by eidoshack on 1/2/18.
 */

public class HttpUrlConnectionDataAgent implements MoviesDataAgent {

    public static final String TAG = "NetworkAgent";

    private static HttpUrlConnectionDataAgent mObject;

    public HttpUrlConnectionDataAgent() {
    }

    public static HttpUrlConnectionDataAgent getInstance() {
        if (mObject == null) {
            mObject = new HttpUrlConnectionDataAgent();
        }

        return mObject;
    }

    @Override
    public void loadMovies() {
        Log.d(TAG, "loadMovies in main() thread.");

        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                Log.d(TAG, "loadMovies in background() thread");

                URL url;
                BufferedReader reader = null;
                StringBuilder builder;

                try {
                    url = new URL("http://padcmyanmar.com/padc-3/popular-movies/apis/v1/getPopularMovies.php");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    connection.setRequestMethod("POST");

                    connection.setReadTimeout(15 * 1000);

                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    List<NameValuePair> params = new ArrayList<>();
                    params.add(new BasicNameValuePair("access_token", "b002c7e1a528b7cb460933fc2875e916"));
                    params.add(new BasicNameValuePair("page", "1"));

                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    connection.connect();

                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    builder = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                        builder.append(line + "\n");

                    String responseString = builder.toString();
                    Log.d(TAG, "doInBackground: responseString -> " + responseString);

                    Gson gson = new Gson();
                    GetMoviesResponse response = gson.fromJson(responseString, GetMoviesResponse.class);
                    Log.d(TAG, "doInBackground: size -> " + response.getPopularMovies().size());

                    EventBus.getDefault().post(new LoadedMoviesEvent(response.getPopularMovies()));

                } catch (Exception e) {
                    Log.d(TAG, "error -> " + e.getMessage());
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                return null;
            }
        }.execute();
    }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }
}
