package app;

/*
 * Represents a Person with basic personal attributes and behaviors.
 */
public class Person {

    // State variables
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String occupation;

    /*
     * Non-default constructor to initialize all Person state variables.
     */
    public Person(String firstName, String lastName, int age, String email, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.occupation = occupation;
    }

    // --- Getters and Setters (generate via Source > Generate Getters and Setters in Eclipse) ---

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    // --- Behavior methods ---

    /*
     * Introduces the person by printing their full name and occupation.
     */
    public void introduce() {
        System.out.println("Hi, my name is " + firstName + " " + lastName +
                           " and I work as a " + occupation + ".");
    }
    /*
     * Displays the person's age.
     */
    public void displayAge() {
        System.out.println(firstName + " is " + age + " years old.");
    }
    /*
     * Simulates the person sending an email.
     */
    public void sendEmail() {
        System.out.println(firstName + " is sending an email from " + email + ".");
    }

    /*
     * Simulates the person celebrating a birthday, incrementing their age.
     */
    public void celebrateBirthday() {
        age++;
        System.out.println("Happy Birthday, " + firstName + "! You are now " + age + ".");
    }

    /*
     * Main method to test the Person class.
     */
    public static void main(String[] args) {
        Person person = new Person("Vijesh", "Agarwal", 19, "vijesh@email.com", "Student");

        person.introduce();
        person.displayAge();
        person.sendEmail();
        person.celebrateBirthday();
        person.displayAge();
    }
}