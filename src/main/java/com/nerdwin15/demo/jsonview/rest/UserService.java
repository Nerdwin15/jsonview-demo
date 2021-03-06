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

import com.nerdwin15.demo.jsonview.User;

/**
 * A service to work with users.
 *
 * @author Michael Irwin
 */
public interface UserService {

  /**
   * Get all users
   * @return Get all users
   */
  User[] getAllUsers();
  
  /**
   * Get a user by id
   * @param id The id of the user
   * @return The user
   */
  User getUser(Long id) throws UserNotFoundException;
}
