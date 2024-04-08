package com.roen.app.service;

import com.roen.app.model.MarvelCharacter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CharacterService {

    ResponseEntity<List<MarvelCharacter>> getCharacters(int offset, int limit);

    ResponseEntity<MarvelCharacter> getCharacterById(int characterId);

}
