package bustime;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * A BusTime object is your developer authentication with the MTA BusTime API.
 * This class shouldn't be directly instantiated. You must create either a BusTimeStopMonitoring or BusTimeVehicleMonitoring object.
 * If you would like to create both conveniently without supplying your developer key twice, you can use the BusTimeBuilder class.
 * @author kevin
 * @date 8/8/14
 */
class BusTime {

    // Your developer key. Get a developer key here: http://bit.ly/1oqwa54
    private String key;
    
    /**
     * Initialize a new BusTime developer token
     * @param key Your developer key. Get a developer key here: http://bit.ly/1oqwa54
     */
    protected BusTime(String key) throws IOException {
        this.key = key;
    }


    /**
     * Given a URL object, returns a JSON representation of the response given when querying that URL
     * @param url URL to query for a JSON response
     * @return JSON object representing that URL query
     * @throws IOException If the HTTP call cannot be completed
     */
    protected static JsonElement getJsonFromUrl(URL url) throws IOException {
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        return jp.parse(new InputStreamReader((InputStream)request.getContent()));
    }

}