package com.w2a.rough;

import java.util.Date;

public class date {

	public static void main(String[] args) {
		Date d=new Date();
		String screenShotName=d.toString().replace(":", "_").replace(" ", "_")+".JPG";
		System.out.println(screenShotName);
		
	}
}
