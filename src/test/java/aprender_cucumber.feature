#language: pt

Funcionalidade: Aprender Cucumber
  Como um aluno
  Eu quero aprender a utilizar Cucumber
  Para que eu possa automatizar criterios de aceitação


Cenario: Deve executar especificação
  Dado que criei o arquivo corretamente
  Quando executa-lo
  Então a especificação deve finalizar com sucesso

Cenario: Deve incrementar contador
  Dado que o valor do contador é 15
  Quando eu incrementar em 3
  Então o valor do contador é 18

Cenario: Deve calcular atraso na entrega
  Dado que a entrega é dia 25/04/2022
  Quando a entrega atrasar em 2 dias
  Então a entrefa será efetuada em 27/04/2022

Cenario: Deve calcular atraso na entrega da china
    Dado que a entrega é dia 25/04/2022
    Quando a entrega atrasar em 2 meses
    Então a entrefa será efetuada em 25/06/2022