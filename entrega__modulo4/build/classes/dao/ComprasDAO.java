package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Compras;
import modelos.Passagem;
import modelos.Usuario;

public class ComprasDAO {
    
    // create
    public void create(Compras compra) {
        String sql = "INSERT INTO Compras (dataCompra, IDusuario, IDpassagem) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, compra.getDataCompra());
            pstm.setInt(2, compra.getUsuario().getId());
            pstm.setInt(3, compra.getPassagem().getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // read
    public List<Compras> read() {
        List<Compras> compras = new ArrayList<Compras>();
        String sql = "SELECT * FROM Compras";

        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rset = pstm.executeQuery()) {
            while (rset.next()) {
                Compras compra = new Compras();
                Passagem passagem = new Passagem();
                Usuario usuario = new Usuario();
                
                compra.setId(rset.getInt("IDcompra"));
                compra.setDataCompra(rset.getString("dataCompra"));

                passagem.setId(rset.getInt("IDpassagem"));
                passagem.setDestino(rset.getString("destinoPassagem"));
                passagem.setPreco(rset.getDouble("precoPassagem"));
                compra.setPassagem(passagem);
                
                usuario.setId(rset.getInt("IDusuario"));
                usuario.setNome(rset.getString("nomeUsuario"));
                usuario.setEmail(rset.getString("emailUsuario"));
                usuario.setSenha(rset.getString("senhaUsuario"));
                compra.setUsuario(usuario);
                
                compras.add(compra);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return compras;
    }
    
    // update
    public void update(Compras compra) {
        String sql = "UPDATE Compras SET dataCompra = ?, IDusuario = ?, IDpassagem = ? WHERE IDcompra = ?";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, compra.getDataCompra());
            pstm.setInt(2, compra.getUsuario().getId());
            pstm.setInt(3, compra.getPassagem().getId());
            pstm.setInt(4, compra.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete(int id) {
        String sql = "DELETE FROM Compras WHERE IDcompra = ?";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // readById
    public Compras readById(int id) {
        Compras compra = null;
        String sql = "SELECT * FROM Compras WHERE IDcompra = ?";
        try (Connection conn = ConnectionMySQL.createConnectionMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    compra = new Compras();
                    Passagem passagem = new Passagem();
                    Usuario usuario = new Usuario();

                    compra.setId(rset.getInt("IDcompra"));
                    compra.setDataCompra(rset.getString("dataCompra"));

                    passagem.setId(rset.getInt("IDpassagem"));
                    passagem.setDestino(rset.getString("destinoPassagem"));
                    passagem.setPreco(rset.getDouble("precoPassagem"));
                    compra.setPassagem(passagem);

                    usuario.setId(rset.getInt("IDusuario"));
                    usuario.setNome(rset.getString("nomeUsuario"));
                    usuario.setEmail(rset.getString("emailUsuario"));
                    usuario.setSenha(rset.getString("senhaUsuario"));
                    compra.setUsuario(usuario);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return compra;
    }
}
