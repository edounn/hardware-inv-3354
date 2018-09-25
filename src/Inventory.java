/**
 @author Eddie Dounn CS3354-003
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory
{

	static ArrayList<Item> itemsList;
	static Scanner keyboard;
	static File input;

	public static void main(String[] args)
	{

		/**
		 * initializing the list
		 */

		itemsList = new ArrayList<Item>();

		/**
		 * Initializing scanner for receiving user input
		 */

		keyboard = new Scanner(System.in);

		/**
		 * Reading data from file
		 */

		input = new File("database.txt");

		try
		{

			readDataFromFile();

			/**
			 * displaying the menu continuosly until the user decides to quit
		     */

		displayMenu();

		}
		catch (FileNotFoundException e)
		{

			System.out.println("File not found");

		}
		catch (Exception e)
		{

			System.out.println(e.getMessage());

		}

	}

	/**
	 * method to display the menu and call other methods upon user selection
	 * @throws FileNotFoundException - if file not found (while saving)
	 */

	//static void inputMenu() throws FileNotFoundException

	static void displayMenu() throws FileNotFoundException
	{

		System.out.println("1 | Show all existing items in stock and their"

						   + " quantities");

		System.out.println("2 | Add a new quantity of a specific item to "

						   + "the stock");

		System.out.println("3 | Remove a certain quantity of a specific "

						   + "item type");

		System.out.println("4 | Search for an item");

		System.out.println("5 | Show a list of all items below a certain"

						   + " quantity");

		System.out.println("6 | Save Changes & Exit");

		System.out.print("___________________________________\n");
		System.out.print("Choose 1-6:");

		int choice = Integer.parseInt(keyboard.nextLine());

		switch (choice)
		{

            case 1:

				/***
				 * displaying all items
				 */

				Menu.displayItems();

				break;

            case 2:

				/***

				 * Adding a new quantity of a specific item

				 */

				Inventory.addQuantity();

				break;

            case 3:

				/***

				 * removing some quantity of a specific item

				 */

				Inventory.removeQuantity();

				break;

            case 4:

				/***

				 * Searching for a specific item

				 */

				Inventory.searchItem();

				break;

            case 5:

				/***

				 * items below a certain quantity

				 */

				Inventory.itemsBelowQuantity();

				break;

            case 6:

				/***

				 * save to file and exit

				 */

				Inventory.saveToFile();




				System.exit(0);

				//break;

            default:System.out.println("Invalid choice");

				break;

		}

		/**

		 * Calling the method again, to display menu continuosly

		 */

		displayMenu();

	}











	/**

	 * method to read data from the input file

	 *

	 * @throws FileNotFoundException

	 *             - if file not found

	 */

	static void readDataFromFile() throws FileNotFoundException
	{

		/**

		 * initializing file scanner and reading line by line

		 */

		Scanner scanner = new Scanner(input);

		while (scanner.hasNext())
		{

			String line = scanner.nextLine();

			/**

			 * Splitting the line by ~ sign

			 */

			String[] fields = line.split("~");

			String id = fields[0].trim();

			String name = fields[1].trim();

			String category = fields[2].trim();

			int quantity = Integer.parseInt(fields[3].trim());

			float cost = Float.parseFloat(fields[4].trim());

			/**
			 * Creating an item with the extracted data
			 */

			Item item = new Item(id, name, category, quantity, cost);

			/**
			 * Adding to the array list
			 */

			itemsList.add(item);

		}

	}

	/**
	 * method to add a new quantity of a specific item to the stock.
	 */

	public static void addQuantity()
	{

		System.out.println("Enter item ID: ");

		String id = keyboard.nextLine();

		int indexOfItem = getItem(id);

		if (indexOfItem == -1)
		{

			System.out.println("specified item not found");

			return;

		}

		System.out.println("Enter quantity to be added: ");

		int quantity = Integer.parseInt(keyboard.nextLine());

		if (quantity <= 0)
		{

			System.out.println("Invalid quantity");

			return;

		}

		/**
		 * updating the quantity if everything is valid
		 */

		int originalQuantity = itemsList.get(indexOfItem).getQuantity();

		itemsList.get(indexOfItem).setQuantity(originalQuantity + quantity);

		System.out.println("Quantity added successfully");

	}

	/**
	 * method to remove a certain quantity of a specific item type.
	 */

	public static void removeQuantity()
	{

		System.out.println("Enter item ID: ");

		String id = keyboard.nextLine();

		int indexOfItem = getItem(id);

		if (indexOfItem == -1)
		{

			System.out.println("specified item not found");

			return;

		}

		System.out.println("Enter quantity to be removed: ");

		int quantityTobeRemoved = Integer.parseInt(keyboard.nextLine());

		if (quantityTobeRemoved <= 0)
		{

			System.out.println("Invalid quantity");

			return;

		}

		/**
		 * updating the quantity if everything is valid
		 */

		int originalQuantity = itemsList.get(indexOfItem).getQuantity();

		if (originalQuantity < quantityTobeRemoved)
		{

			/**
			 * if user try to remove more than what's left, display error
			 * message
			 */

			System.out.println("Not enough stock!");

			return;

		}

		itemsList.get(indexOfItem).setQuantity(

			originalQuantity - quantityTobeRemoved);

		System.out.println("Quantity removed successfully");

	}

	/**
	 * method to get the index of an item (on the list) specifying its ID
	 *
	 * @param ID
	 *            - String Id of the item
	 * @return the index of specific item if found, -1 if not found
	 */

	static int getItem(String ID)
	{

		for (int i = 0; i < itemsList.size(); i++)
		{

			if (itemsList.get(i).getIdNumber().equalsIgnoreCase(ID))
			{

				return i;

			}

		}

		return -1;

	}

	/**
	 * method to search for an item, by its name
	 */

	public static void searchItem()
	{

		System.out.println("Enter name of the item, or part of the name");

		String name = keyboard.nextLine();

		System.out.println("Search Results...");

		int counter = 0;

		for (Item i : itemsList)
		{

			if (i.getName().contains(name))
			{

				System.out.printf("| %10s | %20s | %20s | %10d | %10.2f |\n",

								  i.getIdNumber(), i.getName(), i.getCategory(),

								  i.getQuantity(), i.getPrice());

				counter++;

			}

		}

		if (counter == 0)
		{

			System.out.println("No match found!");

		}

	}

	/**
	 * method to display items below a certain quantity
	 */

	static void itemsBelowQuantity()
	{

		System.out.println("Enter quantity level: ");

		int quantity = Integer.parseInt(keyboard.nextLine());

		if (quantity < 0)
		{

			System.out.println("Invalid quantity");

		}
		else
		{

			/**
			 * Calling the overloaded method to display all items below a
			 * certain quantity
			 */

			Menu.displayItems(quantity);

		}

	}

	/**
	 * method to save the items to the file after user decides to quit
	 */

	static void saveToFile() throws FileNotFoundException
	{

		PrintWriter writer=new PrintWriter(input);

		for (Item i:itemsList)
		{

			writer.append(i.toString() + "\n");

		}



		System.out.println("\n*Database updated\n");

		writer.close();

		System.exit(0);



	}

}
