package view;

import errors.InvalidLoginException;
import model.Member;

public interface LoadingMember {
	public Member run() throws InvalidLoginException;
}
