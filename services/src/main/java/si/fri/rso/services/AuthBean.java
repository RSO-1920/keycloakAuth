package si.fri.rso.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.json.JSONArray;
import si.fri.rso.entitete.LoginSession;
import si.fri.rso.lib.KeycloakUserDTO;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AuthBean {

    @Inject
    @DiscoverService(value = "rso1920-channels")
    private Optional<String> fileMetadataUrl;

    @Inject
    private StorageBean storageBean;

    @PersistenceContext(unitName = "authService-JPA")
    private EntityManager em;

    public boolean saveLoginSession(KeycloakUserDTO keycloakUserDTO) {
        String userID = keycloakUserDTO.getId();
        String authToken = keycloakUserDTO.getAuthToken();
        storageBean.SaveLogin(new LoginSession(userID, authToken));
        return true;
    }

    public boolean confirmUserCredentials(String authToken, String channelID) {
        String userID = storageBean.GetIdFromAuthToken(authToken);
        if(userID.length() == 0)
            return false;

        JSONArray userList = null;

        try{
            userList = getChannelUserList(channelID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson converter = new Gson();
        Type type = new TypeToken<List<String>>(){}.getType();
        List<String> list =  converter.fromJson(userList.toString(), type );

        System.out.println(list);

        if(list.contains(userID))
            return true;
        else
            return false;
    }

    private JSONArray getChannelUserList(String channelID) throws IOException {

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        System.out.println(fileMetadataUrl.get() + "/channels/v1/channels/channelUsers/" + channelID);
        Request request = new Request.Builder()
                .url(fileMetadataUrl.get() + "/v1/channels/channelUsers/" + channelID)
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        //System.out.println(response.body().string());
        System.out.println(response.body());
        JSONObject Jobject = new JSONObject(response.body().string());
        //System.out.println(response.body().string());
        //System.out.println(Jobject.get("data"));

        return (JSONArray)Jobject.get("data");
    }

}
