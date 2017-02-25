# Session Fixation 

# Build

```
$ git clone https://github.com/altfatterz/simple-spring-security
$ cd simple-spring-security
$ mvn clean package
```

# Deploy the Tomcat

# Test

1. Go to `http://localhost:8080`, login with `attacker/evil`
2. Save the session id 
3. Go to `http://localhost:8080/login` again and login with `user/password`
4. Save the session id
5. Both session ids are the same
6. Configure session fixation with `http.sessionManagement().sessionFixation()` setting
