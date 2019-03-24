/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBacces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controller.LoginSampleException;
import logic.User;

/**
 *
 * @author Rumle
 */
public class UserMapper {
    private static Connection connection = DBConnector.getConnection();
    
    public static void Register(logic.User user) throws LoginSampleException{
        
    try {
            
            String SQL = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }
    
    
    
    public static User login(String email, String password) throws LoginSampleException{
        try {
            String SQL = "SELECT user_id, role FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = connection.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "user_id" );
                User user = new User( email, password, role );
                user.setId( id ); 
            return user; }
               
        } catch ( SQLException ex) {
            throw new LoginSampleException(ex.getLocalizedMessage());
        }
        throw new LoginSampleException("Could not find user");
        }
    
    public static void main(String[] args) throws LoginSampleException{
        User user = new User("Hans@hansmail.com", "hans123", "employee");
        UserMapper mapper = new UserMapper();
        mapper.Register(user);
        //System.out.println(mapper.login(user.getEmail(), user.getPassword()).toString().toString());
    }
    
    
}
