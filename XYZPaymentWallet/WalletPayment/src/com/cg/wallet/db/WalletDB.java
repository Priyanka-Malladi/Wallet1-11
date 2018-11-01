package com.cg.wallet.db;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.cg.wallet.bean.CustomerBean;

public class WalletDB {

	private static List<CustomerBean> customerList = new ArrayList<CustomerBean>();
	
	
	static CustomerBean custBean1 = new CustomerBean();
	static CustomerBean custBean2 = new CustomerBean();
	static{
		
	custBean1.setFirstName("Priya");
	custBean1.setLastName("Joseph");
	custBean1.setEmailId("priyajoseph23@gmail.com");
	custBean1.setPhoneNum(new BigInteger("9979896543"));
	custBean1.setBalance(2000);
	custBean1.setDate(LocalDateTime.now());
	customerList.add(custBean1);
	custBean2.setFirstName("John");
	custBean2.setLastName("Micheal");
	custBean2.setEmailId("johnmicheal@gmail.com");
	custBean2.setPhoneNum(new BigInteger("9979896544"));
	custBean2.setBalance(5000);
	custBean2.setDate(LocalDateTime.now());
	customerList.add(custBean2);
	
	
}
	public static List<CustomerBean> getList(){
		return customerList;
	}
}
