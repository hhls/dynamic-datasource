package com.hhls.pojo;


import com.hhls.dbRouting.BaseDomain;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public class User extends BaseDomain {

    private Integer id;

    private String userName;

    private String password;

    private Integer age;


    public User() {
    }

    public User(Integer id, String userName, String password, Integer age) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
    }

    public static UserBuilder builder() {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.user = new User();
        return userBuilder;
    }

    public static UserBuilder builder(User user) {
        UserBuilder userBuilder = new UserBuilder();
        userBuilder.user = user == null ? new User() : user;
        return userBuilder;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{id='" + id + "'" +
            ", userName='" + userName + "'" +
            ", password='" + password + "'" +
            ", age='" + age + "'" +
            "}";


    }

    public static class UserBuilder {

        private User user;

        public UserBuilder id(Integer id) {
            user.id = id;
            return this;
        }

        public UserBuilder userName(String userName) {
            user.userName = userName;
            return this;
        }

        public UserBuilder password(String password) {
            user.password = password;
            return this;
        }

        public UserBuilder age(Integer age) {
            user.age = age;
            return this;
        }

        public User build() {
            return this.user;
        }

    }

}