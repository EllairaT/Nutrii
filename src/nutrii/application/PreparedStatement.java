package nutrii.application;

import java.sql.SQLException;

/**
 * sends sql to dbms when created, no need to compile it first
 *
 * @author Ellaira
 */
public class PreparedStatement {
    
    DBConnect dbconn;
    
    public PreparedStatement(){
        dbconn = new DBConnect();
    }
    

}
