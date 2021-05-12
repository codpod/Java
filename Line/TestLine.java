
/**************************
  AUTHOR: Cody McAntire
 **************************/

/******************************************************************** 
Now we will define a driver program below called TestLine with 
main() where execution will begin. It is this class, and this code,
that will create instances of the Line and call its methods. As a 
test module, this code would be improved with additional 
System.out.println() statements that explain what is being attempted
and what the results should be, for example: "About to change l1 to
an invalid value and then redraw it. Line position 
should not change: 
*********************************************************************/
import mcantirelinepackage.*;
import java.io.*;
import java.lang.Math;

class TestLine 
{ 

  public static void main(String args[])
  { 
    Line l1 = null, l2 = null; 
    //declare 2 instances of Line class 
    System.out.printf ("\nFor Line One -");

    //create 1 Line object
    try
    { 
      l1 = new Line (10, 10, 100, 100); 
    }
    catch(Exception e) //display msg about failure and terminate program
    {
      System.exit(88); //return code of 88
    }  
    l1.draw();
    
    //change start point with valid values 
    try
    {
      l1.setLine(5, 5, l1.getXTwo(), l1.getYTwo());
      System.out.printf("*Change start point of line with valid values* \n");
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    //draw it again with new start point 
    l1.draw(); 
    
    
    //try to change xOne (x1) to an illegal value 
    try
    {
      l1.setXOne(3000);
      System.out.printf("In drawline -");
    }
    catch(Exception e)
    {
      System.out.println("--EXCEPTION MY CATCH CAUGHT A GENERIC EXCEPTION IN A SET METHOD FOR BAD VALUE OF X1 FOR AN EXISTING LINE\n");
      System.out.println(e + "\n"); 
    }
    //draw the line...x1 should now be zero 
    l1.draw(); 
    
    //create a second Line instance, or object 
    try
    {
      l2 = new Line(100, 100, 400, 400); 
      System.out.printf("*Create a second line* \n");
    }
    catch(Exception e)
    {
      System.exit(88);
    }    
    //draw 2nd line 
    l2.draw(); 
    
    
    //set a new valid yTwo for line 2 
    try
    {
      l2.setYTwo(479);
      System.out.printf("*Change value of y is second line from 400 to 479* \n");
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    //draw 2nd line again 
    l2.draw(); 
    
    
    
    //test line 1 angle
    System.out.println("The angle of the line 1 is " + l1.getAngle()); //0.7853981633974482
    //test line 2 angle
    System.out.println("The angle of the line 2 is " + l2.getAngle() + "\n"); //0.9012249669521654
    
    //test line 1 length
    System.out.println("The length for line 1 is " + l1.getLength()); //134.35028842544403
    //test line 2 length
    System.out.println("The length for line 2 is " + l2.getLength() + "\n"); //483.3642518846424    
    
    System.out.println("Test 2D point Constructor X1 = 10 \n"); // 10
    System.out.println("Test 2D point Constructor X2 = 5 \n"); // 5
    
    System.out.println("Test 2D point Constructor Y1 = 100 \n"); // 100
    System.out.println("Test 2D point Constructor Y2 = 400 \n\n"); // 400
    
    TwoDPoint TDC1 = new TwoDPoint(10, 100);
    TwoDPoint TDC2 = new TwoDPoint(5, 400);
    //code to test new Line constructor (only test successful case here)
    try
    {
      Line l3 = new Line(TDC1, TDC2);
    }
    catch(Exception e)
    {
      System.exit(88);
    }
    
    //attempt to create new line with values
    try
    {
      Line l4 = new Line (5, 500, 50, 100);
    }
    catch(Exception e)
    {
      System.out.println("EXCEPTION: This try catch caught a Generic Exception for a bad constructor -Failed to create a line with 4 invalid values-leaving with rc of 88\n\n");
      System.out.println("Java.Result:88\n");
      System.exit(88);
    }
    
    
  } // end of main

} // end class TestLine
