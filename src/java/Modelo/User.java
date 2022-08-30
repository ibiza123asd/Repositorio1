
package Modelo;


public class User {
    private int idUser;
    private String fname;
    private String lname;

    public User() {
    }
    
    
    public User(int idUser, String fname, String lname) {
        this.idUser = idUser;
        this.fname = fname;
        this.lname = lname;
    }

    public User(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
}
