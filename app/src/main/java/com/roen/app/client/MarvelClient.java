package com.roen.app.client;

import com.roen.app.model.MarvelCharacterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.ZonedDateTime;

@Service
public class MarvelClient {

    @Value("${app.roen.marvel.client.public.apikey}")
    private String publicApikey;

    @Value("${app.roen.marvel.client.private.apikey}")
    private String privateApikey;

    @Value("${app.roen.marvel.client.character.list.url}")
    private String characterListUrl;

    @Value("${app.roen.marvel.client.character.url}")
    private String characterUrl;

    private final RestClient restClient = RestClient.create();

    public ResponseEntity<MarvelCharacterResponse> getCharacterList(int offset, int limit) {

        long ts = ZonedDateTime.now().toInstant().getEpochSecond();

        String uri = UriComponentsBuilder.fromUriString(characterListUrl)
                .queryParam("offset", offset).queryParam("limit", limit)
                .queryParam("ts", ts)
                .queryParam("hash", getHash(ts, privateApikey, publicApikey))
                .queryParam("apikey", publicApikey).build().toString();


        ResponseEntity<MarvelCharacterResponse> response;

        try {
            response = restClient.get().uri(uri).retrieve().toEntity(MarvelCharacterResponse.class);
            return response;
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<MarvelCharacterResponse> getCharacterById(int characterId) {

        long ts = ZonedDateTime.now().toInstant().getEpochSecond();

        String uri = UriComponentsBuilder.fromUriString(characterUrl)
                .queryParam("ts", ts)
                .queryParam("hash", getHash(ts, privateApikey, publicApikey))
                .queryParam("apikey", publicApikey).buildAndExpand(characterId).toString();

        ResponseEntity<MarvelCharacterResponse> response;

        try {
            response = restClient.get().uri(uri).retrieve().toEntity(MarvelCharacterResponse.class);
            return response;
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    private String getHash(long ts, String privateApikey, String publicApikey) {

        String data = (ts + privateApikey + publicApikey);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
