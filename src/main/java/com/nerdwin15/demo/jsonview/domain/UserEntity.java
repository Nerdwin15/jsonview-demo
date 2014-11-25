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
package com.nerdwin15.demo.jsonview.domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.nerdwin15.demo.jsonview.User;
import com.nerdwin15.demo.jsonview.Views;

/**
 * An entity representation of a user.
 *
 * @author Michael Irwin
 */
@Entity
@Table(name = "user")
@Access(AccessType.FIELD)
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserEntity implements User {
  
  @Id
  @XmlAttribute
  private Long id;
  
  @Version
  @XmlAttribute
  private Long version;
  
  @Column(name = "username")
  private String username;
  
  @Column(name = "email")
  @JsonView(Views.Detail.class)
  private String email;
  
  @JsonProperty("fullName")
  @JsonView(Views.Detail.class)
  @XmlElement(name = "full-name")
  @Column(name = "full_name")
  private String fullName;
  
  @JsonProperty("created")
  @XmlElement(name = "created")
  @JsonView(Views.Detail.class)
  @Column(name = "created")
  private Date dateCreated;
  
  @JsonProperty("lastSeen")
  @XmlElement(name = "last-seen")
  @JsonView(Views.Detail.class)
  @Column(name = "last_seen")
  private Date dateLastSeen;

  /**
   * {@inheritDoc}
   */
  public Long getId() {
    return id;
  }
  
  /**
   * Sets the {@code id} property.
   * @param id the value to set
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * {@inheritDoc}
   */
  public Long getVersion() {
    return version;
  }
  
  /**
   * Sets the {@code version} property.
   * @param version the value to set
   */
  public void setVersion(Long version) {
    this.version = version;
  }

  /**
   * {@inheritDoc}
   */
  public String getUsername() {
    return username;
  }
  
  /**
   * Sets the {@code username} property.
   * @param username the value to set
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * {@inheritDoc}
   */
  public String getEmail() {
    return email;
  }
  
  /**
   * Sets the {@code email} property.
   * @param email the value to set
   */
  public void setEmail(String email) {
    this.email = email;
  }  

  /**
   * {@inheritDoc}
   */
  public String getFullName() {
    return fullName;
  }
  
  /**
   * Sets the {@code fullName} property.
   * @param fullName the value to set
   */
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  /**
   * {@inheritDoc}
   */
  public Date getDateCreated() {
    return dateCreated;
  }
  
  /**
   * Sets the {@code dateCreated} property.
   * @param dateCreated the value to set
   */
  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  /**
   * {@inheritDoc}
   */
  public Date getDateLastSeen() {
    return dateLastSeen;
  }
  
  /**
   * Sets the {@code dateLastSeen} property.
   * @param dateLastSeen the value to set
   */
  public void setDateLastSeen(Date dateLastSeen) {
    this.dateLastSeen = dateLastSeen;
  }
  
}
