package entity;

import java.io.Serializable;
import java.util.Date;

public class WSStudent implements Serializable {
  
  private Integer id;
  private Integer age;
  private Double height;
  private Date birthday;
  private String name;
  private String nameSession;
  
  public WSStudent() {
  }
  
  public WSStudent(Integer id, Integer age, Double height, Date birthday, String name) {
    super();
    this.id = id;
    this.age = age;
    this.height = height;
    this.birthday = birthday;
    this.name = name;
  }
  
  public String getNameSession() {
    return nameSession;
  }
  
  public void setNameSession(String nameSession) {
    this.nameSession = nameSession;
  }
  
  public WSStudent(Integer id, Integer age, Double height, Date birthday, String name, String nameSession) {
    super();
    this.id = id;
    this.age = age;
    this.height = height;
    this.birthday = birthday;
    this.name = name;
    this.nameSession = nameSession;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  public Double getHeight() {
    return height;
  }
  
  public void setHeight(Double height) {
    this.height = height;
  }
  
  public Date getBirthday() {
    return birthday;
  }
  
  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
}
