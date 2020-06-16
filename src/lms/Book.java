/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;
import java.util.*;

/**
 *
 * @author HP
 */
public class Book {
    
    public Book(String bookName, long semester, long count)
    {
        mStudents = new HashSet<>();
        mBookName = bookName;
        mSemester = semester;
        mCount = count;
        mIssueCount = 0;     
    }
    
    public void AddCount(long count)
    {
        mCount += count;
        
    }
    
    public long GetSemester()
    {
        return mSemester;
    }
    
    public boolean CanBookBeIssued()
    {
        if(mIssueCount < mCount)
        {
            return true;
        }
        else
        {
            System.out.println("All books are issued. Cannot issue book");
            return false;
        }
    }
    
    public boolean CanBookBeReturned()
    {
        if (mIssueCount == 0)
	{
		System.out.println("All books are there in library. Cannot return book.");
		return false;
	}
        else
            return true;
        
    }
    
    public boolean IssueBook(String studentId)
    {
        if(mIssueCount < mCount)
        {
            if(mStudents.contains(studentId))
            {
                System.out.println("The book is already issued to the student");
                return false;
            }
            else
            {
                mStudents.add(studentId);
                ++mIssueCount;
                return true;
                
            }
        }
        else
        {
            System.out.println("All books are issued");
            return false;
        }
    }
    
    public boolean ReturnBook(String studentId)
    {
        if(mIssueCount == 0)
        {
            System.out.println("No book is issued. Cannot return");
            return false;
        }
        else
        {
            if(mStudents.contains(studentId))
            {
                mStudents.remove(studentId);
                --mIssueCount;
                return true;
            }
            else
            {
                System.out.println("Book is not issued to the student");
                return false;
            }
        }
       
    }
    public void ListAllIssuers()
    {
        Iterator<String> iter = mStudents.iterator();
        int count = 0;
        while(iter.hasNext()){
        System.out.println(count + ". " + iter.next());
}
        
        
        
    }
       
    private final String mBookName ;
    private final long mSemester;
    private long mCount;
    private long mIssueCount;
    private final Set<String> mStudents;
}
