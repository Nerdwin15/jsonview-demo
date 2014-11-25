/*
 * File created on Nov 25, 2014 
 *
 * Copyright (c) 2014 Nerdwin15, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.nerdwin15.demo.jsonview.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.annotation.JsonView;
import com.nerdwin15.demo.jsonview.Views;

/**
 * An endpoint to get user info.
 *
 * @author Michael Irwin
 */
@Path("/users")
public class UserEndpoint {
  
  @Inject
  protected UserService userService;

  @GET
  @JsonView(Views.Summary.class)
  public Response getAllUsers() {
    return Response.ok(userService.getAllUsers()).build();
  }
  
  @GET
  @Path("/{id}")
  @JsonView(Views.Detail.class)
  public Response getUser(@PathParam("id") Long id) {
    try {
      return Response.ok(userService.getUser(id)).build();
    } catch (UserNotFoundException e) {
      return Response.status(Status.NOT_FOUND).build();
    }
  }
  
}
