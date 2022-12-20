package backendtest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
class Product
{
    // properties
    private String pname;
    private int qty;
    private double price;
    private double totalPrice;

    // constructor
    Product(String name, int qty, double price, double totalPrice)
    {

        this.pname = name;
        this.qty = qty;
        this.price = price;
        this.totalPrice = totalPrice;
    }
    // getter methods
    public String getName()
    {
        return pname;
    }
    public int getQty()
    {
        return qty;
    }
    public double getPrice()
    {
        return price;
    }
    public double getTotalPrice()
    {
        return totalPrice;
    }
    //displayFormat
    public static void displayFormat()
    {
        System.out.format("--------------------------------------------------------------------");
        System.out.print("\nNAME\t\tQUANTITY\t\tPRICE\t\t\t\tTOTAL PRICE\n");
        System.out.format("--------------------------------------------------------------------\n");
    }

    // display
    public void display()
    {
        System.out.format("%-9s %5d$       %9.2f$         %14.2f$\n", pname, qty, price, totalPrice);
    }
}
public class CashReceipt
{
    public static void main(String[] args)
    {
        // variables
        String productName = null;
        int quantity = 0;
        double price = 0.0;
        double totalPrice = 0.0;
        double overAllPrice = 0.0;
        double VAT;
        char choice = '\0';
        System.out.println("\t\t\t\t--------------------CASH RECEIPT-----------------");
        System.out.println("\t\t\t\t\t "+"  "+"       SUPERMARKET by Oleg Ritchik");
        System.out.println("\t\t\t\t\t            2023, Happy New Year");
        System.out.println("CASHIER: №999 "+"\t\t\t\t\t\t\t                 CONTACT: +375(29)777-77-77");
        //format of date and time
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        //prints current date and time
        System.out.println("DATE: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String customername=scan.nextLine();
        //create Scanner class object
        //creating an ArrayList to store the product
        List<Product> product = new ArrayList<>();
        do
        {
            // read input values
            System.out.println("Enter the product details: ");
            System.out.print("Product Name: ");
            productName = scan.nextLine();
            System.out.print("Quantity: ");
            quantity = scan.nextInt();
            System.out.print("Price (per unit): ");
            price = scan.nextDouble();
            //calculate total price for a particular product
            totalPrice = price * quantity;
            //calculates overall price
            overAllPrice = overAllPrice + totalPrice;
            //creates Product class object and add it to the List
            product.add( new Product(productName, quantity, price, totalPrice) );
            // ask for continue shopping?
            System.out.print("Want to add more items? (y or n): ");
            //reads a character Y or N
            choice = scan.next().charAt(0);
            //read remaining characters, don't store (no use)
            scan.nextLine();
        }
        while (choice == 'y' || choice == 'Y');
        //display all product with its properties
        Product.displayFormat();
        for (Product p : product)
        {
            p.display();
        }
        //price calculation
        System.out.println("\n\n\n\nTOTAL AMOUNT " + "\t\t\t\t\t\t\t\t\t\t"  +overAllPrice + "$");
        //calculating tax
        VAT=overAllPrice*17/100;
        System.out.println("VAT 17% " + "\t\t\t\t\t\t\t\t\t\t\t" +VAT + "$");
        //calculating amount to be paid by buyer
        System.out.println("TOTAL " + "\t\t\t\t\t\t\t\t\t\t\t\t" +(overAllPrice+VAT + "$"));
        System.out.println("\t\t\t----------------Thank you for shopping!-----------------");
        // close Scanner
        scan.close();
    }
}
