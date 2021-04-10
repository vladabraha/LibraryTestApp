package cz.braha.applicanttest.exceptions;

public class DoesNotExist extends RuntimeException{
	public DoesNotExist(String errorMessage) {
		super(errorMessage);
	}
}
