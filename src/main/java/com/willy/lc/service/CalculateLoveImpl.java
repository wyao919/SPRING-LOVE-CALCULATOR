package com.willy.lc.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateLoveImpl implements CalculateLove{

	public String calculateLove(String userName, String crushName) {
		
		int nameLength = 0;
		int loveCode = 0;
		String loveResult= "";
		
		nameLength = userName.length() + crushName.length();
		loveCode = nameLength % 4;
		
		if(loveCode == 0)
		{
			loveResult = "BFF's FOREVER!";
		}
		else if(loveCode == 1)
		{
			loveResult = "LOVERS!";
		}
		else if(loveCode == 2)
		{
			loveResult = "Getting Married!";
		}
		else if (loveCode == 3)
		{
			loveResult = "ENEMIES FOR LIFE";
		}
		
		System.out.println(loveResult);
		
		return loveResult;		
	}

}
