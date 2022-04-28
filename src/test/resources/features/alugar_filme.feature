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
  E a data de entrega será no dia seguinte
  E o estoque do filme será 1 unidade

Cenario: Não deve alugar filme sem estque
  Dado um filme em estoque de 0 unidades
  Quando alugar
  Então não será possivel por falta de estoque
  E o estoque do filme será 0 unidade