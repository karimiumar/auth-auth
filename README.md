1) Start the application
2) Open Console and fire the following commands:
   1) curl -i http://localhost:8080/bars/1 --> should result in HTTP/1.1 401 **"Unauthorized"** 
   2) curl -i http://localhost:8080/foos/1 --> should result in HTTP/1.1 401 **"Unauthorized"**
   3) curl -i http://localhost:8080/ --> should result in HTTP/1.1 200 **Welcome**
   4) curl -i http://localhost:8080/home --> should result in HTTP/1.1 200 **Welcome**
   5) curl -i --user user1:user1Pass http://localhost:8080/bars/1 --> should result in HTTP/1.1 200 **com.umar.app.dto.Bar**
   6) curl -i --user user1:user1Pass http://localhost:8080/foos/1 --> should result in HTTP/1.1 200 **com.umar.app.dto.Foo**
   7) curl -i --user user1:user1Pass http://localhost:8080/private/hello --> should result in HTTP/1.1 200 **["Hello","to","You","from","private"]**
   8) curl -i --user user1:user1Pass http://localhost:8080/employees --> should result in HTTP/1.1 200 **["Sara","Zara"]**
   9) curl -i http://localhost:8080/employees --> should result in HTTP/1.1 401 **"Unauthorized"**
   10) curl -i http://localhost:8080/private/hello --> should result in HTTP/1.1 401 **"Unauthorized"**
   11) curl -i http://localhost:8080/public/hello --> should result in HTTP/1.1 200 **["Hello","to","You","from","public"]**
   12) curl -i --user user1:user1Pass http://localhost:8080/public/hello --> should result in HTTP/1.1 200 **["Hello","to","You","from","public"]**
