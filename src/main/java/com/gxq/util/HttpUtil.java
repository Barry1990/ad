package com.gxq.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by xuenianxiang on 2017/4/20.
 */
public class HttpUtil {
    public static String sendGet(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("GET"); // Default is GET
            // Request header
            // con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String sendPost(String url, String body) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("POST"); // Default is GET
            // Request header
            // con.setRequestProperty("User-Agent", USER_AGENT);
            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeBytes(body);
            dos.flush();
            dos.close();

            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
