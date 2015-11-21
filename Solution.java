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

private static ArrayList<Patient> importPatientInfo(String patientFilePath)
{
  ArrayList<Patient> patient = new ArrayList<Patient>();
  try
  {
    BufferedReader reader = new BufferedReader (new FileReader(patientFilePath));
    String currentLine = reader.readLine();
    currentLine = reader.readLine();
    while(currentLine != null)
    {
      String[] parts = new String[4];
      parts = currentLine.split(",");
      String firstname = parts[0];
      String lastname = parts[1];
      String specialty = parts[2];
      long id = Long.parseLong(parts[3]);
      Patient newPatient = new Patient(aRemission, aDuration, aMonths, aCorrelation);
      doc.add(newdoc);
      currentLine = reader.readLine();
    }
    reader.close();
    }
  catch (IOException x)
  {
    System.out.println(x);
  }
  //returns array list
  return doc;
 }
public class Solution
{
  
}
