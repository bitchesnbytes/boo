import java.util.*;
import java.io.*;

public class Patient
{
  private boolean Remission;
  private double RemDuration;
  private double monthsToLive; 
  HashMap<String[], Float[]> geneticInfo = new HashMap<String[], Float[]>();
  
  public Patient getRemission(){
    return this.Remission;
  }
  
  public Patient getRemDuration(){
    return this.remDuration;
  }
  
  public Patient getMonthsToLive(){
    return this.monthsToLive;
  }
}

public class Solution
{
  
}
