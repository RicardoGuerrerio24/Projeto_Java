package repository;

import model.*;
import java.sql.*;
import java.util.*;

public class GaragemRepository {
    private static final String URL="jdbc:sqlite:garagem.db";
    public GaragemRepository(){criarTabela();}
    private Connection ligar() throws SQLException{return DriverManager.getConnection(URL);}

    private void criarTabela(){
        String sql="CREATE TABLE IF NOT EXISTS veiculos ("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT,tipo TEXT NOT NULL,marca TEXT NOT NULL,modelo TEXT NOT NULL,"+
            "ano INTEGER NOT NULL,peso REAL NOT NULL,velocidade_maxima REAL NOT NULL,matricula_terrestre TEXT,"+
            "matricula_maritima TEXT,cor TEXT,pais TEXT,ano_emissao INTEGER,tamanho TEXT,formato TEXT,tipo_veiculo TEXT,"+
            "numero_portas INTEGER,tipo_propulsao TEXT,cilindrada INTEGER)";
        try(Connection c=ligar(); Statement s=c.createStatement()){s.execute(sql);}
        catch(SQLException e){throw new RuntimeException("Erro ao criar a tabela de veículos.",e);}
    }

    public List<Veiculo> buscarTodos(){
        List<Veiculo> lista=new ArrayList<>();
        try(Connection c=ligar(); PreparedStatement s=c.prepareStatement("SELECT * FROM veiculos ORDER BY id"); ResultSet r=s.executeQuery()){
            while(r.next()){
                String tipo=r.getString("tipo");
                Matricula m;
                if("Barco".equals(tipo)) m=Matricula.maritima(r.getString("matricula_maritima"),r.getString("cor"),r.getString("pais"),r.getInt("ano_emissao"),r.getString("tamanho"),r.getString("formato"),r.getString("tipo_veiculo"));
                else m=Matricula.terrestre(r.getString("matricula_terrestre"),r.getString("cor"),r.getString("pais"),r.getInt("ano_emissao"),r.getString("tamanho"),r.getString("formato"),r.getString("tipo_veiculo"));
                lista.add(criarVeiculo(r,m));
            }
            return lista;
        } catch(SQLException e){throw new RuntimeException("Erro ao ler os veículos da base de dados.",e);}
    }

    private Veiculo criarVeiculo(ResultSet r,Matricula m) throws SQLException{
        switch(r.getString("tipo")){
            case "Carro": return new Carro(r.getString("marca"),r.getString("modelo"),r.getInt("ano"),r.getDouble("peso"),r.getDouble("velocidade_maxima"),m,r.getInt("numero_portas"));
            case "Barco": return new Barco(r.getString("marca"),r.getString("modelo"),r.getInt("ano"),r.getDouble("peso"),r.getDouble("velocidade_maxima"),m,r.getString("tipo_propulsao"));
            case "Mota": return new Mota(r.getString("marca"),r.getString("modelo"),r.getInt("ano"),r.getDouble("peso"),r.getDouble("velocidade_maxima"),m,r.getInt("cilindrada"));
            default: throw new IllegalArgumentException("Tipo de veículo desconhecido: "+r.getString("tipo"));
        }
    }
}
