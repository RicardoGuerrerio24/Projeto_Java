# Projeto_Java

## 1. Objetivo do projeto

Este projeto tem como objetivo representar, através de Programação Orientada a Objetos, um carro e os seus principais componentes e sistemas.

Nesta primeira fase foi criada a classe `Carro`, que contém as características gerais de um carro e os sistemas que fazem parte do seu funcionamento.

Uma decisão importante foi separar as **ações realizadas por uma pessoa** do **funcionamento autónomo do veículo**.

Assim, esta classe não contém ações como ligar, desligar, acelerar, travar ou buzinar, pois estas dependem da intervenção de um condutor.

---

## 2. Classe `Carro`

A classe `Carro` representa o próprio veículo.

Foram escolhidas características que descrevem fisicamente o carro:

- `marca`
- `modelo`
- `ano`
- `peso`
- `comprimento`
- `largura`
- `altura`
- `velocidadeMaxima`

Estas características foram escolhidas porque permitem identificar e descrever o veículo sem depender de ações humanas.

Por exemplo, a marca e o modelo identificam o carro, enquanto o peso e as dimensões representam características físicas do veículo.

### Matrícula

A matrícula **não foi incluída** na classe `Carro`.

A matrícula será representada posteriormente através de uma classe própria. Esta decisão permite manter responsabilidades diferentes separadas e evita colocar na classe `Carro` informação que será tratada por outro objeto.

---

## 3. Classes internas

Foram utilizadas classes dentro da classe `Carro` para representar diferentes sistemas e componentes do veículo.

As classes internas são:

- `Motor`
- `SistemaArrefecimento`
- `SistemaCombustivel`
- `SistemaEletrico`
- `SistemaTravagem`
- `Pneus`

A utilização destas classes permite dividir o carro em diferentes partes, cada uma com as suas próprias características e comportamentos.

Em vez de colocar todas as variáveis e funções diretamente dentro de `Carro`, cada sistema fica responsável pela informação que lhe diz respeito.

Isto torna o código mais organizado e facilita a sua expansão no futuro.

---

## 4. Classe `Motor`

A classe `Motor` representa o motor do veículo.

Entre as suas características encontram-se:

- temperatura;
- temperatura normal;
- temperatura máxima;
- quantidade de óleo;
- desgaste.

Estas características foram escolhidas porque são relevantes para representar o estado e a manutenção de um motor.

Por exemplo, a temperatura permite determinar se o motor está a sobreaquecer, enquanto o desgaste representa a deterioração do componente ao longo da sua utilização.

O motor também possui comportamentos automáticos, como o controlo da sua temperatura e o aumento do desgaste.

Não foi criado um método `ligar()` ou `desligar()` nesta versão, porque essas ações dependem de uma pessoa e não fazem parte do funcionamento autónomo que esta classe pretende representar.

---

## 5. Classe `SistemaArrefecimento`

A classe `SistemaArrefecimento` representa o sistema responsável por controlar a temperatura do motor.

Possui, entre outras características:

- estado da ventoinha;
- nível do líquido de arrefecimento.

O sistema de arrefecimento foi incluído porque representa um exemplo claro de um sistema que pode funcionar automaticamente.

Quando a temperatura do motor ultrapassa determinado valor, o sistema pode ativar a ventoinha. Quando a temperatura baixa, a ventoinha pode ser desligada.

Não é necessário que o condutor diga ao carro para arrefecer o motor.

Por esse motivo, este comportamento pertence aos sistemas automáticos do carro.

---

## 6. Classe `SistemaCombustivel`

A classe `SistemaCombustivel` representa o combustível disponível no veículo.

Foram incluídas características como:

- capacidade máxima do depósito;
- quantidade atual de combustível.

Também existem métodos para consultar o estado do combustível, como verificar se o depósito está na reserva ou vazio.

Não foi incluído um método `abastecer()`.

O motivo é que abastecer o carro requer uma ação externa, normalmente realizada por uma pessoa. Assim, nesta fase, a classe limita-se a representar o estado do combustível.

---

## 7. Classe `SistemaEletrico`

A classe `SistemaEletrico` representa o sistema elétrico do veículo.

Foram consideradas características como:

- nível da bateria;
- voltagem.

O sistema possui também comportamentos relacionados com a gestão automática da bateria.

A existência desta classe permite representar separadamente componentes relacionados com a eletricidade do veículo, em vez de colocar essas informações diretamente na classe `Carro`.

---

## 8. Classe `SistemaTravagem`

A classe `SistemaTravagem` representa o estado do sistema de travagem.

Foram incluídas características como:

- temperatura dos travões;
- desgaste dos travões.

A temperatura pode variar devido à utilização dos travões e posteriormente diminuir naturalmente.

O desgaste representa a deterioração do sistema ao longo do tempo.

Não foi criado um método `travar()`, porque travar é uma ação comandada pelo condutor.

A classe representa o **sistema de travagem**, e não o ato de o condutor carregar no pedal.

---

## 9. Classe `Pneus`

A classe `Pneus` representa os pneus do veículo.

Foram incluídas características como:

- pressão dos pneus dianteiros;
- pressão dos pneus traseiros;
- desgaste.

A pressão pode diminuir gradualmente devido à perda natural de ar.

O desgaste representa a deterioração dos pneus ao longo da utilização.

Não foram criados métodos como `encherPneus()`, porque essa ação requer intervenção externa.

---

## 10. Método `atualizar()`

A classe `Carro` possui o método:

```java
public void atualizar()
