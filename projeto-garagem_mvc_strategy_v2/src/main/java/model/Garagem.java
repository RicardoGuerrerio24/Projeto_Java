package model;
import java.util.*;
public class Garagem {
    public static final int CAPACIDADE_MINIMA=0, CAPACIDADE_MAXIMA=5;
    private final int capacidade; private final List<Veiculo> veiculos=new ArrayList<>();
    public Garagem(int capacidade){if(capacidade<0||capacidade>5) throw new IllegalArgumentException("A capacidade deve estar entre 0 e 5."); this.capacidade=capacidade;}
    public int getCapacidade(){return capacidade;} public int getNumeroVeiculos(){return veiculos.size();}
    public boolean estaVazia(){return veiculos.isEmpty();} public boolean estaCheia(){return veiculos.size()>=capacidade;}
    public List<Veiculo> getVeiculos(){return Collections.unmodifiableList(veiculos);}
    public boolean podeEntrar(Veiculo v){return v!=null&&!estaCheia()&&ordemValida(v);}
    public boolean entrar(Veiculo v){if(!podeEntrar(v)) return false; veiculos.add(v); return true;}
    public boolean sair(Veiculo v){return veiculos.remove(v);}
    private boolean ordemValida(Veiculo v){int p=veiculos.size(); if(p==0)return v instanceof Carro; if(p==1)return v instanceof Barco; if(p==2)return v instanceof Mota; return true;}
}
