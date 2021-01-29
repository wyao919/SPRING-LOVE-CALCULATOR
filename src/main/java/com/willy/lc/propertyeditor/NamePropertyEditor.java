package com.willy.lc.propertyeditor;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		System.out.println("String text = " + text);
		String converterString = text.toUpperCase();
		
		setValue(converterString);
		
		
	}
	
	

}
