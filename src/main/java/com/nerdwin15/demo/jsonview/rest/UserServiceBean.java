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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.nerdwin15.demo.jsonview.User;
import com.nerdwin15.demo.jsonview.domain.UserEntity;

/**
 * A CDI-injectable {@link UserService} that simply keeps a collection of users
 * internally.
 *
 * @author Michael Irwin
 */
@ApplicationScoped
public class UserServiceBean implements UserService {

  Map<Long, UserEntity> users = new HashMap<>();
  private Long nextId = 0L;
  
  @PostConstruct
  public void postConstruct() {
    users.put(++nextId, createUser(nextId, "mikesir", "Michael Irwin", "mikesir@vt.edu"));
    users.put(++nextId, createUser(nextId, "ceharris", "Carl Harris", "ceharris@vt.edu"));
    users.put(++nextId, createUser(nextId, "cxd", "Chris Dunavant", "cxd@vt.edu"));
    System.out.println("Users: " + users);
  }
  
  /**
   * {@inheritDoc}
   */
  public User[] getAllUsers() {
    return users.values().toArray(new User[users.size()]);
  }
  
  /**
   * {@inheritDoc}
   */
  public User getUser(Long id) throws UserNotFoundException {
    return users.get(id);
  }
  
  private synchronized UserEntity createUser(Long id, String username, 
      String fullName, String email) {
    UserEntity user = new UserEntity();
    user.setDateCreated(new Date());
    user.setDateLastSeen(new Date());
    user.setEmail(email);
    user.setFullName(fullName);
    user.setId(id);
    user.setUsername(username);
    user.setVersion(0L);
    return user;
  }
}
