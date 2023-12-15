package server.service;

import server.database.User;

import java.util.ArrayList;
import java.util.List;

public class ViewListFriendService {
    private static final ViewListFriendService viewListFriendService = new ViewListFriendService();
    private ViewListFriendService(){

    }
    public static ViewListFriendService getInstance(){
        return viewListFriendService;
    }

    public List<String> ViewListFriend(String username){
        List<String> a = new ArrayList<>();
        //todo
        return a;
    }
}
