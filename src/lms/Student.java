/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.util.Iterator;
import java.util.Map;
import java.lang.Long;
import java.util.*;
/**
 *
 * @author HP
 */
public class Student {
    public Student(String name)
    {
        mName = name;
    }
    
    public void TakeBook(String name, Long returnTime)
     {
          mBooks.put(name, returnTime);
            
     }
        
     public Long ReturnBook(String name)
      {
            Long returnTime = GetReturnTimeForBook(name);
            mBooks.remove(name);
            return returnTime;
            
       }
        
	public long GetReturnTimeForBook(String name)
        {
            
            if (mBooks.containsKey(name))
	{
		return mBooks.get(name);
	}
	else
	{
		System.out.println("This book is not issued."); 
		return 0;
	}
            
        }
        
	public void ListAllIssuedBooks()
        {
      Iterator<Map.Entry<String, Long>> it = mBooks.entrySet().iterator();
	System.out.println("List of all books issued: ");
	int count = 0;
	while (it.hasNext())
	{
		++count;
		System.out.println(count + "." + it.next().getKey()) ;
                
	}

	if (count == 0)
	{
		System.out.println("No book is issued.");
	}
        }
        
	public boolean IsBookIssued(String bookName)
        {
            if (mBooks.containsKey(bookName))
                {
                   return true;
                           
                }

	   else
	       {
		
                 System.out.println("This book is not issued.");
		    return false;
	        }
          }
        
        private String mName;
	private Map<String, Long> mBooks = new HashMap<String, Long>();
    
}
