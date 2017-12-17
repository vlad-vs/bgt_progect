package com.bgt.services;

import com.bgt.dao.*;
import com.bgt.entityes.User;
import com.bgt.entityes.guides.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuidesService {



	@Autowired
	ProfitAndLossGuideDao plDao;

	@Autowired
	UsersGideDao userDao;

	@Autowired
	CurrencuGuideDao currencyDao;

	@Autowired
	YearGuideDao yearDao;

	@Autowired
	BgtGuideDao bgtDao;

	@Autowired
	CompanyesGuideDao companyDao;

	@Autowired
	UnitGuideDao unitDao;

	@Autowired
	Cfo1GuideDao cfo1Dao;


	public void addPlItem(ProfitAndLossGuide item){
		plDao.insertProfitAndLossItem(item);
	}
	public void delPlItem(int id){
		plDao.deleteProfitAndLossItemById(id);
	}

	public void updatePlItem(ProfitAndLossGuide item){
		plDao.updateProfitAndLossItem(item);
	}

	public List<ProfitAndLossGuide> getAllPlItems() {
		return plDao.getAllItems();
	}

	public void addUserItem(User user){
		userDao.insertUserToData(user);
	}
	public void delUserItem(int id){
		userDao.delUsersById(id);
	}
	public void updateUserItem(User user){
		// TODO: 22.11.17
	}

	public List<User> getAllUsersItems() {
		return userDao.findAllUsers();
	}

	public void addCurrencyItem(CurrencyGuide item){
		currencyDao.addCurrencyItemToBase(item);
	}
	public void delCurrencyItem(int id){
		currencyDao.deleteCurrencyItem(id);
	}
	public void updateCurrencyItem(CurrencyGuide item){
		// TODO: 22.11.17
	}

	public List<CurrencyGuide> getAllCurrencyItems() {
		return currencyDao.getAllCurrencyItems();
	}

	public void addYearItem(YearGuide item){
		yearDao.insertYearItem(item);
	}

	public void delYearItem(int id){
		yearDao.delYearItemById(id);
	}
	public void updateYearItem(YearGuide item){}
	// TODO: 22.11.17

	public List<YearGuide> getAllYearItems() {
		return yearDao.getAllYearItems();
	}

	public void addBgtItem(BgtGuide item){
		bgtDao.insertBgtItem(item);
	}

	public void delBgtItem(int id){
		bgtDao.delBgtById(id);
	}
	public void updateBgtItem(BgtGuide item){
//		bgtDao.
	}

	public List<BgtGuide> getAllBtgItems(){
		return bgtDao.getAllBgtItems();
	}



	public void addCompanyItem(CompaniesGuide item){
		companyDao.insertCompanyItem(item);
	}

	public void delCompanyItem(int id){
		companyDao.delCompanyItemById(id);
	}

	public void updateCimpanyItem(YearGuide item){
//		bgtDao.
	}

	public List<CompaniesGuide> getAllCompanyItems(){
		return companyDao.getAllCompanyesItems();
	}

	public void addUnitItem(UnitsGuide item){
		unitDao.insertUnitItem(item);
	}

	public void delUnitItem(int id){
		unitDao.delUnitItemById(id);
	}

	public Object getUnitByKod(String kod){
		Object unitsGuide = unitDao.getUnitItemByKod(kod);
		return unitsGuide;
	}

	public void updateUnitItem(UnitsGuide item){
//		bgtDao.
	}

	public List<UnitsGuide> getAllUnitItems(){
		return unitDao.getAllUnitItems();
	}


	public void addCfo1Item(Cfo1Guide item){
		cfo1Dao.insertCfo1Item(item);
	}

	public void delCfo1Item(int id){
		cfo1Dao.delCfo1ById(id);
	}

	public void updateCfo1Item(Cfo1Guide item){
//		bgtDao.
	}

	public List<Cfo1Guide> getAllCfo1Items(){
		return cfo1Dao.getAllCfo1Items();
	}
}
