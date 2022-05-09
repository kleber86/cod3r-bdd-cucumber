#language: pt
@unitarios
Funcionalidade: Alugar Filmes
  Como um usuario
  Eu quero cadastrar alugueis de filmes
  Para controlar preços e datas de entrega

  Cenario: Deve alugar um filme com sucesso
    Dado um filme
      | estoque | 2     |
      | preco   | 3.0   |
      | tipo    | comum |
    E que o preço do alguel seja R$ 3.00
    Quando alugar
    Então o preço do aluguel será R$ 3.00
    E a data de entrega será em 1 dia
    E o estoque do filme será 1 unidade

  Cenario: Não deve alugar filme sem estque
    Dado um filme em estoque de 0 unidades
    Quando alugar
    Então não será possivel por falta de estoque
    E o estoque do filme será 0 unidade

  Esquema do Cenario: Deve dar condições conforme tipo de aluguel
    Dado um filme em estoque de 2 unidades
    E que o preço do alguel seja R$ <preco>
    E que o tipo do aluguel seja <tipo>
    Quando alugar
    Então o preço do aluguel será R$ <valor>
    E a data de entrega será em <qtdDias> dias
    E a pontuação recebida será de <pontuacao> pontos

    Exemplos:
      | preco | tipo      | valor | qtdDias | pontuacao |
      | 4     | extendido | 8     | 3       | 2         |
      | 4     | comum     | 4     | 1       | 1         |