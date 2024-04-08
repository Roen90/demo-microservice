package com.roen.app.service.impl;

import com.roen.app.client.MarvelClient;
import com.roen.app.model.MarvelCharacter;
import com.roen.app.model.MarvelCharacterResponse;
import com.roen.app.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private MarvelClient marvelClient;

    @Override
    public ResponseEntity<List<MarvelCharacter>> getCharacters(int offset, int limit) {
        List<MarvelCharacter> characterList = new ArrayList<>();
        ResponseEntity<MarvelCharacterResponse> response = marvelClient.getCharacterList(offset, limit);

        if (response.getBody() != null && response.getBody().getData() != null) {
            characterList.addAll(response.getBody().getData().getResults());
        }

        return new ResponseEntity<>(characterList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MarvelCharacter> getCharacterById(int characterId) {

        MarvelCharacter marvelCharacter = new MarvelCharacter("Not Found");

        ResponseEntity<MarvelCharacterResponse> response = marvelClient.getCharacterById(characterId);

        if (response.getBody() != null && response.getBody().getData() != null
                && response.getBody().getData().getResults() != null && !response.getBody().getData().getResults().isEmpty()) {
            marvelCharacter = response.getBody().getData().getResults().get(0);
        }

        return new ResponseEntity<>(marvelCharacter, HttpStatus.OK);
    }
}
