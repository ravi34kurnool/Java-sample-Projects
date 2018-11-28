package com.cisco.cloudray.restart.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
  public static void main(String[] args)
  {
    try
    {
      System.out.println("Before Invoking the process for ciscoafm restart ");
      String[] cmd = { "/bin/sh", "-c", "service ciscoafm restart" };
      Process process = Runtime.getRuntime().exec(cmd);
      
      BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String s;
      while ((s = br.readLine()) != null)
      {
        System.out.println("line: " + s);
      }
      System.out.println("After Invoking the process for ciscoafm restart ");
      if ((process != null) && (process.waitFor() == 0)) {
        System.out.println("Restart command for the ciscoafm service submitted successfully..");
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}