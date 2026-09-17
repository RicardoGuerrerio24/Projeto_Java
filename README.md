# Projeto Carro

## 1. Objetivo do projeto

Este projeto tem como objetivo representar, através de Programação Orientada a Objetos, um carro e os seus principais componentes, sistemas e comportamentos.

Nesta primeira fase foram criadas três classes principais:

- `Carro`
- `Condutor`
- `Main`

Também está prevista a criação futura da classe `Matricula`.

A principal decisão tomada na estrutura do projeto foi separar aquilo que **pertence ao funcionamento do carro** daquilo que **é uma ação realizada por uma pessoa**.

Assim:

- A classe `Carro` representa o veículo e os seus sistemas.
- A classe `Condutor` representa a pessoa que dá comandos ao carro.
- A classe `Main` é responsável por criar os objetos e executar a simulação.

---

## 2. Classe `Carro`

A classe `Carro` representa o veículo.

Foram escolhidas características que permitem descrever fisicamente e tecnicamente o carro:

- `marca`
- `modelo`
- `ano`
- `peso`
- `comprimento`
- `largura`
- `altura`
- `velocidadeMaxima`
- `velocidadeAtual`

Estas características foram escolhidas porque representam informações próprias do veículo.

Por exemplo:

- A `marca` e o `modelo` identificam o veículo.
- O `ano` indica quando o veículo foi produzido.
- O `peso` e as dimensões representam as suas características físicas.
- A `velocidadeMaxima` representa um limite do veículo.
- A `velocidadeAtual` representa o estado atual do carro durante a simulação.

### Matrícula

A matrícula **não foi incluída** na classe `Carro`.

A matrícula será representada posteriormente através de uma classe própria chamada `Matricula`.

Esta decisão permite separar responsabilidades e evita colocar na classe `Carro` informação que será tratada por outro objeto.

---

## 3. Classes internas da classe `Carro`

Dentro da classe `Carro` foram criadas várias classes internas para representar os seus diferentes sistemas:

- `Motor`
- `SistemaArrefecimento`
- `SistemaCombustivel`
- `SistemaEletrico`
- `SistemaTravagem`
- `Pneus`

A utilização destas classes permite dividir o carro em componentes diferentes.

Cada componente fica responsável pelas suas próprias características e comportamentos.

A estrutura é aproximadamente:

```text
Carro
├── Motor
├── SistemaArrefecimento
├── SistemaCombustivel
├── SistemaEletrico
├── SistemaTravagem
└── Pneus
