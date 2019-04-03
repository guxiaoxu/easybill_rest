package xgu.myproject.easybill.rest.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xgu.myproject.easybill.rest.card.model.Card;
import xgu.myproject.easybill.rest.card.service.CardService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping()
    public Map addCard(@SessionAttribute("userId") long userId, @RequestBody Card card){
        card.setUserId(userId);
        return Collections.singletonMap("id", cardService.addCard(card));
    }

    @GetMapping()
    public List<Card> listCard(@SessionAttribute("userId") long userId){
        return this.cardService.listCard(userId);
    }

    @DeleteMapping(value = "{cardId}")
    public void updateCard(@SessionAttribute("userId") long userId, @PathVariable("cardId") long cardId){
        this.cardService.deleteCard(cardId, userId);
    }

}
