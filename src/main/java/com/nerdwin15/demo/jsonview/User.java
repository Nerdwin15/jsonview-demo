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
package com.nerdwin15.demo.jsonview;

import java.util.Date;

/**
 * A user.
 *
 * @author Michael Irwin
 */
public interface User {

  /**
   * Get the id
   * @return The id
   */
  Long getId();
  
  /**
   * Get the version
   * @return The version
   */
  Long getVersion();
  
  /**
   * Get the username
   * @return The username
   */
  String getUsername();
  
  /**
   * Get the email
   * @return The email
   */
  String getEmail();
  
  /**
   * Get the full name
   * @return The full name
   */
  String getFullName();
  
  /**
   * Get the date the user was created
   * @return The creation date
   */
  Date getDateCreated();
  
  /**
   * Get the date the user was last seen
   * @return The last seen date
   */
  Date getDateLastSeen();
}
