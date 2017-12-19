package com.bgt.services;

import com.bgt.dao.*;
import com.bgt.dao.guidesDao.CurrencyDao;
import com.bgt.dao.guidesDao.YearDao;
import com.bgt.entityes.guides.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuidesService {



	@Autowired
	ProfitAndLossDao plDao;



	@Autowired
	CurrencyDao currencyDao;

	@Autowired
	YearDao yearDao;

	@Autowired
	BgtDao bgtDao;



	public void addPlItem(ProfitAndLoss item){
		plDao.insertProfitAndLossItem(item);
	}

	public void delPlItem(int id){
		plDao.deleteProfitAndLossItemById(id);
	}

	public void updatePlItem(ProfitAndLoss item){
		plDao.updateProfitAndLossItem(item);
	}

	public List<ProfitAndLoss> getAllPlItems() {
		return plDao.getAllItems();
	}


	public void addCurrencyItem(Currency item){
		currencyDao.addCurrencyItemToBase(item);
	}
	public void delCurrencyItem(int id){
		currencyDao.deleteCurrencyItem(id);
	}
	public void updateCurrencyItem(Currency item){
		// TODO: 22.11.17
	}

	public List<Currency> getAllCurrencyItems() {
		return currencyDao.getAllCurrencyItems();
	}

	public void addYearItem(Year item){
		yearDao.insertYearItem(item);
	}

	public void delYearItem(int id){
		yearDao.delYearItemById(id);
	}
	public void updateYearItem(Year item){}
	// TODO: 22.11.17

	public List<Year> getAllYearItems() {
		return yearDao.getAllYearItems();
	}

	public void addBgtItem(Bgt item){
		bgtDao.insertBgtItem(item);
	}

	public void delBgtItem(int id){
		bgtDao.delBgtById(id);
	}
	public void updateBgtItem(Bgt item){
	}

	public List<Bgt> getAllBtgItems(){
		return bgtDao.getAllBgtItems();
	}

}
