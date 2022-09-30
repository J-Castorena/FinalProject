# FinalProject


- [Perfect Date](#finalproject)
  - [Topics](#topics)
  - [How to Run](#how-to-run)
  - [Technologies](#technologies)
  - [Concepts](#concepts)
  - [Challenges and Lessons We Learned](#challenges-and-lessons-we-learned)
  - [Rest Endpoints](#rest-endpoints)
  - [UML Diagram](#uml-diagram)


## Description

This is a full-stack group project that allows users to search for date night inspiration. Unregistered users have limited navigation but can browse all the date nights or search by category. Logged in users have the ability to review date night ideas, blog about their experiences and respond to others blogs. Blogs can have comments added.


## Meet The Team

- Jordy Castorena
- Diego Escutia
- Steph Karlsen


## Topics
-   Creating a SQL database and subsequent tables
-   Configuring a JPA project
-   Configuring REST API's
-   Using Postman to test back-end functionality
-   Mapping Entities to SQL tables
-   Creating JUnit tests to ensure JPA mappings are correct
-   Integrating a Spring MVC project with a JPA project
-   Performing basic CRUD operations
-   Gradle dependency management
-   Angular front-end funcionality


- [Back to Top](#finalproject)

##  How to Run

- [Perfect Date URL](http://54.176.46.29:8080/PerfectDate/#/home)

# Technologies

-   Angular
-   JavaScript
-   Typescript
-   REST API
-   JSON
-   Postman
-   MySQL 5.7
-   Spring Web MVC Framework
-   Java Persistance API
-   JPA
-   JPQL
-   JUnit 5
-   Hibernate
-   Bootstrap 5.2
-   CSS
-   HTML 5
-   JSP
-   MySQL Workbench
-   Gradle
-   MAMP
-   Git
-   Github
-   Spring Tool Suite 4
-   macOS on Monterey

- [Back to Top](#finalproject)

# Concepts

-   Http Request Mapping
-   Get, Post, Delete, Put
-   Database extraction with Repository
-   Style Pages - Object Oriented Programming
-   Class hierarchies
-   Interfaces
-   APIE (Abstraction - Polymorphism - Inheritance - Encapsulation)
-   Implementation
-   Lists
-   Collections
-   Try/Catch Statements and Exceptions
-   Web Forms

- [Back to Top](#finalproject)

## REST Endpoints

Examples of our Postman routes:

|   HTTP Verb Purpose |URI                                              |Request Body              |Response Body                 | Operation
|---------------------|-------------------------------------------------|--------------------------|------------------------------|-----------
|POST                 |`/api/datenights`                                   |JSON for new datenight    |Create datenight              |Create
|POST                 |`/api//reviews/{datenightId}`                       |JSON for new review       |Create review by datenight id |Create
|POST                 |`/api/users/{userId}/blogs`                          |JSON for new blog       |Create blog                      |Create
|POST                 |`/api/users`                                       |JSON for user              |Create user                   |Create
|GET                  |`/api/datenights`                                  |                          |List of datenights             |Read
|GET                  |`/api/reviews/datenights/{dateNightId}`              |                          |List of reviews by Datenight   |Read
|GET                  |`/api/users/{userId}/blogs`                         |                          |List of blogs by user          |Read
|GET                  |`/api/review/datenights/{datenightId}`               |                          |View review by datenight id     |Read
|PUT                  |`/api/datenights/{datenightId}`                     |JSON to update datenight  |Update datenight              |Update      
|PUT                  |`/api/reviews/{reviewId}`                           |JSON to update review     |Update review                |Update
|PUT                  |`/api blog/{userId}`                               |JSON to update blog         |Update cblog by user id    |Update
|DELETE               |`/api/datenights/{id}`                             |                           |Delete datenight              |Delete
|DELETE               |`/api/reviews/{id}`                                |                           |Delete review                |Delete
|DELETE               |`/api/blog/{id}`                                   |                           |Delete comment               |Delete



## Challenges and Lessons We Learned

Jordy - This project was the culmination of our efforts during this BootCamp. There were various challenges throughout the sprint. My own personal challenge was populating a thread with replies to a Blog and persisting new replies. Combining JavaScript with HTML required me to do a great amount of research to make it all work. When working with others, you always have to learn to be open to diverse ideas and suggestions.

Diego - In this project,  the foundations of REST really cemented, while also improving my familiarity with MySQL Workbench. One of the requirements for the project is to have encrypted login capabilities. I developed a better understanding on how to give users authorized access to the website. Once we started the Angular side of the project, I further understood the relationship between Models, Services, and Components.

Steph - Our final group project for me was a great experience to get more practice working in a group. Relying on a group is something I have struggled with in the past but my team members made that very easy and we all worked very well together.  


## UML diagram


[![](https://mermaid.ink/img/pako:eNqtV1FvqjAU_isNz9sf2JsbzJE75424u9zEpKm0YhOgptQtXvW_37ZgV6Ao6HzBtt85Pd93Tk9h78UME-_BI9ynKOEoW-TA_N6jYAYOh_t7dgAj358FUQQewMJjOQGCAflYeMBtsAez4E8YfNj4DOW7hdeF90fzAL6F45d5f5uPMHp5DaP5sF30JtAPo6f3KAqnb_BxOpr5_X08vk7Hw9DwaTqZBG8X4qwUq-yk4OFcRjd6heFkNA7atjXpLfkGJKBhdbDTAF9GEXySw_F09revm7rRUfk8gJoTZW2q51ws3TV3nve1KW576ldeuhx6JRuApp3BDi6WMyyVr-kwHUD7GO_tGQBoLgDF4PcvaYq20jAhOeFIEFyPC4BCcJonYEV5IWCOMuJcTtG5VZIhmjpXtgXhnWYbVBRfjGPnIs1QQuCWu_0uKZPtb7PeOVc5Sxs7LpmcQjkgOVqmpLEjlro8M54hof9CtoJLysW6LSnCmJOigFLaZy1tOa5renR0ievTs2ZcALkkeTm5xizLSC46GXHySckXVDPtGFR6DBk1aG6vQFqTnCZrYaDfU2eo21Xaao-31mtHeSg_FeNTrOWww02MNoKy3Fo7yqi_h6YX3hpv_RAcLWm6uvH-pkyUBrFcTRjfGbg1YeOPrnB-mHPvs-2TIua0mZchFdvrmNZOScyJIuI4JhZIN8HtBmvKzvaCYkE_SU3XcmDuJkvTi3R6p7xK3-kCbuxxOWeV8PJBiGhNx1TsgAMsvbSn_9FNLSZ93V4bUNXbiu8FKxvLlCWNfF1UtPIrqLAviHr22pwa5WoxM5f_tQw1iVYLb7KsAEPZKoC2PwHUwAk4bWADTVj1IjvznnJjmp38b6Deu1uewCUW0yLeFoXsPnDJEMc1YzfESOTdeRmRcVMsP9K0HAtPrIlsg556icNkhbap3ltBy1YSYCoY9x5WKC3InVYr2uWxmShR1feemSXaalJ-DuqvwuN_6QMSXQ)](https://mermaid.live/edit#pako:eNqtV1FvqjAU_isNz9sf2JsbzJE75424u9zEpKm0YhOgptQtXvW_37ZgV6Ao6HzBtt85Pd93Tk9h78UME-_BI9ynKOEoW-TA_N6jYAYOh_t7dgAj358FUQQewMJjOQGCAflYeMBtsAez4E8YfNj4DOW7hdeF90fzAL6F45d5f5uPMHp5DaP5sF30JtAPo6f3KAqnb_BxOpr5_X08vk7Hw9DwaTqZBG8X4qwUq-yk4OFcRjd6heFkNA7atjXpLfkGJKBhdbDTAF9GEXySw_F09revm7rRUfk8gJoTZW2q51ws3TV3nve1KW576ldeuhx6JRuApp3BDi6WMyyVr-kwHUD7GO_tGQBoLgDF4PcvaYq20jAhOeFIEFyPC4BCcJonYEV5IWCOMuJcTtG5VZIhmjpXtgXhnWYbVBRfjGPnIs1QQuCWu_0uKZPtb7PeOVc5Sxs7LpmcQjkgOVqmpLEjlro8M54hof9CtoJLysW6LSnCmJOigFLaZy1tOa5renR0ievTs2ZcALkkeTm5xizLSC46GXHySckXVDPtGFR6DBk1aG6vQFqTnCZrYaDfU2eo21Xaao-31mtHeSg_FeNTrOWww02MNoKy3Fo7yqi_h6YX3hpv_RAcLWm6uvH-pkyUBrFcTRjfGbg1YeOPrnB-mHPvs-2TIua0mZchFdvrmNZOScyJIuI4JhZIN8HtBmvKzvaCYkE_SU3XcmDuJkvTi3R6p7xK3-kCbuxxOWeV8PJBiGhNx1TsgAMsvbSn_9FNLSZ93V4bUNXbiu8FKxvLlCWNfF1UtPIrqLAviHr22pwa5WoxM5f_tQw1iVYLb7KsAEPZKoC2PwHUwAk4bWADTVj1IjvznnJjmp38b6Deu1uewCUW0yLeFoXsPnDJEMc1YzfESOTdeRmRcVMsP9K0HAtPrIlsg556icNkhbap3ltBy1YSYCoY9x5WKC3InVYr2uWxmShR1feemSXaalJ-DuqvwuN_6QMSXQ)

- [Back to Top](#finalproject)
