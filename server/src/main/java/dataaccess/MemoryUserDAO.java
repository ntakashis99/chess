package dataaccess;

import model.UserData;

import java.util.*;

public class MemoryUserDAO implements UserDAO{

    private ArrayList<UserData> users = null;

    public MemoryUserDAO(){
        this.users = new ArrayList<>();
    }

    @Override
    public UserData getUser(UserData user) throws DataAccessException {
        for(var u:users){
            if(Objects.equals(u.username(), user.username())){
                return u;
            }
        }
        return null;
    }

    @Override
    public void deleteAllUsers() throws DataAccessException {
        this.users = new ArrayList<>();
    }


    @Override
    public void createUser(UserData user) throws DataAccessException {
        users.add(new UserData(user.username(),user.password(),user.email()));
    }
}
