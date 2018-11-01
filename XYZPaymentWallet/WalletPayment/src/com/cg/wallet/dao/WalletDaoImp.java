package com.cg.wallet.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.db.WalletDB;
import com.cg.wallet.exception.WalletException;

public class WalletDaoImp implements IWalletDao {

	List<CustomerBean> customerList = WalletDB.getList();

	List<WalletTransactions> transacList = new ArrayList<WalletTransactions>();

	@Override
	public boolean createAccount(CustomerBean cb) {
		// TODO Auto-generated method stub

		return customerList.add(cb);
	}

	@Override
	public double deposit(double amount) throws WalletException {
		// TODO Auto-generated method stub
		double bal=0.0;
		CustomerBean custBean = customerList.get(1);
			double balance = custBean.getBalance();
			balance = balance + amount;
			custBean.setBalance(balance);
			bal = showBalance(custBean.getPhoneNum());
			WalletTransactions transac = new WalletTransactions();
					transac.setAmount(amount);
					transac.setBalance(custBean.getBalance());
					transac.setDate(custBean.getDate());
					transac.setPhoneNum(custBean.getPhoneNum());
					transac.setType("withdraw");
					transacList.add(transac);
		return bal;
	}

	@Override
	public double withdraw(double amount) throws WalletException {
		// TODO Auto-generated method stub
		double bal=0.0;
		CustomerBean custBean = customerList.get(0);
		if(custBean.getBalance()>=amount){
			double balance = custBean.getBalance();
			balance = balance - amount;
			custBean.setBalance(balance);
			bal = showBalance(custBean.getPhoneNum());
			WalletTransactions transac = new WalletTransactions();
					transac.setAmount(amount);
					transac.setBalance(custBean.getBalance());
					transac.setDate(custBean.getDate());
					transac.setPhoneNum(custBean.getPhoneNum());
					transac.setType("withdraw");
					transacList.add(transac);
				}
			
		return bal;
	}

	@Override
	public double showBalance(BigInteger phone) {
		// TODO Auto-generated method stub
		double bal=0.0;	
		for (CustomerBean customerBean : customerList) {
			if (customerBean.getPhoneNum().equals(phone) ) {
			 bal = customerBean.getBalance();
			}
		}

		return bal;

	}

	
	@Override
	public boolean fundTransfer(BigInteger toPhone, double amount) throws WalletException {
	// TODO Auto-generated method stub
		boolean valid = false;
		double balance=0;
		if(customerList.get(1).getPhoneNum().equals(toPhone)){
			balance = withdraw(amount);
			valid = true;
		}
		if (valid ) {
			 balance = deposit(amount);
		}
		else{
			valid = false;
		}
		
		
		
		
	return valid;
		
	}

	@Override
	public ArrayList<WalletTransactions> printTransactions(BigInteger phone,LocalDateTime sd, LocalDateTime ed) {
		ArrayList<WalletTransactions> li = new ArrayList<>();
		for (WalletTransactions walletTransac : transacList) {
			if (walletTransac.getPhoneNum().equals(phone)) {
				if (walletTransac.getDate().isAfter(sd)
						&& walletTransac.getDate().isBefore(ed)) {
					li.add(walletTransac);
				}
			}
		}
		return li;
	}

}