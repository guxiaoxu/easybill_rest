package xgu.myproject.easybill.rest.bill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xgu.myproject.easybill.rest.bill.model.Bill;
import xgu.myproject.easybill.rest.bill.repository.BillRepository;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public long saveBill(Bill bill){
        return this.billRepository.save(bill).getId();
    }

    public List<Bill> listBill(long userId){
        return this.billRepository.findAllByUserIdOrderByBillTime(userId);
    }

    public Bill getBill(long userId, long billId) {
        return this.billRepository.findByIdAndUserId(billId, userId);
    }

    @Transactional
    public void deleteBill(long id, long userId){
        this.billRepository.deleteByIdAndUserId(id, userId);
    }

}
