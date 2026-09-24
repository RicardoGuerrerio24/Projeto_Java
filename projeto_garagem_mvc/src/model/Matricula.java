package model;

public class Matricula {

    private String matricula;
    private String cor;
    private String pais;
    private int anoEmissao;
    private String tamanho;

    public Matricula(String matricula, String cor, String pais, int anoEmissao, String tamanho) {
        this.matricula = matricula;
        this.cor = cor;
        this.pais = pais;
        this.anoEmissao = anoEmissao;
        this.tamanho = tamanho;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAnoEmissao() {
        return anoEmissao;
    }

    public void setAnoEmissao(int anoEmissao) {
        this.anoEmissao = anoEmissao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula +
                ", Cor: " + cor +
                ", País: " + pais +
                ", Ano de emissão: " + anoEmissao +
                ", Tamanho: " + tamanho;
    }
}
