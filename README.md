This project is an Expense Calculator Application built with Java Swing for the user interface (UI) and JDBC (Java Database Connectivity) for database interactions. It enables users to input and store their daily expenses and income records into a MySQL database. The application offers a simple and interactive UI where users can enter details for each expense, including the type and amount, as well as an income amount. Here’s a detailed overview of the project's features and components:

Key Features:
User Interface: The application uses Java Swing to create a graphical interface that consists of:

Labels for expense and income sections.
Text fields for entering the type and amount of expenses, as well as income.
Buttons to add records to the database and view the stored data.
Expense and Income Entry:

The user can enter an expense type (e.g., "Groceries," "Transport") and the corresponding amount.
The user can also add income to log their earnings.
Validation checks ensure that expense type and amount are not empty or zero.
Database Connectivity:

The project connects to a MySQL database named ExpenseCalculator.
Using JDBC, the application inserts expense and income records into a table called expensetb, which stores each record with columns for expense_type, expense_amount, and income_amount.
Add Record Functionality:

When the user clicks the "ADD" button, the entered data is sent to the database.
A SQL INSERT command is executed to save the record, making it accessible for later analysis.
Error Handling:

The application includes basic error handling for cases where fields are empty or non-numeric values are entered.
Database Structure:

The database ExpenseCalculator should include a table called expensetb with the following columns:
expense_type (e.g., VARCHAR for expense description)
expense_amount (e.g., INT for expense amount)
income_amount (e.g., INT for income amount)
Technical Details:
Java Swing: For building the graphical user interface.
JDBC: For managing database operations (inserting data).
MySQL Database: Stores expense and income data for persistent record-keeping.
How It Works:
UI Initialization: When the application starts, it opens a window with input fields for expense type, expense amount, and income amount.
Database Connection: The app connects to the MySQL database upon launching.
Data Entry: Users input their expenses and income, then click "ADD" to save the data.
Data Insertion: The entered data is inserted into the expensetb table if valid.
Feedback and Validation: Messages are displayed if required fields are empty or data is invalid, improving user experience and data integrity.
Future Enhancements:
Potential features for further development include:

Adding a "VIEW" button functionality to display saved records.
Calculating total expenses and income within the application.
Adding charts or graphical representations for better expense tracking.
Allowing data exports (e.g., to a CSV file) for external analysis.
This project is a practical tool for managing personal finances and can serve as a foundation for more comprehensive expense tracking systems.









