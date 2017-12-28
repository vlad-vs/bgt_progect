package com.bgt.services.impl;

import com.bgt.dao.CashFlowDao;
import com.bgt.dao.ProfitAndLossDao;
import com.bgt.entityes.guides.CashFlow;
import com.bgt.entityes.guides.ProfitAndLoss;
import com.bgt.services.CashFlowServiceInterface;
import com.bgt.services.ProfitAndLossServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfitAndLossService implements ProfitAndLossServiceInterface {

    @Autowired
    ProfitAndLossDao dao;

    @Override
    public void addItem(ProfitAndLoss item, ProfitAndLoss pItem) {
        if (!dao.findUnit(item)) {
            if (pItem == null) {
                item.setFasadKodItem("PL." + item.getKodItem() + ".");
            } else {
                item.setFasadKodItem(pItem.getFasadKodItem() + item.getKodItem() + ".");
            }
        }
        dao.addItem(item);
    }

    @Override
    public void updateItem(int id,  String fKod, String name, String type, boolean level) {
        dao.updateItemById(id, fKod, name, type, level);
    }

    @Override
    public List<ProfitAndLoss> getAllItems() {
        return dao.getAllItems();
    }

    @Override
    public ProfitAndLoss getItemByName(String name) {
        return dao.getItemByName(name);
    }

    @Override
    public void deleteItemById(int id) {
        dao.deleteItemById(id);
    }

}
