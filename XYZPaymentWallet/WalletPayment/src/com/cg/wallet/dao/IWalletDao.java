package com.cg.wallet.dao;


import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.cg.wallet.bean.CustomerBean;
import com.cg.wallet.bean.WalletTransactions;
import com.cg.wallet.exception.WalletException;

public interface IWalletDao {

public double showBalance(BigInteger phone);

public boolean createAccount(CustomerBean cb);

public double deposit(double amount) throws WalletException;

public double withdraw(double amount) throws WalletException;

public boolean fundTransfer(BigInteger toPhone ,double amount) throws WalletException;

public ArrayList<WalletTransactions> printTransactions(BigInteger phone,LocalDateTime sd,LocalDateTime ed);

}
