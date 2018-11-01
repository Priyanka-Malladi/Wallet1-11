package com.cg.wallet.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.dao.IWalletDao;
import com.cg.wallet.dao.WalletDaoImp;
import com.cg.wallet.exception.WalletException;
import com.cg.wallet.exception.WalletExceptionMessages;

public class WalletServiceImp implements IWalletService {
	
	IWalletDao dao = new WalletDaoImp();
	CustomerBean custBean =  new CustomerBean();
	
	
	@Override
	public boolean createAccount(CustomerBean custBean) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = false;
		if(validate(custBean)) {
			isValid  = dao.createAccount(custBean);
			
		}
		return isValid;
	}

	@Override
	public double deposit(double amount) throws WalletException {
		// TODO Auto-generated method stub
		
	 return dao.deposit(amount);
		
	}

	@Override
	public double withdraw(double amount) throws WalletException {
		// TODO Auto-generated method stub
		
			return dao.withdraw(amount);
			
		
	}


	@Override
	public double showBalance(BigInteger phone) {
		// TODO Auto-generated method stub
		
		return dao.showBalance(phone);
		
	}
	
	@Override
	public boolean fundTransfer(BigInteger toPhone, double amount) throws WalletException {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toPhone, amount);
		
	}
	@Override
	public ArrayList<WalletTransactions> printTransactions(BigInteger phone,LocalDateTime sd,LocalDateTime ed) {
		// TODO Auto-generated method stub
		return dao.printTransactions(phone,sd,ed);
	}

	@Override
	public boolean validate(CustomerBean cb) throws WalletException {
		// TODO Auto-generated method stub
		boolean isValid = true;
		if(!(cb.getFirstName()!=null && cb.getFirstName().matches("[A-Za-z]{4,}"))) {
			throw new WalletException(WalletExceptionMessages.ERROR1);
		}
		if(!(cb.getLastName()!=null && cb.getLastName().matches("[A-Za-z]{4,}"))) {
			throw new WalletException(WalletExceptionMessages.ERROR2);
		}
		if(!(cb.getPhoneNum()!=null && cb.getPhoneNum().toString().matches("^[6-9][0-9]{9}$"))) {
			throw new WalletException(WalletExceptionMessages.ERROR4);
		}
		if(!(cb.getEmailId()!=null && cb.getEmailId().matches("[a-z_A-Z0-9]+@+[a-z]+\\.com"))) {
			throw new WalletException(WalletExceptionMessages.ERROR3);
		}
		if(!(cb.getBalance()>100)) {
			throw new WalletException(WalletExceptionMessages.ERROR6);
		}
		return isValid;
	}
	
	
	

	
}
