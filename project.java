/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Dell
 */
public class project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        User_Account user;
        user = User_Account.getUser();
        user.setName("Irtaza");
        
       // User_Account user2=new User_Account();
       // user2.setName("Khawala");
        
       // User_Account user3=new User_Account();
       // user3.setName("Jolie");
        
        
        user.makeapost("Hello World");
        
       // user2.addphoto("photo1", "this is the first photo");
        
        //user.comment(0,user2,"hello!!");
        user.showposts();
        
        
//        user2.comment(0,user,"comment by khawala on irtaza post");
//        user3.comment(0,user,"comment by Jolie on irtaza post");
        
        
//        user.addFriend(user2);
//        user.addFriend(user3);
        
       
        
//        postsgui pt = new postsgui();
//        pt.setVisible(true);
        
        
        
//        user.showposts();
       // user.showFriends();

    }
    
}
