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

Cenario: Deve criar steps genericos para estes passos
  Dado que o ticket é AF345
  Dado que o valor da passagem é R$ 230,45
  Dado que o nome do passageiro é "Fulano da Silva"
  Dado que o telefone do passageiro é 9999-9999
  Quando criar os steps
  Então o teste vai funcionar

Cenario: Deve reaproveitar os steps "Dado" do cenario anterior
  Dado que o ticket é AB167
  Dado que o ticket especial é AB167
  Dado que o valor da passagem é R$ 1120,23
  Dado que o nome do passageiro é "Cicrano de Oliveira"
  Dado que o telefone do passageiro é 9888-8888

Cenario: Deve negar todos os steps "Dado" dos cenarios anteriores
  Dado que o ticket é CD123
  Dado que o ticket é AG1234
  Dado que o valor da passagem é R$ 1.1345,56
  Dado que o nome do passageiro é "Beltrano Souza Matos de Alcantara Azevero"
  Dado que o telefone do passageiro é 1234-5678
  Dado que o telefone do passageiro é 999-2223