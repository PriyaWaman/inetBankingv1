package com.inetBankingv1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

public ReadConfig()
{File srs=new File("./Configuration_file/config.properties");
try {
	FileInputStream fis=new FileInputStream(srs);
	pro=new Properties();
	
		pro.load(fis);//load() will load complete config.properties file&if file is not available throw exception
	
	}
catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception isn" + e.getMessage());
	}
}
public String getApplicationURL()
{
	String url=pro.getProperty("baseURL");
	return url;}
public String getUsername()
{
	String username=pro.getProperty("username");
	return username;}
public String getPassword()
{
	String pswd=pro.getProperty("password");
	return pswd;}
public String getChromePath()
{
	String chrompath=pro.getProperty("cromepath"); 
	return chrompath;}

public String getfirefoxPath()
{
	String firefoxpath=pro.getProperty("firefoxpath"); 
	return firefoxpath;}
} 
