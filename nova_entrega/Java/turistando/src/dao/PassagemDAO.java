package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Passagem;

public class PassagemDAO {
    // create
    public void create(Passagem passagem) {
        String sql = "INSERT INTO Passagem (destinoPassagem, precoPassagem) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, passagem.getDestino());
            pstm.setDouble(2, passagem.getPreco());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }

    // read
    public List<Passagem> read() {
        List<Passagem> passagens = new ArrayList<Passagem>();
        String sql = "SELECT * FROM Passagem";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Passagem passagem = new Passagem();
                passagem.setId(rset.getInt("IDPassagem"));
                passagem.setDestino(rset.getString("destinoPassagem"));
                passagem.setPreco(rset.getDouble("precoPassagem"));
                passagens.add(passagem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }

        return passagens;
    }

    // update
    public void update(Passagem passagem) {
        String sql = "UPDATE Passagem SET destinoPassagem = ?, precoPassagem = ? WHERE IDPassagem = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, passagem.getDestino());
            pstm.setDouble(2, passagem.getPreco());
            pstm.setInt(3, passagem.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }

    // delete
    public void delete(int id) {
        String sql = "DELETE FROM Passagem WHERE IDPassagem = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }

    // readById
    public Passagem readById(int id) {
        Passagem passagem = null;
        String sql = "SELECT * FROM Passagem WHERE IDPassagem = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                passagem = new Passagem();
                passagem.setId(rset.getInt("IDPassagem"));
                passagem.setDestino(rset.getString("destinoPassagem"));
                passagem.setPreco(rset.getDouble("precoPassagem"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }

        return passagem;
    }
}
