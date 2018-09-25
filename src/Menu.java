/**
 @author Eddie Dounn CS3354-003
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class Menu
{
	//static ArrayList<Item> itemsList;
	static Scanner keyboard;
	static File input;


	/**
	*  Constant width for printing to screen per style guideline
	*/
	public static final int DIS_WIDTH = 80;


	/**
	 * method to print all the items
	 */
	static void displayItems()
	{


		/**
		 * printing the lines before headings
		 */

		for (int i = 0; i < DIS_WIDTH; i++){
    		System.out.print("-");
		}

		System.out.println();

		/**

		 * printing the headings

		 */

		System.out.printf("| %10s | %20s | %20s | %10s | %10s |\n", "ID #",

						  "NAME", "CATEGORY", "QUANTITY", "PRICE");

		/**

		 * printing the lines after headings

		 */

		for (int i = 0; i < DIS_WIDTH; i++)
		{

			System.out.print("-");

		}

		System.out.println();

		/**

		 * printing the items in proper format

		 */

		for (Item i : Inventory.itemsList)
		{

			System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n",

                              i.getIdNumber(), i.getName(), i.getCategory(),

                              i.getQuantity(), i.getPrice());

		}

		/**

		 * printing the lines at the end

		 */

		for (int i = 0; i < DIS_WIDTH; i++)
		{

			System.out.print("-");

		}

		System.out.println();

	}

	/**

	 * method to print all the items where quantity is under the given level

	 */

	static void displayItems(int quantity)
	{

		/**

		 * printing the lines before headings

		 */

		for (int i = 0; i < DIS_WIDTH; i++)
		{

			System.out.print("-");

		}

		System.out.println();

		/**

		 * printing the headings

		 */

		System.out.printf("| %10s | %20s | %20s | %10s | %10s |\n", "ID #",

						  "NAME", "CATEGORY", "QUANTITY", "PRICE");

		/**

		 * printing the lines after headings

		 */

		for (int i = 0; i < DIS_WIDTH; i++)
		{

			System.out.print("-");

		}

		System.out.println();

		/**

		 * printing the items in proper format

		 */

		for (Item i : Inventory.itemsList)
		{

			if (i.getQuantity() <= quantity)
			{

				System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n",

								  i.getIdNumber(), i.getName(), i.getCategory(),

								  i.getQuantity(), i.getPrice());

			}

		}

		/**

		 * printing the lines at the end

		 */

		for (int i = 0; i < DIS_WIDTH; i++)
		{

			System.out.print("-");

		}

		System.out.println();

	}

}
