/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.util.Map; 
import java.util.*;

/**
 *
 * @author HP
 */
public class BookManager {
     
    public boolean IsBookAvailable(String name)
    {
        if (mBooks.containsKey(name))
        {
            return mBooks.get(name).CanBookBeIssued();
         }
        else
        {
            System.out.println("Book is not present in the library."); 
            return false;
        }
    }

    public boolean IsBookReturnable(String name)
    {
         if (mBooks.containsKey(name))
         {
             return mBooks.get(name).CanBookBeReturned();
         }
         else
         {
            System.out.println("Book is not present in the library."); 
            return false;                
         }
    }

    public boolean IssueBook(String bookName, String studentName)
    {
        if (IsBookAvailable(bookName)&&mBooks.containsKey(bookName))
	{
            return mBooks.get(bookName).IssueBook(studentName);
	}
        else
            return false;
    }
    
    public boolean ReturnBook(String bookName, String studentName)
    {
        if (mBooks.containsKey(bookName))
        {
        return mBooks.get(bookName).ReturnBook(studentName);
        }
        else 
            return false;
	
    }

    public void ListAllIssuersOfBook(String bookName)
    {
        if(mBooks.containsKey(bookName)) 
        {
            System.out.println("All issuers of the book are");
            mBooks.get(bookName).ListAllIssuers();
        }
	
        
    }
    
     public void ListAllBooksForSemester(long semester)
    {
        int bookcount = 0;
        Iterator<Map.Entry<String, Book>> it = mBooks.entrySet().iterator();
	System.out.println("Books for semester "+ semester+":");
        while (it.hasNext())
	{
            Map.Entry<String, Book> pair = it.next();
            if (pair.getValue().GetSemester() == semester)
            {
		++bookcount;
		System.out.println(bookcount + ". " +pair.getKey() ); 
            }
	}

	if (bookcount == 0)
	{
		System.out.println("Sorry, No books found for this semester");  
	}   
    }

    public void AddBook(String name, int semester, int count)
    {
        if (mBooks.containsKey(name))
	{
		Iterator<Map.Entry<String, Book>> it = mBooks.entrySet().iterator();
		mBooks.get(name).AddCount(count);
	}
	else
	{
		mBooks.put(name, new Book(name, semester, count));
	}
        
    }
    
    private Map<String, Book> mBooks = new HashMap<String, Book>();
 
    
}
