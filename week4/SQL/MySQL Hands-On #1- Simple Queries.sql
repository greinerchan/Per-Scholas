/*
Jafer Alhaboubi
MySQL Hands-On #1: Simple Queries
Prerequisites:
These exercises utilize the sample database from MySqlTutorial.org (Links to an external site.). You will need to have downloaded and run the installation script before attempting these exercises.
1. Write a query to display the name, product line, and buy price of all products. The output columns should display as “Name”, “Product Line”, and “Buy Price”. The output should display the most expensive items first.
2. Write a query to display the first name, last name, and city for all customers from Germany. Columns should display as “First Name”, “Last Name”, and “City”. The output should be sorted by the customer’s last name (ascending).
3. Write a query to display each of the unique values of the status field in the orders table. The output should be sorted alphabetically increasing. Hint: the output should show exactly 6 rows.
4. Select all fields from the payments table for payments made on or after January 1, 2005. Output should be sorted by increasing payment date.
5. Write a query to display all Last Name, First Name, Email and Job Title of all employees working out of the San Francisco office. Output should be sorted by last name.
6. Write a query to display the Name, Product Line, Scale, and Vendor of all of the car products – both classic and vintage. The output should display all vintage cars first (sorted alphabetically by name), and all classic cars last (also sorted alphabetically by name).
*/



select productName as Name, productLine as 'Product Line' , buyPrice as 'Buy Price' from products order by buyPrice desc;

select contactFirstName as 'First Name', contactLastName as 'Last Name', city as City from customers where country='Germany' order by contactLastName;

select distinct status from orders order by status;

select * from payments where paymentDate >'2005-01-01' order by paymentDate;

select firstName as 'First Name', lastName as 'Last Name', email as Email, jobTitle as 'Job Title' from employees where officeCode=1 order by lastName;
select e.firstName as 'First Name', e.lastName as 'Last Name', e.email as Email, e.jobTitle as 'Job Title' from employees as e LEFT JOIN offices as o ON e.officeCode = o.officeCode where o.city='San Francisco' order by e.lastName;

select productName as Name, productLine as 'Product Line', productScale as Scale, productVendor as Vendor from products where productLine like 'Classic%' or productLine like 'Vintage%' order by productName; 
 
