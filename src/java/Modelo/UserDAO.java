/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brandon
 */
public class UserDAO implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    String valor;

    @Override
    public List listar() {
        List<User> datos = new ArrayList<>();
        String sql = "select id,fname,lname from user";

        try {
            con = Conexion.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt(1);
                String fname = rs.getString("fname");
                String lname = rs.getString(3);
                User user = new User(id, fname, lname);
                datos.add(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return datos;
    }

    @Override
    public User listarID(int id) {
        String sql = "select id,fname,lname from user where id=" + id;
        User user = new User();
        try {
            con = Conexion.getConection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                user.setIdUser(rs.getInt(1));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString(3));

            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return user;

    }

    @Override
    public String add(String nombre, String apellido) {
        String sql = "insert into user(fname,lname) values (?,?)";
        try {
            con = Conexion.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            int res = ps.executeUpdate();
            if (res == 1) {
                valor = "agregado";
            } else {
                valor = "no agregado";
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return valor;
    }

    @Override
    public String edit(int id, String nombre, String apellido) {
        String sql ="update user set fname =?, lname=? where id="+id;
        try {
            con = Conexion.getConection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            int res = ps.executeUpdate();
            if (res == 1) {
                valor = "actualizado";
            } else {
                valor = "no actualizado";
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return valor;
    }

    @Override
    public String delete(int id) {
        String sql ="delete from user where id=" +id;
         try {
            con = Conexion.getConection();
            ps = con.prepareStatement(sql);
            int res = ps.executeUpdate();
            if (res == 1) {
                valor = "eliminado";
            } else {
                valor = "no eliminado";
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        }
         return valor;
    }

}
