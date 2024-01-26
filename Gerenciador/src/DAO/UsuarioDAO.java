package DAO;
import DTO.MedicosDTO;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<MedicosDTO> lista = new ArrayList<>();
    
    public ResultSet autenticarUsuario(UsuarioDTO objusuariodto){
        conn = new Db().ConectBD();
        try {
            
            String sql = "select * from usuarios where nome_usuario = ? and senha_usuario = ? ";
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro AutenticarUsuario: "+erro.getMessage());
            return null;
            
        }       
    }
    
    public ResultSet autenticarUsuarioCpf(UsuarioDTO objusuariodto){
        conn = new Db().ConectBD();
        try {
            
            String Sql = "select * from usuarios where cpf_usuario = ? and senha_usuario = ? ";
            
            pstm = conn.prepareStatement(Sql);
            pstm.setString(1, objusuariodto.getCpf_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro AutenticarUsuarioCPF" + erro.getMessage());
            return null;
        }
    }
    
    public void cadastrarMedicos(MedicosDTO objmedicosdto){
        conn = new Db().ConectBD();
        try {
            String sql = "insert into MEDICOS (nome, idade, especialidade, sala, turno, valor) values (?,?,?,?,?,?)";
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objmedicosdto.getNome());
            pstm.setString(3, objmedicosdto.getEspecialidade());
            pstm.setDouble(6, objmedicosdto.getValor());
            pstm.setInt(4, objmedicosdto.getSala());
            pstm.setString(5, objmedicosdto.getTurno_medicos());
            pstm.setInt(2, objmedicosdto.getIdade());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro UsuarioDAO: " + erro);
        }
    }
    public void excluirMedicos(int id){
        conn = new Db().ConectBD();
        try {
            String sql = "delete from MEDICOS where id = ?";
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro UsuarioDAO: " + erro);
        }
    }
    
    public ArrayList<MedicosDTO> listarMedicos(){
        conn = new Db().ConectBD();
        try {
            String sql = "select * from MEDICOS";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                
                MedicosDTO objmedicosdto = new MedicosDTO();
                objmedicosdto.setId_medicos(rs.getInt("ID"));
                objmedicosdto.setIdade(rs.getInt("IDADE"));
                objmedicosdto.setNome(rs.getString("NOME"));
                objmedicosdto.setSala(rs.getInt("SALA"));
                objmedicosdto.setEspecialidade(rs.getString("ESPECIALIDADE"));
                objmedicosdto.setValor(rs.getDouble("VALOR"));
                objmedicosdto.setTurno_medicos(rs.getString("TURNO"));
                
                lista.add(objmedicosdto);
                
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro Listar Medicos: " + erro);
        }
        return lista;
    }
    
    public void alterarStatus(MedicosDTO objmedicosdto){
        conn = new Db().ConectBD();
        
        try {
            String sql = "update MEDICOS set nome = ?, especialidade = ?, valor = ?, sala = ?, turno = ?, idade = ? where id = ?";
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, objmedicosdto.getNome());
            pstm.setString(2, objmedicosdto.getEspecialidade());
            pstm.setDouble(3, objmedicosdto.getValor());
            pstm.setInt(4, objmedicosdto.getSala());
            pstm.setString(5, objmedicosdto.getTurno_medicos());
            pstm.setInt(6, objmedicosdto.getIdade());
            pstm.setInt(7, objmedicosdto.getId_medicos());
            
            pstm.execute();
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO Alterar Status: " + erro);
        }
    }
}
 