/**
 * @author Z
 * @since 13 November 2017
 */

import java.util.Scanner;

public class Dates
{
    private final static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args)
    {
        int iDaysInMonth, iDay, iMonth, iYear;
        boolean bDayValid, bMonthValid, bYearValid, bLeapYear;

        iDay = PromptInt("Enter the day: ");
        iMonth = PromptInt("Enter the month: ");
        iYear = PromptInt("Enter the year: ");

        bMonthValid = iMonth >= 1 && iMonth <= 12;
        bYearValid = iYear >= 1000 && iYear <= 1999;
        bLeapYear = iYear % 400 == 0 || (iYear % 4 == 0 && iYear % 100 != 0);

        iDaysInMonth = !bMonthValid ? 0 : iMonth == 2 ? (iYear % 4 == 1 ? 28 : (iYear % 100 == 1 ? 29 : (iYear % 400 == 1 ? 28 : 29))) : ((iMonth - 1) % 7 % 2 == 1 ? 30 : 31);

        bDayValid = iDay >= 1 && iDay <= iDaysInMonth;

        if (bYearValid && bMonthValid && bDayValid)
            System.out.println(String.format("Date is valid and it's %sleap year", (bLeapYear ? "" : "not ")));
        else
            System.out.println("Date is not valid");
    }

    private static int PromptInt(String question)
    {
        System.out.print(question);

        while (!SCAN.hasNextInt())
        {
            System.out.flush();

            System.out.print("Whole number only: ");

            SCAN.next();
        }

        return SCAN.nextInt();
    }
}
