package xgu.myproject.easybill.rest.card.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xgu.myproject.easybill.rest.card.model.Card;

import java.util.List;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    List<Card> findAllByUserId(long userId);
    void deleteByIdAndUserId(long id, long userId);
    Card findByIdAndUserId(long id, long userId);
}
