# The McShane Library Project

This project will be used for me to explore some new technologies and hopefully build a cool site for my family (and in my dreams, other families) to use.

## Stack and Technologies Used

* PostgresSQL Backend
* 100% groovy backend run with Spring Boot
* Built with Gradle
* Angular 2/ES6/Typescript Front End
* Twitter Bootstrap styling
* Built with Grunt, manage libs with Bower

## Features with proposed release plan

### Release 1
* Manage books within libraries
* Create users to view and manage books

### Release 2
* Create user permissions for managing books
* Create "family" structure, assign books to families
* Separate permissions to managing books system wide and for individual families

### Release 3
* Users can mark a book as read and view a list of completed books
* Users can "check-out" and "check-in" books, have a list of currently checked-out books
* Force book to be checked out before it can be marked as read

### Release 4
* "Parent" users that can administrate children's activity
* Parent signoff on books read
* Family sharing books - force book to be "owned" or "borrowed" by family before it can be marked read

### Release 5
* More advanced visualizations of books read - calendar, time/pages scatter plot (d3.js)
* Implement point/reward system where a parent user can give points for books and provide rewards for a certain number of points.

### Release 6
* Parent administrative features - recommend book, mark book read without checkout, remove book from child's view
* Book review feature, parents can allow reviews to be shared across families
* Book rating feature

### Release 7
* User profile page and notifications of books read, new rewards added, family activity

### Release 8
* "Compare" user feature, find who likes similar books
* Automatic book recommendation based on ratings, books read, and other users in system