package view;

import java.util.Scanner;

import errors.InvalidLoginException;
import model.databases.ExistingMemberBuilder;
import model.Member;
import model.dbConnections.ICreateDataBase;

public class AccessingExistingMember implements LoadingMember{

	ICreateDataBase dataBase;

	public AccessingExistingMember(ICreateDataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	public Member run() throws InvalidLoginException{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is your username?");
		String userName = sc.nextLine();
		System.out.println("What is your password?");
		String password = sc.nextLine();
		
		return new ExistingMemberBuilder(userName, password, dataBase).run();
		
	}


}
