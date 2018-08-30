# Tutorial application how to send and receive messages from a Active MQ.

Both ways work or implicitly declared Producer (Spring Frameworks dependency injection does the declaration),
as well as explicitly declared Producer (declared by a programmer from scratch).

##### Before app start up Apache Active MQ instance ([download link](http://activemq.apache.org/download.html)):
````
λ cd C:\temp\apache-activemq-5.15.5\bin
λ activemq.bat start
````

###### App endpoints:
* look how a queue is created, filled with pending messages, etc. at [http://localhost:8161/admin/queues.jsp](http://localhost:8161/admin/queues.jsp)
* send with a implicitly declared Producer [http://localhost:8080/send/](http://localhost:8080/send/sample-message)
* send with a explicitly declared Producer [http://localhost:8080/send/explicit/](http://localhost:8080/send/explicit/sample-message)