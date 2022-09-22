# FinalProject

- [Perfect Date](#finalproject)
  - [Description](#description)
  - [Meet the Team] (#meet-the-team)
  - [Topics](#topics)
  - [How to Run](#how-to-run)
  - [Technologies](#technologies)
  - [Concepts](#concepts)
  - [Challenges and Lessons We Learned](#challenges-and-lessons-we-learned)
  - [Rest Endpoints](#rest-endpoints)
  - [UML Diagram](#uml-diagram)


## Description

This is the completed full-stack project that tracks ghost tours and reviews. With full CRUD functionality  tours can be posted by users and then reviewed. Reviews can have comments added. Currently functionality for reviews and comments are on the backend only. Will update with new front-end updates. 


## Meet The Team

- Jordy
- Diego
- Steph


## Topics
-   Creating a SQL database and subsequent tables
-   Configuring a JPA project
-   Configuring REST Api's
- Using Postman to test backend projects
-   Mapping Entities to SQL tables
-   Creating JUnit tests to ensure JPA mappings are correct
-   Integrating a Spring MVC project with a JPA project
-   Performing basic CRUD operations
-   Gradle dependency management



- [Back to Top](#finalproject)

##  How to Run

- [Ghost Tour URL](http://54.176.46.29:8080/GhostTour)

- [Back to Top](#finalproject)

# Technologies

-   Angular
-   JavaScript
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

-   Request Mapping
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

Postman routes:

|   HTTP Verb Purpose |URI                                                             |Request Body              |Response Body                 | Operation
|---------------------|----------------------------------------------------------------|--------------------------|------------------------------|-----------
|POST                 |`/api/datenight`                                                  |JSON for new datenight    |Create datenight              |Create
|POST                 |`/api/datenight/{datenightId}/reviews`                              |JSON for new review       |Create review by datenight id |Create
|POST                 |`/api/datenightDiscussionBoard/{datenightDiscussionBoardId}/comments`  |JSON for new comment     |Create comment for review      |Create
|GET                  |`/api/datenights`                                                 |                          |List of datenights             |Read
|GET                  |`/api/reviews`                                                    |                          |List of reviews               |Read
|GET                  |`/api/datenightDiscussionBoard`                                    |                          |List of comments              |Read
|GET                  |`/api/review/{id}`                                                |                          |View review by id             |Read
|PUT                  |`/api/datenights/{datenightId}`                                    |JSON to update datenight  |Update datenight              |Update      
|PUT                  |`/api/reviews/{reviewId}`                                          |JSON to update review     |Update review                |Update
|PUT                  |`/api/comments/{commentId}`                                        |JSON to update comments   |Update comment               |Update
|DELETE               |`/api/datenights/{id}`                                            |                           |Delete datenight              |Delete
|DELETE               |`/api/reviews/{id}`                                               |                           |Delete review                |Delete
|DELETE               |`/api/comments/{id}`                                              |                           |Delete comment               |Delete



## Challenges and Lessons We Learned

Jordy - 

Diego - 

Steph - 


- [Back to Top](#finalproject)

## UML diagram


[![](https://mermaid.ink/img/pako:eNqtV1FvqjAU_isNz9sf2JsbzJE75424u9zEpKm0YhOgptQtXvW_37ZgV6Ao6HzBtt85Pd93Tk9h78UME-_BI9ynKOEoW-TA_N6jYAYOh_t7dgAj358FUQQewMJjOQGCAflYeMBtsAez4E8YfNj4DOW7hdeF90fzAL6F45d5f5uPMHp5DaP5sF30JtAPo6f3KAqnb_BxOpr5_X08vk7Hw9DwaTqZBG8X4qwUq-yk4OFcRjd6heFkNA7atjXpLfkGJKBhdbDTAF9GEXySw_F09revm7rRUfk8gJoTZW2q51ws3TV3nve1KW576ldeuhx6JRuApp3BDi6WMyyVr-kwHUD7GO_tGQBoLgDF4PcvaYq20jAhOeFIEFyPC4BCcJonYEV5IWCOMuJcTtG5VZIhmjpXtgXhnWYbVBRfjGPnIs1QQuCWu_0uKZPtb7PeOVc5Sxs7LpmcQjkgOVqmpLEjlro8M54hof9CtoJLysW6LSnCmJOigFLaZy1tOa5renR0ievTs2ZcALkkeTm5xizLSC46GXHySckXVDPtGFR6DBk1aG6vQFqTnCZrYaDfU2eo21Xaao-31mtHeSg_FeNTrOWww02MNoKy3Fo7yqi_h6YX3hpv_RAcLWm6uvH-pkyUBrFcTRjfGbg1YeOPrnB-mHPvs-2TIua0mZchFdvrmNZOScyJIuI4JhZIN8HtBmvKzvaCYkE_SU3XcmDuJkvTi3R6p7xK3-kCbuxxOWeV8PJBiGhNx1TsgAMsvbSn_9FNLSZ93V4bUNXbiu8FKxvLlCWNfF1UtPIrqLAviHr22pwa5WoxM5f_tQw1iVYLb7KsAEPZKoC2PwHUwAk4bWADTVj1IjvznnJjmp38b6Deu1uewCUW0yLeFoXsPnDJEMc1YzfESOTdeRmRcVMsP9K0HAtPrIlsg556icNkhbap3ltBy1YSYCoY9x5WKC3InVYr2uWxmShR1feemSXaalJ-DuqvwuN_6QMSXQ)](https://mermaid.live/edit#pako:eNqtV1FvqjAU_isNz9sf2JsbzJE75424u9zEpKm0YhOgptQtXvW_37ZgV6Ao6HzBtt85Pd93Tk9h78UME-_BI9ynKOEoW-TA_N6jYAYOh_t7dgAj358FUQQewMJjOQGCAflYeMBtsAez4E8YfNj4DOW7hdeF90fzAL6F45d5f5uPMHp5DaP5sF30JtAPo6f3KAqnb_BxOpr5_X08vk7Hw9DwaTqZBG8X4qwUq-yk4OFcRjd6heFkNA7atjXpLfkGJKBhdbDTAF9GEXySw_F09revm7rRUfk8gJoTZW2q51ws3TV3nve1KW576ldeuhx6JRuApp3BDi6WMyyVr-kwHUD7GO_tGQBoLgDF4PcvaYq20jAhOeFIEFyPC4BCcJonYEV5IWCOMuJcTtG5VZIhmjpXtgXhnWYbVBRfjGPnIs1QQuCWu_0uKZPtb7PeOVc5Sxs7LpmcQjkgOVqmpLEjlro8M54hof9CtoJLysW6LSnCmJOigFLaZy1tOa5renR0ievTs2ZcALkkeTm5xizLSC46GXHySckXVDPtGFR6DBk1aG6vQFqTnCZrYaDfU2eo21Xaao-31mtHeSg_FeNTrOWww02MNoKy3Fo7yqi_h6YX3hpv_RAcLWm6uvH-pkyUBrFcTRjfGbg1YeOPrnB-mHPvs-2TIua0mZchFdvrmNZOScyJIuI4JhZIN8HtBmvKzvaCYkE_SU3XcmDuJkvTi3R6p7xK3-kCbuxxOWeV8PJBiGhNx1TsgAMsvbSn_9FNLSZ93V4bUNXbiu8FKxvLlCWNfF1UtPIrqLAviHr22pwa5WoxM5f_tQw1iVYLb7KsAEPZKoC2PwHUwAk4bWADTVj1IjvznnJjmp38b6Deu1uewCUW0yLeFoXsPnDJEMc1YzfESOTdeRmRcVMsP9K0HAtPrIlsg556icNkhbap3ltBy1YSYCoY9x5WKC3InVYr2uWxmShR1feemSXaalJ-DuqvwuN_6QMSXQ)

- [Back to Top](#finalproject)