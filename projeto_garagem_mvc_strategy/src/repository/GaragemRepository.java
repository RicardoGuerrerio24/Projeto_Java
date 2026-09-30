package repository;

import model.Barco;
import model.Carro;
import model.Matricula;
import model.Mota;
import model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GaragemRepository {

    private static final String URL = "jdbc:sqlite:garagem.db";

    public GaragemRepository() {
        criarTabela();
    }

    private Connection ligar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    private void criarTabela() {

        String sql = """
                CREATE TABLE IF NOT EXISTS veiculos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    tipo TEXT NOT NULL,
                    marca TEXT NOT NULL,
                    modelo TEXT NOT NULL,
                    ano INTEGER NOT NULL,
                    peso REAL NOT NULL,
                    velocidade_maxima REAL NOT NULL,

                    matricula_terrestre TEXT,
                    matricula_maritima TEXT,
                    cor TEXT,
                    pais TEXT,
                    ano_emissao INTEGER,
                    tamanho TEXT,
                    formato TEXT,
                    tipo_veiculo TEXT,

                    numero_portas INTEGER,
                    tipo_propulsao TEXT,
                    cilindrada INTEGER
                )
                """;

        try (Connection connection = ligar();
             Statement statement = connection.createStatement()) {

            statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao criar a tabela de veículos.",
                    e
            );
        }
    }

    public void guardar(Veiculo veiculo) {

        String sql = """
                INSERT INTO veiculos (
                    tipo,
                    marca,
                    modelo,
                    ano,
                    peso,
                    velocidade_maxima,
                    matricula_terrestre,
                    matricula_maritima,
                    cor,
                    pais,
                    ano_emissao,
                    tamanho,
                    formato,
                    tipo_veiculo,
                    numero_portas,
                    tipo_propulsao,
                    cilindrada
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = ligar();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            Matricula matricula = veiculo.getMatricula();

            statement.setString(1, veiculo.getClass().getSimpleName());
            statement.setString(2, veiculo.getMarca());
            statement.setString(3, veiculo.getModelo());
            statement.setInt(4, veiculo.getAno());
            statement.setDouble(5, veiculo.getPeso());
            statement.setDouble(6, veiculo.getVelocidadeMaxima());

            statement.setString(
                    7,
                    matricula.getMatriculaTerrestre()
            );

            statement.setString(
                    8,
                    matricula.getMatriculaMaritima()
            );

            statement.setString(9, matricula.getCor());
            statement.setString(10, matricula.getPais());
            statement.setInt(11, matricula.getAnoEmissao());
            statement.setString(12, matricula.getTamanho());
            statement.setString(13, matricula.getFormato());
            statement.setString(14, matricula.getTipoVeiculo());

            if (veiculo instanceof Carro carro) {
                statement.setInt(15, carro.getNumeroPortas());
            } else {
                statement.setNull(15, Types.INTEGER);
            }

            if (veiculo instanceof Barco barco) {
                statement.setString(16, barco.getTipoPropulsao());
            } else {
                statement.setNull(16, Types.VARCHAR);
            }

            if (veiculo instanceof Mota mota) {
                statement.setInt(17, mota.getCilindrada());
            } else {
                statement.setNull(17, Types.INTEGER);
            }

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao guardar o veículo.",
                    e
            );
        }
    }

    public List<Veiculo> buscarTodos() {

        List<Veiculo> veiculos = new ArrayList<>();

        String sql = "SELECT * FROM veiculos ORDER BY id";

        try (Connection connection = ligar();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                String tipo = resultSet.getString("tipo");

                Matricula matricula;

                if ("Barco".equals(tipo)) {

                    matricula = Matricula.maritima(
                            resultSet.getString("matricula_maritima"),
                            resultSet.getString("cor"),
                            resultSet.getString("pais"),
                            resultSet.getInt("ano_emissao"),
                            resultSet.getString("tamanho"),
                            resultSet.getString("formato"),
                            resultSet.getString("tipo_veiculo")
                    );

                } else {

                    matricula = Matricula.terrestre(
                            resultSet.getString("matricula_terrestre"),
                            resultSet.getString("cor"),
                            resultSet.getString("pais"),
                            resultSet.getInt("ano_emissao"),
                            resultSet.getString("tamanho"),
                            resultSet.getString("formato"),
                            resultSet.getString("tipo_veiculo")
                    );
                }

                Veiculo veiculo = criarVeiculo(resultSet, matricula);

                veiculos.add(veiculo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao procurar os veículos.",
                    e
            );
        }

        return veiculos;
    }

    private Veiculo criarVeiculo(
            ResultSet resultSet,
            Matricula matricula) throws SQLException {

        String tipo = resultSet.getString("tipo");

        String marca = resultSet.getString("marca");
        String modelo = resultSet.getString("modelo");
        int ano = resultSet.getInt("ano");
        double peso = resultSet.getDouble("peso");
        double velocidadeMaxima =
                resultSet.getDouble("velocidade_maxima");

        switch (tipo) {

            case "Carro":
                return new Carro(
                        marca,
                        modelo,
                        ano,
                        peso,
                        velocidadeMaxima,
                        matricula,
                        resultSet.getInt("numero_portas")
                );

            case "Barco":
                return new Barco(
                        marca,
                        modelo,
                        ano,
                        peso,
                        velocidadeMaxima,
                        matricula,
                        resultSet.getString("tipo_propulsao")
                );

            case "Mota":
                return new Mota(
                        marca,
                        modelo,
                        ano,
                        peso,
                        velocidadeMaxima,
                        matricula,
                        resultSet.getInt("cilindrada")
                );

            default:
                throw new IllegalArgumentException(
                        "Tipo de veículo desconhecido: " + tipo
                );
        }
    }

    public void limpar() {

        String sql = "DELETE FROM veiculos";

        try (Connection connection = ligar();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(
                    "Erro ao limpar a garagem.",
                    e
            );
        }
    }
}