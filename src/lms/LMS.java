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
public class LMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int option=0;
	LibraryManager libraryManager = new LibraryManager();
	while (option != 9)
	{
            Scanner input = new Scanner(System.in);
		 System.out.println("1. Add Book"); 
		System.out.println("2. Add Student");
		System.out.println("3. Issue Book"); 
		System.out.println( "4. Return Book");
		System.out.println( "5. List all books for semester");
		System.out.println( "6. List all books issued by student");
		System.out.println("7. List all students issued this book"); 
		System.out.println( "9. quit" );
		 option = input.nextInt();

		switch (option)
		{
		case 1:
			libraryManager.AddBook();
			break;
		case 2:
			libraryManager.AddStudent();
			break;
		case 3:
			libraryManager.IssueBookToStudent();
			break;
		case 4:
			libraryManager.ReturnBook();
			break;
		case 5:
			libraryManager.ListAllBooksForSemester();
			break;
		case  6:
			libraryManager.ListAllBooksIssuedByStudent();
			break;
		case 7:
			libraryManager.ListAllStudentsIssuedThisBook();
			break;
                case 9:
                        break;
		default:
			System.out.println( "Invalid Input. Please try again."); 
            }
	}
    }
}
