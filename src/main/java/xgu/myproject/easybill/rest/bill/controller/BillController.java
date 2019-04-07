package xgu.myproject.easybill.rest.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xgu.myproject.easybill.rest.bill.service.BillService;
import xgu.myproject.easybill.rest.bill.model.Bill;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping()
    public Map addBill(@SessionAttribute("userId") long userId, @RequestBody Bill bill){
        bill.setUserId(userId);
        return Collections.singletonMap("id", billService.saveBill(bill));
    }

    @GetMapping()
    public List<Bill> listBill(@SessionAttribute("userId") long userId){
        return this.billService.listBill(userId);
    }

    @GetMapping(value = "{billId}")
    public Bill getBill(@SessionAttribute("userId") long userId, @PathVariable("billId") long billId){
        return this.billService.getBill(userId, billId);
    }

    @PutMapping(value = "{billId}")
    public void updateBill(@SessionAttribute("userId") long userId, @PathVariable("billId") long billId, @RequestBody Bill bill){
        bill.setUserId(userId);
        bill.setId(billId);
        this.billService.saveBill(bill);
    }

    @DeleteMapping(value = "{billId}")
    public void updateBill(@SessionAttribute("userId") long userId, @PathVariable("billId") long billId){
        this.billService.deleteBill(billId, userId);
    }

}
