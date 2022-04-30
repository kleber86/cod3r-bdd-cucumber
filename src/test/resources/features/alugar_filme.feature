#language: pt

Funcionalidade: Alugar Filmes
  Como um usuario
  Eu quero cadastrar alugueis de filmes
  Para controlar preços e datas de entrega

  Cenario: Deve alugar um filme com sucesso
    Dado um filme em estoque de 2 unidades
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

  Cenario: Deve dar condições especiais para categoria extendida
    Dado um filme em estoque de 2 unidades
    E que o preço do alguel seja R$ 4,00
    E que o tipo do aluguel seja extendido
    Quando alugar
    Então o preço do aluguel será R$ 8,00
    E a data de entrega será em 3 dias
    E a pontuação recebida será de 2 pontos

  Cenario: Deve dar alugar para categoria comum
    Dado um filme em estoque de 2 unidades
    E que o preço do alguel seja R$ 4,00
    E que o tipo do aluguel seja comum
    Quando alugar
    Então o preço do aluguel será R$ 4,00
    E a data de entrega será em 1 dia
    E a pontuação recebida será de 1 pontos