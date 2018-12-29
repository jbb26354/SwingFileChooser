/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

public class BadDataException
{
  // INSTANCE FIELDS
  // ===============

  private String strStatus = "Datafile records OK!";
  private int intRecordsScrubbed = 0;


  // CONSTRUCTOR
  // ===========

  public BadDataException(String strIn)
  {
    if(strIn.length() > 0)
    {
      String[] temp;
      String delimiter = "\n";
      int intCount = 1;
      temp = strIn.split(delimiter);

      if(isInteger(temp[0]))
      {
        int intRows = new Integer(temp[0]).intValue();
        String[][] strBuf = new String [intRows][3];
        for(int i =0; i < intRows; i++)
        {
          for(int j =0; j < 3; j++)
          {
            strBuf[i][j] = temp[intCount].trim();
            intCount++;
          }
        }
        for(int i =0; i < intRows; i++)
        {
          if(isInteger(strBuf[i][0]))
          {
            if(strBuf[i][1].equals("saving") ||
               strBuf[i][1].equals("checking") ||
               strBuf[i][1].equals("timedeposit")
              )
            {
              if(isMoney(strBuf[i][2]))
              {
                //Record is OK
                intRecordsScrubbed++;
              }
              else
              {
                strStatus = "Bad balance at record: " + (i + 1) + " : " + strBuf[i][2];
              }
            }
            else
            {
              strStatus = "Bad account type at record: " + (i + 1) + " : " + strBuf[i][1];
            }
          }
          else
          {
            strStatus = "Bad account ID at record: " + (i + 1) + " : " + strBuf[i][0];
          }
        }
      }
      else
      {
        strStatus = "Bad record count: " + temp[0];
      }
    }
    else
    {
      strStatus = "No input";
    }
  }


  // ACCESSORS
  // =========

  public String getStatus()
  {
    return strStatus + " (" + intRecordsScrubbed + ")";
  }


  // STATIC METHODS
  // ==============

  private static boolean isInteger(String checkStr)
  {
    try
    {
      Integer.parseInt(checkStr);
      return true; //Did not throw, must be castable
    }
    catch(NumberFormatException err)
    {
      return false; //Threw, So not castable
    }
  }
  private static boolean isMoney(String checkStr)
  {
    try
    {
      Float.parseFloat(checkStr);
      return true; //Did not throw, must be castable
    }
    catch(NumberFormatException err)
    {
      return false; //Threw, So not castable
    }
  }
}
