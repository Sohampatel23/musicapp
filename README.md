
# Music Backend Application

A spring boot application to integrated with JPA repository with mapping fuctionality and valid sign up for user integrated with admin side crud operations.


## Data Flow

1. Music Main Application File
2. user and admin Controller class which is Autowired
3. user,admin,signup,song,playlist,authentication Model          class with  entities
4. all above models Service class extending Repo class
5.  Repo class extend JPA Repository 
6. Utility files for token creation ans send to mail
 

## Data Structure

List structure to show data

## Summary

Whole Project is built in spring boot application with IDE of Intellij Idea. Which contains controller class configured with model class to provide data source and Service which has actual logic to API's which can be tested on localhost of your own PC.
And also Repo class extends CrudRepository for to simplify database operations

Moreover this project is connected with live server and public IP using AWS and can be easily accessible by anyone.
