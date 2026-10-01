package model;

public class Matricula {
    private String matriculaTerrestre, matriculaMaritima;
    private String cor, pais, tamanho, formato, tipoVeiculo;
    private int anoEmissao;

    private Matricula(String cor, String pais, int anoEmissao, String tamanho, String formato, String tipoVeiculo) {
        this.cor=cor; this.pais=pais; this.anoEmissao=anoEmissao; this.tamanho=tamanho; this.formato=formato; this.tipoVeiculo=tipoVeiculo;
    }

    public static Matricula terrestre(String matricula, String cor, String pais, int anoEmissao, String tamanho, String formato, String tipoVeiculo) {
        Matricula m=new Matricula(cor,pais,anoEmissao,tamanho,formato,tipoVeiculo); m.matriculaTerrestre=matricula; return m;
    }
    public static Matricula maritima(String matricula, String cor, String pais, int anoEmissao, String tamanho, String formato, String tipoVeiculo) {
        Matricula m=new Matricula(cor,pais,anoEmissao,tamanho,formato,tipoVeiculo); m.matriculaMaritima=matricula; return m;
    }
    public String getMatriculaTerrestre(){return matriculaTerrestre;}
    public void setMatriculaTerrestre(String v){matriculaTerrestre=v;}
    public String getMatriculaMaritima(){return matriculaMaritima;}
    public void setMatriculaMaritima(String v){matriculaMaritima=v;}
    public String getMatricula(){return matriculaTerrestre!=null&&!matriculaTerrestre.isBlank()?matriculaTerrestre:matriculaMaritima;}
    public void setMatricula(String v){if("Barco".equalsIgnoreCase(tipoVeiculo)) matriculaMaritima=v; else matriculaTerrestre=v;}
    public String getCor(){return cor;} public void setCor(String v){cor=v;}
    public String getPais(){return pais;} public void setPais(String v){pais=v;}
    public int getAnoEmissao(){return anoEmissao;} public void setAnoEmissao(int v){anoEmissao=v;}
    public String getTamanho(){return tamanho;} public void setTamanho(String v){tamanho=v;}
    public String getFormato(){return formato;} public void setFormato(String v){formato=v;}
    public String getTipoVeiculo(){return tipoVeiculo;} public void setTipoVeiculo(String v){tipoVeiculo=v;}
    @Override public String toString(){return getMatricula();}
}
