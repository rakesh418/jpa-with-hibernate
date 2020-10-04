package com.lex418.webservice.restservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users= new ArrayList<>();

    private static int count=3;

    static{
        users.add(new User(1,"Adam",new Date()));
        users.add(new User(2,"Eve",new Date()));
        users.add(new User(3,"jack",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        user.setId(++count);
        users.add(user);
        return user;
    }

    public User findOne(int id ){
        for(User user: users ) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User removeUser(int id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId()==id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
