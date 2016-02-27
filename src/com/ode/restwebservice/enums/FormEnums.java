package com.ode.restwebservice.enums;

public enum FormEnums {
	CODE_500("500"),CODE_400("400"),CODE_200("200");
	
	private String enumValue;

	private FormEnums(String enumValue) {
		this.enumValue = enumValue;
	}

	public String getEnumValue() {
		return enumValue;
	}


}
