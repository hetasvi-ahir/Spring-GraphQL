<div >
      <h1>Spring GraphQL</h1>
Here are some projects under the concept of Reactive Programming. 
</div>

# Tech Used

![Springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot) ![Mysql](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white) 

# Guide for the usage  
* Change the database configuration according to your database
* Mutation and Queries for graphql
    * Create Book
      *  ```
         mutation{
          createBook(book:{
              title :"Tejas"
              description:"Life "
              author : 3
              price : 455
              pages : 2021
      
          })
          {
              id
              title
              pages
              author{
                  id
                  name
              }
          }}

    * Get book by ID
        ```
        query{
          getBook(bookId:4){
            id
            title
        }}
        ```
      
