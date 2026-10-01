package com.matriculas;

public class Matricula {

    private String matricula;
    private String cor;
    private String pais;
    private int anoEmissao;
    private String tamanho;
    private String formato;
    private String tipoVeiculo;

    public Matricula(String matricula, String cor, String pais, int anoEmissao,
                     String tamanho, String formato, String tipoVeiculo) {

        this.matricula = matricula;
        this.cor = cor;
        this.pais = pais;
        this.anoEmissao = anoEmissao;
        this.tamanho = tamanho;
        this.formato = formato;
        this.tipoVeiculo = tipoVeiculo;
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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula +
                ", Cor: " + cor +
                ", País: " + pais +
                ", Ano de emissão: " + anoEmissao +
                ", Tamanho: " + tamanho +
                ", Formato: " + formato +
                ", Tipo de veículo: " + tipoVeiculo;
    }
}
