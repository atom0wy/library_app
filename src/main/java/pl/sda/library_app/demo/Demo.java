package pl.sda.library_app.demo;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A autonomous class created with a purpose of showcasing library_app and its planned features
 */

public class Demo {

    //    what to paste in MAIN:
    /*try {
        Scanner scanner = new Scanner(System.in);
        demo(scanner);
    } catch (RuntimeException e) {
        System.out.println("Demo class exception");
        e.printStackTrace();
    }*/
    //    creating LOGGER
    private static final Logger LOGGER = Logger.getLogger(Demo.class.getName());

    public static void demo(Scanner scanner) {


//        Loging in and authorising or registering a new user
        System.out.println("Welcome to demo of library_app application. " +
                "You can close the demo by pressing <0> on your keyboard at any time. \n" +
                "First, create new user: or login as an admin: \n"
                + "1 <Login> \n"
                + "2 <Register new User> \n"
                + "0 <EXIT>");
        int i = 0;
        boolean userIsAdministrator = false;
        do {
            try {
                String response = scanner.nextLine();
                switch (response) {
                    case "1":
                        LOGGER.info("Demo user choose to log in");
                        if (loginAndAuthorize(scanner)) {
                            userIsAdministrator = true;
                        }
                        i++;
                        break;
                    case "2":
                        LOGGER.info("Demo user chose to register new user");
                        register(scanner);
                        i++;
                        break;
                    case "0":
                        System.exit(0);
                    default:
                        System.out.println("Wrong number. Please choose again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (i < 1);


//        Using library
        do {
            if (userIsAdministrator) {
                System.out.println("\nWhat would you like to do next Admin?\n"
                        + "1 <Lend a book> \n"
                        + "2 <Return a book> \n"
                        + "3 <Check availability of a given book> \n"
                        + "4 <Check books in your possession> \n"
                        + "ADMIN ZONE: \n"
                        + "5 <Add a book> \n"
                        + "6 <Delete a book> \n"
                        + "0 <EXIT>");
                i = 0;
                do {
                    try {
                        String response = scanner.nextLine();
                        switch (response) {
                            case "1":
                                LOGGER.info("Admin chose to lend a book");
                                lendBook(scanner);
                                i++;
                                break;
                            case "2":
                                LOGGER.info("Admin chose to return a book");
                                returnBook(scanner);
                                i++;
                                break;
                            case "3":
                                LOGGER.info("Admin chose to check availability of a book");
                                checkAvailability(scanner);
                                i++;
                                break;
                            case "4":
                                LOGGER.info("Admin chose to check books in his possession");
                                checkBooksInPossession(scanner);
                                i++;
                                break;
                            case "5":
                                LOGGER.info("Admin chose to add a book");
                                addBook(scanner);
                                i++;
                                break;
                            case "6":
                                LOGGER.info("Admin chose to delete a book");
                                deleteBook(scanner);
                                i++;
                                break;
                            case "0":
                                System.exit(0);
                            default:
                                System.out.println("Wrong number. Please choose again.");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (i < 1);
            } else {
                System.out.println("\nWhat would you like to do next?\n"
                        + "1 <Lend a book> \n"
                        + "2 <Return a book> \n"
                        + "3 <Check availability of a given book> \n"
                        + "4 <Check books in your possession> \n"
                        + "0 <EXIT>");
                i = 0;
                do {
                    try {
                        String response = scanner.nextLine();
                        switch (response) {
                            case "1":
                                LOGGER.info("User chose to lend a book");
                                lendBook(scanner);
                                i++;
                                break;
                            case "2":
                                LOGGER.info("User chose to return a book");
                                returnBook(scanner);
                                i++;
                                break;
                            case "3":
                                LOGGER.info("User chose to check availability of a book");
                                checkAvailability(scanner);
                                i++;
                                break;
                            case "4":
                                LOGGER.info("User chose to check books in his possession");
                                checkBooksInPossession(scanner);
                                i++;
                                break;
                            case "0":
                                System.exit(0);
                            default:
                                System.out.println("Wrong number. Please choose again.");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (i < 1);
            }
        } while (true);
    }

    public static boolean loginAndAuthorize(Scanner scanner) {
        LOGGER.info("Login method runs");
        System.out.println("___LOGIN___");

        int i = 0;
        String username = "";
        do {
            try {
                System.out.println("Username:");
                username = scanner.nextLine();
                if (username.equals("")) {
                    System.out.println("Username cannot be left empty.");
                } else if (username.length() > 64) {
                    System.out.println("Username cannot be longer than 64 characters.");
                } else {
                    i++;
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid username");
            }
        } while (i < 1);

        i = 0;
        String password = "";
        do {
            try {
                System.out.println("Password:");
                password = scanner.nextLine();
                if (password.equals("")) {
                    System.out.println("Password cannot be left empty.");
                } else if (password.length() > 64) {
                    System.out.println("Password cannot be longer than 64 characters.");
                } else {
                    i++;
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid password");
            }
        } while (i < 1);

        boolean userIsAdministrator;
        userIsAdministrator = username.equals("Admin") && password.equals("Admin");

        LOGGER.info("User logged in using USERNAME: " + username
                + "\nPASSWORD: " + password
                + "\nAdministrator: " + userIsAdministrator);

        return userIsAdministrator;
    }

    public static void register(Scanner scanner) {
        LOGGER.info("Register method runs");
        System.out.println("___REGISTER___");

        int i = 0;
        String username = "";
        do {
            try {
                System.out.println("Username:");
                username = scanner.nextLine();
                if (username.equals("")) {
                    System.out.println("Username cannot be left empty.");
                } else if (username.length() > 64) {
                    System.out.println("Username cannot be longer than 64 characters.");
                } else {
                    i++;
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid username");
            }
        } while (i < 1);

        i = 0;
        String password = "";
        do {
            try {
                System.out.println("Password:");
                password = scanner.nextLine();
                if (password.equals("")) {
                    System.out.println("Password cannot be left empty.");
                } else if (password.length() > 64) {
                    System.out.println("Password cannot be longer than 64 characters.");
                } else {
                    i++;
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid password");
            }
        } while (i < 1);

        LOGGER.info("User registered using USERNAME: " + username
                + "\nPASSWORD: " + password);
    }

    public static void lendBook(Scanner scanner) {
        LOGGER.info("LendBook method runs");

        int i = 0;
        long id = 0L;
        do {
            try {
                System.out.println("Please provide id of a book you would like to lend:");
                id = scanner.nextLong();
                if (id >= 0L) {
                    i++;
                } else {
                    System.out.println("Id cannot have a negative value.");
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid book id");
            }
            scanner.nextLine();
        } while (i < 1);

//        PLACEHOLDER ASSET, DELETE AFTERWARDS!
        String bookInfoPlaceholder = "BOOK_INFO_PLACEHOLDER";
        LOGGER.info("User has lend the book of ID: " + id
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus is now: " + bookInfoPlaceholder);
    }

    public static void returnBook(Scanner scanner) {
        LOGGER.info("ReturnBook method runs");

        int i = 0;
        long id = 0L;
        do {
            try {
                System.out.println("Please provide id of a book you would like to return:");
                id = scanner.nextLong();
                if (id >= 0L) {
                    i++;
                } else {
                    System.out.println("Id cannot have a negative value.");
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid book id");
            }
            scanner.nextLine();
        } while (i < 1);

//        PLACEHOLDER ASSET, DELETE AFTERWARDS!
        String bookInfoPlaceholder = "BOOK_INFO_PLACEHOLDER";
        LOGGER.info("User has returned the book of ID: " + id
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus is now: " + bookInfoPlaceholder);
    }

    public static void checkAvailability(Scanner scanner) {
        LOGGER.info("CheckAvailability method runs");

        int i = 0;
        long id = 0L;
        do {
            try {
                System.out.println("Please provide id of a book you would like to check availability for:");
                id = scanner.nextLong();
                if (id >= 0L) {
                    i++;
                } else {
                    System.out.println("Id cannot have a negative value.");
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid book id");
            }
            scanner.nextLine();
        } while (i < 1);

//        PLACEHOLDER ASSET, DELETE AFTERWARDS!
        String bookInfoPlaceholder = "BOOK_INFO_PLACEHOLDER";
        LOGGER.info("Book of ID: " + id
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus is: " + bookInfoPlaceholder);
    }

    public static void checkBooksInPossession(Scanner scanner) {
        LOGGER.info("CheckBooksInPossession method runs");
        System.out.println("Here is a list of books in your possession:");
//        PLACEHOLDER ASSET, DELETE AFTERWARDS!
        String bookInfoPlaceholder = "BOOK_INFO_PLACEHOLDER";
        System.out.println("\nPosition number: " + 1
                + "\nBook of ID: " + bookInfoPlaceholder
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus is: " + bookInfoPlaceholder);
        System.out.println("\nPosition number: " + 2
                + "\nBook of ID: " + bookInfoPlaceholder
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus is: " + bookInfoPlaceholder);
    }

    public static void addBook(Scanner scanner) {
        LOGGER.info("AddBook method runs");

        int i = 0;
        long id = 0L;
        do {
            try {
                System.out.println("Please provide id of a book you would like to add Admin:");
                id = scanner.nextLong();
                if (id >= 0L) {
                    i++;
                } else {
                    System.out.println("Id cannot have a negative value.");
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid book id");
            }
            scanner.nextLine();
        } while (i < 1);

//        PLACEHOLDER ASSET, DELETE AFTERWARDS!
        String bookInfoPlaceholder = "BOOK_INFO_PLACEHOLDER";
        LOGGER.info("Book of ID: " + id
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus: " + bookInfoPlaceholder
                + "\nhas been added");
    }

    public static void deleteBook(Scanner scanner) {
        LOGGER.info("DeleteBook method runs");

        int i = 0;
        long id = 0L;
        do {
            try {
                System.out.println("Please provide id of a book you would like to delete Admin:");
                id = scanner.nextLong();
                if (id >= 0L) {
                    i++;
                } else {
                    System.out.println("Id cannot have a negative value.");
                }
            } catch (InputMismatchException e) {
                LOGGER.info("User provided invalid book id");
            }
            scanner.nextLine();
        } while (i < 1);

//        PLACEHOLDER ASSET, DELETE AFTERWARDS!
        String bookInfoPlaceholder = "BOOK_INFO_PLACEHOLDER";
        LOGGER.info("Book of ID: " + id
                + "\nTitle: " + bookInfoPlaceholder
                + "\nAuthor: " + bookInfoPlaceholder
                + "\nYear of release: " + bookInfoPlaceholder
                + "\nGenre: " + bookInfoPlaceholder
                + "\nStatus: " + bookInfoPlaceholder
                + "\nhas been deleted");
    }
}
