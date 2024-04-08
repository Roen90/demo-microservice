package com.roen.app.controller;

import com.roen.app.model.MarvelCharacter;
import com.roen.app.model.MarvelCharacterResponse;
import com.roen.app.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/marvel")
public class MarvelCharactersController {

    @Autowired
    private CharacterService characterService;

    @GetMapping(value = "/characters")
    public ResponseEntity<List<MarvelCharacter>> getCharacters(@RequestParam int offset, @RequestParam int limit) {
        return characterService.getCharacters(offset, limit);
    }

    @GetMapping(path = "/character/{characterId}")
    public ResponseEntity<MarvelCharacter> getCharacterById(@PathVariable int characterId) {
        return characterService.getCharacterById(characterId);
    }

}
