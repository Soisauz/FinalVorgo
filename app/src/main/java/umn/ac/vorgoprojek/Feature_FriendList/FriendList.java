package umn.ac.vorgoprojek.Feature_FriendList;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class FriendList {
    public String email;
    public String username;

    public FriendList(String email, String username) {
        this.email = email;
        this.username = username;
    }

    public FriendList(){

    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("username", username);
        return result;
    }
}
