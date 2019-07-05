package com.niit.backend;

import com.niit.backend.hibernateconfig.h2config;

public class App 
{
    public static void main( String[] args )
    {
    	
    	System.out.println("configuration file begins");
    	h2config h = new h2config();
        h.getHibernateSessionFactory();
    	
    	
    	
    	System.out.println("configuration file ends");
    	
    	
    }  
}
