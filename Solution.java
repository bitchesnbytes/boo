import java.util.*;
import java.io.*;

public class Solution
{
  public static void main (String[] args)
  {
    ArrayList<Patient> butthole = new ArrayList<Patient>();
    butthole = importPatientInfo("trainingData.txt");
    for(int i = 0; i<butthole.size(); i++)
    {
      System.out.println(butthole.get(i).getPatientId());
    }
  }
}
