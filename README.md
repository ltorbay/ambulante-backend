# ambulante-backend
Backend project for L'ambulante

## Getting started
### Database
- A Postgresql instance can be used with docker :  
```
docker build -f docker/postgres.Dockerfile -t <image_tag> .
&& docker run -d -p 5432:5432 --name ambulante-db -v ambulante-db:/var/lib/postgresql/data --restart unless-stopped <image_tag> 
```
- Alternatively, the database can be hosted using a local postgresql instance, with the same options as the `application.yml` file

### Running the application
A jdk 11+ is needed, and maven. the server can be starter on port 8080 with the following : 
```./mvnw spring-boot:run```
