/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.util.Scanner;


/**
 *
 * @author HP
 */
public class LibraryManager {
    public void AddBook()
    {
        Scanner input = new Scanner(System.in);
	System.out.println("Enter book Name : ");
        String bookName = input.next();
	System.out.println("Enter semester : " );
        int semester = input.nextInt();
	System.out.println("Enter count : ");
	int count = input.nextInt();
	mBookManager.AddBook(bookName, semester, count);
        
    }
    public void AddStudent()
    {
        Scanner input = new Scanner(System.in);
	System.out.println("Enter Student Name : ");
	 String name = input.next();
	mStudentManager.AddStudent(name);
        
    }
    public void IssueBookToStudent()
    {
        Scanner input = new Scanner(System.in);
         System.out.println("Enter book Name: ");
	String bookName = input.next(); 
	if (!mBookManager.IsBookAvailable(bookName))
	{
		
		return;
	}
	 System.out.println("Enter student Name : ");
	String studentName = input.next(); 
	if (!mStudentManager.IsStudentPresent(studentName))
	{
		
		return;
	}
	
	System.out.println( "Enter book issue duration in days : ");
	long day = input.nextInt(); 
	Long returnTime = calculateReturnTime(day);
	if (mBookManager.IssueBook(bookName, studentName))
	{
		mStudentManager.TakeBook(bookName, studentName, returnTime);
	}
	
        
        
    }
    public void ReturnBook()
    {
        Scanner input = new Scanner(System.in);
	System.out.println( "Enter book Name: "); 
	String bookName = input.next();
	if (!mBookManager.IsBookReturnable(bookName))
	{
		
		return;
	}
	 System.out.println("Enter student Name : ");
	String studentName = input.next();
	if (!mStudentManager.IsStudentPresent(studentName))
	{
		
		return;
	}
	if (!mStudentManager.IsBookIssuedToStudent(bookName, studentName))
	{
		
		return;
	}
	calculateFine(mStudentManager.GetReturnDate(bookName, studentName));
	if (mBookManager.ReturnBook(bookName, studentName))
	{
		mStudentManager.ReturnBook(bookName, studentName);
	}
    }
    public void ListAllBooksForSemester()
    {
        Scanner input = new Scanner(System.in);
       
	System.out.println("Enter Semester : ");
	int semester= input.nextInt();
	mBookManager.ListAllBooksForSemester(semester);
	
    }
   public  void ListAllBooksIssuedByStudent()
   {
         Scanner input = new Scanner(System.in);
	System.out.println("Enter student Name : ");
	String name = input.next();
	mStudentManager.ListAllBooksIssuedByStudent(name);
   }
    public void ListAllStudentsIssuedThisBook()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Book Name : ");
	String name = input.next();
	mBookManager.ListAllIssuersOfBook(name);
	
        
    }
    
    private final BookManager mBookManager = new BookManager();
    private final studentManager mStudentManager = new studentManager();

    private Long calculateReturnTime(long days)
    {
        int ONE_DAY = 24*60*60*1000;
        return System.currentTimeMillis() + ONE_DAY * days;
    }
    
    public void calculateFine(Long returnTime)
    {
        int ONE_DAY = 24*60*60*1000;
        long timeDiff = (System.currentTimeMillis() - returnTime.longValue())/ONE_DAY;
        if (timeDiff > 0)
        {
            System.out.println("You have missed your deadline. Please pay Fine : Rs." + 10 * timeDiff); 
        }
        else
        {
            System.out.println("Book returned");
        }
    }
    
}
