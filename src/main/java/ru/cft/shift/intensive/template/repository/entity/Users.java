package ru.cft.shift.intensive.template.repository.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Table("users")
public class Users {
  @PrimaryKey
  private String username;
  @Column("full_name")
  private String fullName;
  @Column
  private String password;
  @Column
  private Set<String> roles = new HashSet<>();

  public Users() {
  }

  public Users(String username, String login, String password, String... roles) {
    this.username = username;
    this.fullName = login;
    this.password = password;
    if (roles != null) {
      Arrays.stream(roles).forEach(role -> this.roles.add(role));
    }
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRoles() {
    // if (roles == null) return Collections.<String>emptySet();
    return roles;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String login) {
    this.fullName = login;
  }

  public void setRoles(Set<String> roles) {
    this.roles = roles;
  }
}
