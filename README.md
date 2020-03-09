# coronavirus-tracker-spring-boot

end point: 
https://corona-boot.herokuapp.com/get
https://corona-boot.herokuapp.com/greetings

# Tutorials
* https://www.youtube.com/watch?v=8hjNG9GZGnQ
* https://www.youtube.com/watch?v=KDK5xXPJVIg


# Q&A
* https://stackoverflow.com/questions/21651185/git-merge-a-remote-branch-locally
* https://stackoverflow.com/questions/50215936/failed-to-bind-properties-under-to-com-zaxxer-hikari-hikaridatasource-spring
* https://mkyong.com/spring-boot/spring-boot-spring-data-jpa-postgresql/
* https://howtodoinjava.com/spring-boot2/h2-database-example/

# Bug tracker
1. to make a method response data as JSON use @ResponseBody
2. heroku will configure with postgres addon but add spring.jpa.hibernate.ddl-auto=create-drop this line in application.properties
3. use heroku logs -t to debug
4. don't forget to add postgres dependency 

# Dependency list
1. Web
2. thymeleaf
3. devtools
4. commons-csv
5. data-jpa
6. lombok
7. postgresql
8. h2 (optional) 
