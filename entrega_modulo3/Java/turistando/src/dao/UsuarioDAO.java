package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Usuario;

public class UsuarioDAO {

    // create
    public void create(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nomeUsuario, emailUsuario, senhaUsuario) VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
        }
    }

    // read
    public List<Usuario> read() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String sql = "SELECT * FROM Usuario";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rset.getInt("IDusuario"));
                usuario.setNome(rset.getString("nomeUsuario"));
                usuario.setEmail(rset.getString("emailUsuario"));
                usuario.setSenha(rset.getString("senhaUsuario"));
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }

        return usuarios;
    }

    // update
    public void update(Usuario usuario) {
        String sql = "UPDATE Usuario SET nomeUsuario = ?, emailUsuario = ?, senhaUsuario = ? WHERE IDusuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setString(3, usuario.getSenha());
            pstm.setInt(4, usuario.getId());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }

    // delete
    public void delete(int id) {
        String sql = "DELETE FROM Usuario WHERE IDusuario = ?";
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
    public Usuario readById(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE IDusuario = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                usuario = new Usuario();
                usuario.setId(rset.getInt("IDusuario"));
                usuario.setNome(rset.getString("nomeUsuario"));
                usuario.setEmail(rset.getString("emailUsuario"));
                usuario.setSenha(rset.getString("senhaUsuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }

        return usuario;
    }
}
