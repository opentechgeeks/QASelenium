package com.cognizant.framework;

public class FrameworkException extends RuntimeException {
	private static final long serialVersionUID = -2656965737921095788L;

	public String errorName;

	public FrameworkException(final String errorDescription) {
		super(errorDescription);
		this.errorName = "Error";
	}

	public FrameworkException(final String errorName,
			final String errorDescription) {
		super(errorDescription);
		this.errorName = "Error";
		this.errorName = errorName;
	}
}
