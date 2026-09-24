# Projeto Garagem — MVC

## Estrutura

- `model` — objetos e regras do domínio.
- `control` — gestor que coordena as operações.
- `view` — apresentação da informação.
- `Main` — ponto de entrada e demonstração.

## Model

O Model contém:

- `Veiculo` — classe abstrata base.
- `Carro` — especialização de `Veiculo`.
- `Barco` — especialização de `Veiculo`.
- `Mota` — especialização de `Veiculo`.
- `Matricula` — representa a matrícula de um veículo.
- `Garagem` — mantém os veículos e as regras de capacidade/ordem.

## OOP

O projeto usa:

- **Encapsulamento** através de atributos privados.
- **Herança** com `Carro`, `Barco` e `Mota` a herdarem de `Veiculo`.
- **Abstração** através da classe abstrata `Veiculo`.
- **Polimorfismo** através do método `mover()`.
- **Composição/associação** entre `Veiculo` e `Matricula`.

## Regras da garagem

A capacidade permitida está entre `0` e `5`.

A ordem obrigatória das três primeiras entradas é:

1. Carro
2. Barco
3. Mota

Depois dessas três entradas, qualquer `Veiculo` pode entrar enquanto existir espaço.

## Testabilidade

As classes do Model não dependem da View nem de `System.out`.

As operações principais devolvem `boolean` (`entrar`, `sair`, `adicionarVeiculo`, etc.), o que facilita a criação de testes unitários.

A `Garagem#getVeiculos()` devolve uma lista não modificável, evitando que código externo altere diretamente o estado interno da garagem.

## Compilação

A partir da pasta `src`:

```bash
javac Main.java model/*.java control/*.java view/*.java
java Main
```
