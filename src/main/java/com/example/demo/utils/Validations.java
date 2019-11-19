package com.example.demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

	public static boolean mobileValid(String s) 
    { 
        
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    } 
}

