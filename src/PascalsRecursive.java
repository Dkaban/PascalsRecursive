//*************************************************************************************
//  PascalsRecursive.java
//
//  Dustin Kaban
//  May 18th, 2020
//  This class allows the user to input a row number
//  and displays the values of that row from Pascal's Triangle
//*************************************************************************************
import java.util.Scanner;

public class PascalsRecursive
{
    public static void main(String[] args)
    {
        //Accept user input for the row of Pascal's Triangle they want to see
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the row of Pascals Triangle: ");
        int rowIndex = scanner.nextInt();

        //Call the function Print and pass it in the index supplied by the user, then display it to the user
        System.out.println(getRowInformation(rowIndex));
    }

    public static String getRowInformation(int desiredRowIndex)
    {
        if(desiredRowIndex == 0)
            return "Row cannot be Zero";

        //A string that will get concatenated over the loops to create the proper output display
        String lineInformation = "";
        //An array to store the line numbers that the user has requested
        int[] lineArray = new int[0];
        //Loop through Row by row and index by index of the Pascals Triangle
        for (int rowNumber = 0; rowNumber < desiredRowIndex; rowNumber++)
        {
            //This for loop puts spaces before the first index of each row based (total rows - rowNumber)
            for(int spacingValue =0; spacingValue<desiredRowIndex-rowNumber; spacingValue++)
            {
                lineInformation += " ";
            }
            lineArray = new int[rowNumber+1];
            for (int columnNumber = 0; columnNumber <= rowNumber; columnNumber++)
            {
                lineArray[columnNumber] = calculatePascal(rowNumber, columnNumber);
                lineInformation += lineArray[columnNumber] + " ";
            }
            lineInformation += "\n";
        }
        return lineInformation;
    }

    public static int calculatePascal(int rowNumber, int columnNumber)
    {
        //A check to see if the index is either in the first or last spot of the row
        if (columnNumber == 0 || columnNumber == rowNumber)
        {
            return 1;
        }
        else
        {
            //We recursively use pascal to calculate each indexes value in the row
            return calculatePascal(rowNumber - 1, columnNumber - 1)
                    + calculatePascal(rowNumber - 1, columnNumber);
        }
    }
}
