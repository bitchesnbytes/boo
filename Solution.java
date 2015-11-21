import java.util.*;
import java.io.*;

public class Patient
{
  private String patientId; 
  private boolean Remission;
  private double RemDuration;
  private double monthsToLive; 
  HashMap<String[], Float[]> data = new HashMap<String[], Float[]>();
  
  public Patient(String patientId, boolean Remission, double RemDuration, double monthsToLive, HashMap data){
    this.patientId = patientId;
    this.Remission = Remission;
    this.RemDuration = RemDuration;
    this.monthsToLive = monthsToLive;
    this.data = data;
  }
  
  public String getPatientId(){
    return this.patientId;
  }
  
  public void setPatientId(String patientId){
    this.patientId = patientId;
  }
  
  public boolean getRemission(){
    return this.Remission;
  }
  
  public void setRemission(boolean Remission){
    this.Remission = Remission;
  }
  
  public double getRemDuration(){
    return this.RemDuration;
  }
  
  public void setRemDuration(double RemDuration){
    this.RemDuration = RemDuration;
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
