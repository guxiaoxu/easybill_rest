package xgu.myproject.easybill.rest.bill.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xgu.myproject.easybill.rest.bill.model.Bill;

import java.util.List;

@Repository
public interface BillRepository extends CrudRepository<Bill, Long> {
    List<Bill> findAllByUserIdOrderByBillTime(long userId);
    void deleteByIdAndUserId(long id, long userId);
    Bill findByIdAndUserId(long id, long userId);
}
