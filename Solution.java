import java.util.*;
import java.io.*;

// Class for patient data
class Patient
{
  private String patientId; 
  private boolean remission;
  private double remDuration;
  private double monthsToLive;
  private String infection;
  HashMap<String, Double> data = new HashMap<String, Double>();
  
  // Constructor that takes all Patient attributes as input
  public Patient(String patientId, String infection, boolean Remission, double RemDuration, double monthsToLive, HashMap<String, Double> data){
    this.patientId = patientId;
    this.remission = remission;
    this.infection = infection;
    this.remDuration = remDuration;
    this.monthsToLive = monthsToLive;
    this.data = data;
  }
  
  public String getPatientId(){ return this.patientId;  }
  public boolean getRemission(){ return this.remission; }
  public double getRemDuration(){ return this.remDuration; }
  public double getMonthsToLive(){ return this.monthsToLive; }
  public HashMap<String, Double> getHashMap() { return this.data; }
  public String getInfection() { return this.infection; }
  
}

public class Solution
{
  
  
  public static void main (String[] args) throws Exception
  {
    ArrayList<Patient> patientList = new ArrayList<Patient>();
    patientList = importPatientInfo("trainingData.txt");
    for(int i = 0; i<patientList.size(); i++)
    {
      System.out.println(patientList.get(i).getInfection());
    }
    
  }
  private static ArrayList<Patient> importPatientInfo(String patientFilePath)
  {
    ArrayList<Patient> patient = new ArrayList<Patient>();
    try
    {
      BufferedReader reader = new BufferedReader (new FileReader(patientFilePath));
      
      String currentLine = reader.readLine();
      currentLine = currentLine.toLowerCase();
      currentLine = reader.readLine();
      String [] parts = currentLine.split("\t"); //put elements in array seperated by tabs
      String [] keys = new String [266];//string of the keys to hash map
      int counter = 0;
      for (int i = 1; i < 266; i++) //go through first block to get all keys into keys array 
      {
        // System.out.println(parts[i]);
        keys[counter] = parts[i];
        counter++;
      }  
      currentLine = reader.readLine();
      
      while(currentLine!= null)
      {
        currentLine = currentLine.toLowerCase();
        parts = currentLine.split("\t");
        
        
        int [] nonNumIndex = {1,4,5,6,7,8,9,10};
        
        // changes all nonnumerical attributes
        for (int m = 0; m < nonNumIndex.length; m++)
        {
          
          int i = nonNumIndex[m];
          
          if (parts[i].equals("no") || parts[i].equals("m") || parts[i].equals("neg") || parts[i].equals("anthra-hdac"))
          {
            parts[i] = "0";
          }
          
          if (parts[i].equals("yes") || parts[i].equals("f") || parts[i].equals("pos") || parts[i].equals("anthra-plus"))
          {
            parts[i] = "1";
          }
          
          if (parts[i].equals("na") || parts[i].equals("notdone") || parts[i].equals("nd"))
          {
            parts[i] = "8008135"; //arbitrary number to avoid NullPointer error - will be dealt with later
          }
        }
        
        HashMap<String, Double> aData = new HashMap<String, Double>();
        String aID;
        boolean aRemission;
        double aDuration;
        double aMonths;
        String infection = parts[11];
        aID = parts[0];
        if(parts[266].equals("complete_remission"))
        {
          aRemission = true;
        }
        else
        {
          aRemission = false;
        }
        if (!(parts[267].equals("na")))
        {
          aDuration =Double.parseDouble(parts[267]);
        }
        else{ aDuration = 0; }
        
        aMonths = Double.parseDouble(parts[268]);
        int counter2 = 0;
        for (int i=1; i<266; i++)
        {
          if (i == 11)
          {
            i++;
          }
          // System.out.println(parts[i]);
          else if(parts[i].equals("na"))
          {
            Double value = Double.parseDouble("8008135"); //arbitrary number to avoid NullPointer error - will be dealt with later
          }
          else
          {
            Double value = Double.parseDouble(parts[i]);
            
//          System.out.println(value);
            aData.put(keys[counter2], value);
          }
        }
        
        Patient newPatient = new Patient (aID, infection, aRemission, aDuration, aMonths, aData); //create a new patient object for each line of code
        patient.add(newPatient);
        currentLine = reader.readLine();
        
      }
      reader.close();
    }
    catch (IOException x)
    {
      System.out.println(x);
    }
    //returns array list
    return patient;
  }
  
  public static ArrayList<Patient> getRemissionPatients(ArrayList<Patient> patients)
  {
    ArrayList<Patient> remPatients = new ArrayList<Patient>();
    
    for (int i = 0; i < patients.size(); i++)
    {
      if(patients.get(i).getRemission())
      {
        remPatients.add(patients.get(i));
      }
    }
    return remPatients;
    
  }
  
  public static ArrayList<Patient> getResistantPatients(ArrayList<Patient> patients)
  {
    ArrayList<Patient> resPatients = new ArrayList<Patient>();
    
    for (int i = 0; i < patients.size(); i++)
    {
      if(!(patients.get(i).getRemission()))
      {
        resPatients.add(patients.get(i));
      }
    }
    return resPatients;
  }
  
}

class statCalcs
{
  public static double calculateMean(double[] array){
    double sum = 0;
    for(int i=0; i<array.length; i++){
      sum += array[i];
    }
    double average = sum/array.length;
    return average;
  }
  
  public static double calculateMedian(double[] array){
    Arrays.sort(array);
    double median=0;
    if(array.length%2 == 0){
      median = ((double)array[array.length/2] + (double)array[array.length/2-1]);
    }
    else{
      median = (double)array[array.length/2];
    }
    return median;
  }
  
  public static double standardDeviation(double[] array){
    double average = calculateMean(array);
    double variance = 0;
    for(int i=0; i<array.length; i++){
      variance += ((array[i] - average)*(array[i] - average))/array.length;
    }
    double sD = Math.sqrt(variance);
    return sD;
  }
}

