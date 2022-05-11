
package kuis_ups.db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kuis_ups.model.UPS;


public class DBHandler {
    public final Connection conn;

    public DBHandler(String driver) {
        this.conn = DBHelper.getConnection(driver);
    }
    public void addUPS(UPS u){
        String insertTv = "INSERT INTO `ups`(`kode`, `merk`, `harga`, `tgl_beli`)"
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertTv);
            stmtInsert.setString(1, u.getKode());
            stmtInsert.setString(2, u.getMerk());
            stmtInsert.setString(3, u.getTgl_beli());
            stmtInsert.setString(4, u.getHarga());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
