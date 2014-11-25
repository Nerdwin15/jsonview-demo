# JsonView Demo

## Motivation

We've been wanting, for quite a while, the ability to specify that a provided endpoint produces "summary" objects, while another endpoint produces detailed objects.  Like so:

- _/users_ - return summary objects for all users
- _/users/{id}_ - return a detailed object for a specific user

## Introducing @JsonView

Jackson provides the ability to annotate a model, as well as a JAX-RS endpoint to do exactly this!  So... what's it look like?

```
public class User {
  @XmlAttribute
  private Long id;
  
  @XmlElement(name = "username")
  private String username;

  @JsonView(Views.Detail.class)  
  @XmlElement(name = "created")
  private Date dateCreated;
}
```

Then, our endpoint might look like this...

```
@Path("/users")
public class UserEndpoint {

  @GET
  @JsonView(Views.Summary.class)
  public Response getAllUsers() {
    User[] users = ... however you get your users ...;
    return Response.ok(users).build();
  }
  
  @GET
  @Path("/{id}")
  @JsonView(Views.Detail.class)
  public Response getUserDetails(@PathParam("id") Long id) {
    User user = ... get your user ...;
    return Response.ok(user).build();
  }
}
```

So... what's the Views class look like?  Pretty simple...

```
public class Views {
  public static class Detail {}
  public static class Summary {}
}
```

They're basically just marker classes that are used in the annotations.

## This project

This project is just a simple application that demonstrates this feature.  It runs using Wilfly, as all the dependencies are bundled in the container.  But, this can easily be pulled off in a Tomcat.

Check out the code and run:

```
mvn wildfly:run
```

### Example CURL Requests
If you don't have a REST client installed, you can fire off the following requests to see the results:

```
curl http://localhost:8080/jsonview-demo/api/users -H "Accept:application/json"
```

Notice that you get the summary view!

```
curl http://localhost:8080/jsonview-demo/api/users/1 -H "Accept:application/json"
```

Notice that you now get the detail view for a specific user!