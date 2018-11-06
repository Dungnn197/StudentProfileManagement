package model.dao;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import model.entity.account.Account;
import model.entity.account.Accounts;
import utility.Utility;

public class AccountDAO {

	private String path;

	public AccountDAO(String path) {
		this.path = path;
	}

	public Account checkAccount(String email, String password) throws JAXBException {
		List<Account> accounts = unmashaller();
		String hashedPassword = Utility.hashPassword(password);
		Account account = accounts.stream()
				.filter(acc -> email.equals(acc.getEmail()) && hashedPassword.equals(acc.getPassword())).findAny()
				.orElse(null);
		return account;
	}

	private List<Account> unmashaller() throws JAXBException {
		File file = new File(path + "WEB-INF/XML_DB/Accounts.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class);
		Accounts accounts = (Accounts) jaxbContext.createUnmarshaller().unmarshal(file);
		return accounts.getAccount();
	}

}
