package entity;

import java.io.Serializable;

public class Student implements Serializable {
  
  private Integer id;
  private Integer age;
  private Double height;
  private String birthday;
  private String name;
  
  private Session session;
  
  public Student() {
  }
  
  public Student(Integer id, Integer age, Double height, String birthday, String name) {
    super();
    this.id = id;
    this.age = age;
    this.height = height;
    this.birthday = birthday;
    this.name = name;
  }
  
  public Student(Integer id, Integer age, Double height, String birthday, String name, Session session) {
    super();
    this.id = id;
    this.age = age;
    this.height = height;
    this.birthday = birthday;
    this.name = name;
    this.session = session;
  }
  
  public Session getSession() {
    return session;
  }
  
  public void setSession(Session session) {
    this.session = session;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Double getHeight() {
    return height;
  }
  
  public void setHeight(Double height) {
    this.height = height;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  public String getBirthday() {
    return birthday;
  }
  
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }
  
}
