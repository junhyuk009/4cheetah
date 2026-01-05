package controller.action;

import javax.servlet.http.*;

import model.dto.PlaceDTO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import org.json.JSONObject;

import controller.common.Action;
import controller.common.ActionForward;

public class SearchAddressAction implements Action {
    private static final String KAKAO_API_KEY = "906d9909b639d7fb6fcbb9c3644f93bc";

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception  {
        String keyword = request.getParameter("keyword");

        // Kakao REST API 호출
        String apiUrl = "https://dapi.kakao.com/v2/local/search/address.json?query=" + keyword;
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", KAKAO_API_KEY);

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String result = br.readLine();

        JSONObject json = new JSONObject(result);
        JSONObject doc = json.getJSONArray("documents").getJSONObject(0);

        String address = doc.getString("address_name");
        double lat = doc.getDouble("y");
        double lng = doc.getDouble("x");

        request.setAttribute("address", address);
        request.setAttribute("lat", lat);
        request.setAttribute("lng", lng);

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("map.jsp");
        return forward;
    }
}
