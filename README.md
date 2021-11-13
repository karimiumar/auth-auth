1) Start the application
2) Open Console fire following commands:
   1) curl -i http://localhost:8080/bars/1 --> should result in HTTP/1.1 401 **"Unauthorized"** 
   2) curl -i http://localhost:8080/foos/1 --> should result in HTTP/1.1 401 **"Unauthorized"**
   3) curl -i http://localhost:8080/ --> should result in HTTP/1.1 200 **Welcome**
   4) curl -i http://localhost:8080/home --> should result in HTTP/1.1 200 **Welcome**
   5) curl -i --user user1:user1Pass http://localhost:8080/bars/1 --> should result in HTTP/1.1 200 **com.umar.app.dto.Bar**
   6) curl -i --user user1:user1Pass http://localhost:8080/foos/1 --> should result in HTTP/1.1 200 **com.umar.app.dto.Foo**