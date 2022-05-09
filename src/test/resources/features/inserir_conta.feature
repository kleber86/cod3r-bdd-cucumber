#language: pt
Funcionalidade: Cadastro de contas
  Como usuario
  Gostaria de cadastrar contas
  Para que possa distribuir meu dinheiro de forma mais organizada

  Contexto:
    Dado que estou acessando a aplicacao
    Quando informo o usuario "contato3@kleber.com.br"
    E a senha "123456"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    Quando seleciono Adicionar

  Cenario: Deve inserir uma conta com sucesso
    E informo a conta "Conta de Teste"
    E seleciono Salvar
    Entao a conta eh inserida com sucesso


  Cenario: Não deve inserir uma conta sem nome
    E seleciono Salvar
    Entao sou notificado que o nome da conta eh obrigatoria


  Cenario: Não deve inserir uma conta já existente
    E informo a conta "Conta mesmo nome"
    E seleciono Salvar
    Entao sou notificcado que ja existe uma conta com esse nome