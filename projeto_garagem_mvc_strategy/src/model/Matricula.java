package model;

public class Matricula {

    private String matriculaTerrestre;
    private String matriculaMaritima;

    private String cor;
    private String pais;
    private int anoEmissao;
    private String tamanho;
    private String formato;
    private String tipoVeiculo;

    private Matricula(String cor, String pais, int anoEmissao, String tamanho,
                      String formato, String tipoVeiculo) {
        this.cor = cor;
        this.pais = pais;
        this.anoEmissao = anoEmissao;
        this.tamanho = tamanho;
        this.formato = formato;
        this.tipoVeiculo = tipoVeiculo;
    }

    public static Matricula terrestre(String matricula, String cor, String pais,
                                      int anoEmissao, String tamanho, String formato,
                                      String tipoVeiculo) {
        Matricula resultado = new Matricula(cor, pais, anoEmissao, tamanho, formato, tipoVeiculo);
        resultado.matriculaTerrestre = matricula;
        return resultado;
    }

    public static Matricula maritima(String matricula, String cor, String pais,
                                     int anoEmissao, String tamanho, String formato,
                                     String tipoVeiculo) {
        Matricula resultado = new Matricula(cor, pais, anoEmissao, tamanho, formato, tipoVeiculo);
        resultado.matriculaMaritima = matricula;
        return resultado;
    }

    public String getMatriculaTerrestre() { return matriculaTerrestre; }
    public void setMatriculaTerrestre(String matriculaTerrestre) { this.matriculaTerrestre = matriculaTerrestre; }
    public String getMatriculaMaritima() { return matriculaMaritima; }
    public void setMatriculaMaritima(String matriculaMaritima) { this.matriculaMaritima = matriculaMaritima; }

    public String getMatricula() {
        if (matriculaTerrestre != null && !matriculaTerrestre.isBlank()) {
            return matriculaTerrestre;
        }
        return matriculaMaritima;
    }

    public void setMatricula(String matricula) {
        if ("Barco".equalsIgnoreCase(tipoVeiculo)) {
            matriculaMaritima = matricula;
        } else {
            matriculaTerrestre = matricula;
        }
    }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public int getAnoEmissao() { return anoEmissao; }
    public void setAnoEmissao(int anoEmissao) { this.anoEmissao = anoEmissao; }
    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
    public String getTipoVeiculo() { return tipoVeiculo; }
    public void setTipoVeiculo(String tipoVeiculo) { this.tipoVeiculo = tipoVeiculo; }

    @Override
    public String toString() {
        return getMatricula();
    }
}
