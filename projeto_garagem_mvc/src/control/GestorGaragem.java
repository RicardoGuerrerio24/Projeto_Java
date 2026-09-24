package control;

import model.Garagem;
import model.Veiculo;

public class GestorGaragem {

    private final Garagem garagem;

    public GestorGaragem(Garagem garagem) {
        if (garagem == null) {
            throw new IllegalArgumentException("A garagem não pode ser nula.");
        }

        this.garagem = garagem;
    }

    public Garagem getGaragem() {
        return garagem;
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {
        return garagem.entrar(veiculo);
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        return garagem.sair(veiculo);
    }

    public boolean podeAdicionar(Veiculo veiculo) {
        return garagem.podeEntrar(veiculo);
    }
}
