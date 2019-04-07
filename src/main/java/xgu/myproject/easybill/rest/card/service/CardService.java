package xgu.myproject.easybill.rest.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xgu.myproject.easybill.rest.card.model.Card;
import xgu.myproject.easybill.rest.card.repository.CardRepository;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public long addCard(Card card){
        return this.cardRepository.save(card).getId();
    }

    public List<Card> listCard(long userId){
        return this.cardRepository.findAllByUserId(userId);
    }

    public Card getCard(long userId, long cardId){
        return this.cardRepository.findByIdAndUserId(cardId, userId);
    }

    @Transactional
    public void deleteCard(long id, long userId){
        this.cardRepository.deleteByIdAndUserId(id, userId);
    }

}
