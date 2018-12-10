/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

/**
 *
 * @author  ZAIN ASIM
 */
public class Message {
    private String message;
    private String user;
    
    Message(String m,String u)
    {
        message=m;
        user=u;
    }

    Message() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getmessage()
    {
        return message;
    }
    public String getusername()
    {
        return user;
    }
    
    public void set(String m,String u)
    {
        message=m;
        user=u;
    }
    
    
//    
//    public void setmessage(Strin)
//    {
//        return message;
//    }
//    public String getusername()
//    {
//        return user;
//    }
    
}
