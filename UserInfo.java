//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class UserInfo {

    // Constructors
    String name;
    int age;
    String email;
    boolean isActive;

    // Setting User information
    public void setUserInfo(String name, int age, String email, boolean isActive){
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive =  isActive;
    }

    // Displaying User information
    public void displayInfo(){
        System.out.println(" ===== NEW USER ==== ");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Is Active: " + isActive + "\n");
    }

    public static void main(String[] args) {

        // Creating new users
        UserInfo usr1 = new UserInfo();
        UserInfo usr2 = new UserInfo();
        UserInfo usr3 = new UserInfo();

        usr1.setUserInfo("Ali", 18, "ali@gmail.com", true);
        usr2.setUserInfo("Ahmed", 19, "ahmed@gmail.com", true);
        usr3.setUserInfo("Khalid", 20, "khalid@gmail.com", false);

        // Displaying new users
        usr1.displayInfo();
        usr2.displayInfo();
        usr3.displayInfo();
    }
}