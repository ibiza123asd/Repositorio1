/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Modelo.User;
import Modelo.UserDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Brandon
 */
@WebService(serviceName = "Servicios")
public class Servicios {

    UserDAO ud = new UserDAO();
    @WebMethod(operationName = "Listar")
    public List<User> Listar() {
        List datos = ud.listar();
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Agregar")
    public String agregar(@WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido) {

        String res =ud.add(nombre, apellido);
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "actualizar")
    public String actualizar(@WebParam(name = "id") int id, @WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname) {
       

        String res= ud.edit(id, lname, lname);
        return res;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarID")
    public User listarID(@WebParam(name = "id") int id) {
        User user =ud.listarID(id);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "elminar")
    public String elminar(@WebParam(name = "id") int id) {
        String res =ud.delete(id);
        return res;
    }
}
