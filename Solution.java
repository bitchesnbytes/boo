import java.util.*;
import java.io.*;

public class Patient
{
  private boolean Remission;
  private double RemDuration;
  private double monthsToLive; 
  
  public boolean getRemission(){
    return this.Remission;
  }
  
  public void setRemission(boolean remission){
    this.remission = remission;
  }
  
  public double getRemDuration(){
    return this.remDuration;
  }
  
  public void setRemDuration(double remDuration){
    this.remDuration = remDuration;
  }
  
  public double getMonthsToLive(){
    return this.monthsToLive;
  }
  
  public void setMonthsToLive(double monthsToLive){
    this.monthsToLive = monthsToLive;
  }
  
}

public class Solution
{
  
}
