/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.database;

import java.security.MessageDigest;

/**
 *
 * @author Aryaman
 */
public class Encrypt {
   
    public String MD5(String s)
    {
    try
    {
        MessageDigest digs=MessageDigest.getInstance("MD5");
        digs.update(s.getBytes("UTF8"));
        String str=new String(digs.digest());
        
        return str;
    }
    catch(Exception e)
    {return "";
    }
    }
}
