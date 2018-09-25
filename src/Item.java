/**
 @author Eddie Dounn CS3354-003
 */


import java.util.ArrayList;

public class Item {

	/**

	 * constants for storing different possible categories

	 */

	private static final String DOORnWINDOW = "Door&Window",

	CABINETnFURNITURE = "Cabinet&Furniture", FASTENERS = "Fasteners",

	STRUCTURAL = "Structural", OTHER = "Other";

	/**

	 * attributes of an item

	 */

	private String IdNumber;

	private String name;

	private String category;

	private float price;

	private int quantity;

	/**

	 * Constructor

	 */

	public Item(String idNumber, String name, String category, int quantity,

				float price) {

		IdNumber = idNumber;

		this.name = name;

		setCategory(category);

		this.quantity = quantity;

		this.price = price;

	}

	/**

	 * accessors and mutators

	 */

	public String getIdNumber() {

		return IdNumber;

	}

	public void setIdNumber(String idNumber) {

		IdNumber = idNumber;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getCategory() {

		return category;

	}

	public int getQuantity() {

		return quantity;

	}

	public void setQuantity(int quantity) {

		this.quantity = quantity;

	}

	public void setCategory(String category) {

		/**

		 * Validating category before assigning

		 */

		if (category.equalsIgnoreCase(DOORnWINDOW)) {

			this.category = DOORnWINDOW;

		} else if (category.equalsIgnoreCase(CABINETnFURNITURE)) {

			this.category = CABINETnFURNITURE;

		} else if (category.equalsIgnoreCase(FASTENERS)) {

			this.category = FASTENERS;

		} else if (category.equalsIgnoreCase(STRUCTURAL)) {

			this.category = STRUCTURAL;

		} else {

			/** other than all these categories, using default category, "Other" */

			this.category = OTHER;

		}

	}

	public float getPrice() {

		return price;

	}

	public void setPrice(float price) {

		this.price = price;

	}

	/**

	 * a method which will return a single string containing all details

	 * seperated by a ~ sign (helpful for saving to file)

	 */

	public String toString() {

		return IdNumber + "~" + name + "~" + category + "~" + quantity + "~"

			+ String.format("%.2f", price);

	}

}
