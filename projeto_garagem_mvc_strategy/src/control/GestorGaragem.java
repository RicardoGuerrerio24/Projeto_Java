package control;

import model.Garagem;
import model.Veiculo;
import repository.GaragemRepository;

import java.util.List;

public class GestorGaragem {

    private final Garagem garagem;
    private final GaragemRepository repository;

    public GestorGaragem(Garagem garagem) {

        if (garagem == null) {
            throw new IllegalArgumentException(
                    "A garagem não pode ser nula."
            );
        }

        this.garagem = garagem;
        this.repository = new GaragemRepository();
    }

    public Garagem getGaragem() {
        return garagem;
    }

    public boolean adicionarVeiculo(Veiculo veiculo) {

        boolean adicionado = garagem.entrar(veiculo);

        if (adicionado) {
            repository.guardar(veiculo);
        }

        return adicionado;
    }

    public boolean removerVeiculo(Veiculo veiculo) {
        return garagem.sair(veiculo);
    }

    public boolean podeAdicionar(Veiculo veiculo) {
        return garagem.podeEntrar(veiculo);
    }

    public List<Veiculo> consultarVeiculos() {
        return repository.buscarTodos();
    }

    public void limparBaseDeDados() {
        repository.limpar();
    }
}