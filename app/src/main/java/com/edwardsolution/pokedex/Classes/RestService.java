package com.edwardsolution.pokedex.Classes;
import android.content.Context;
import android.util.Log;

import com.edwardsolution.pokedex.Classes.Models.RegionDetail;
import com.edwardsolution.pokedex.Utils.Constants;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestService {

    public static RegionDetail consultarPokemonsRegion(Context c,long idRegion) {
        HttpHeaders reqHeaders = new HttpHeaders();
        reqHeaders.setAccept(Collections.singletonList(new MediaType("application", "json")));
        //String token=SessionConfig.getSessionConfig(c).getValue(SessionConfig.userToken);
        //String tokenDesencriptado=SessionConfig.getSessionConfig(c).DesencriptarToken(token);
        reqHeaders.set("Authorization", "");//tokenDesencriptado
        HttpEntity<?> requestEntity = new HttpEntity<Object>(reqHeaders);
        //Emisora[] emisoras = null;

        RestTemplate restTemplate = new RestTemplate();

        String url = Constants.serverDomain + String.format(Constants.uriPokeRegion,idRegion);
        try {
            ResponseEntity<RegionDetail> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, RegionDetail.class);
            System.out.println(responseEntity.getStatusCode());
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return responseEntity.getBody();
            }
        } catch (Exception e) {
            Log.e("RestGetError", e.getMessage());
            return null;
        }
        return null;
    }
}
