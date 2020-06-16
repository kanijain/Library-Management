/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.util.Map;
import java.lang.Long;
import java.util.*;

/**
 *
 * @author HP
 */
public class studentManager {
    public void AddStudent(String name)
    {
        if (mStudents.containsKey(name))
	{
		System.out.println("Student is already added.");
	}
	else
	{
		mStudents.put(name, new Student(name));
	}
    }
    
    public boolean IsStudentPresent(String name)
    {
        if (mStudents.containsKey(name))
	{
		return true;
	}
	else
	{
		System.out.println("Student does not exists."); 
		return false;
	}
    }
    
    public void ListAllBooksIssuedByStudent(String name)
    {
        if (!mStudents.containsKey(name))
	{
		System.out.println("No such student found.");  
	}
	else
	{
		mStudents.get(name).ListAllIssuedBooks();
	}
    }
    
    public void TakeBook(String bookName, String studentName, Long returnTime)
    {
        mStudents.get(studentName).TakeBook(bookName, returnTime);
    }
    
    public Long GetReturnDate(String bookName, String studentName)
    {
        if(mStudents.containsKey(studentName))
        {
            return mStudents.get(studentName).GetReturnTimeForBook(bookName);
        }
        else
        {
            return new Long(0);
        }
     }
    
     public void ReturnBook(String bookName, String studentName)
{
	mStudents.get(studentName).ReturnBook(bookName);
}
    
 public boolean IsBookIssuedToStudent(String bookName, String studentName)
{
	if (IsStudentPresent(studentName)&&mStudents.containsKey(studentName))
	{
		if (mStudents.get(studentName).IsBookIssued(bookName))
		{
			return true;
		}
		else
		{
			System.out.println("This book is not issued to this student.") ;
			return false;
		}
	}
	return false;
}   
    
  
    private Map<String, Student> mStudents = new HashMap<String, Student>();
  }
