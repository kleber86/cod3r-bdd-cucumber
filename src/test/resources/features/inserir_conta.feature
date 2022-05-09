#language: pt
Funcionalidade: Cadastro de contas
  Como usuario
  Gostaria de cadastrar contas
  Para que possa distribuir meu dinheiro de forma mais organizada


  Cenario: Deve inserir uma conta com sucesso
    Dado que estou acessando a aplicacao
    Quando informo o usuario "contato3@kleber.com.br"
    E a senha "123456"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    Quando seleciono Adicionar
    E informo a conta "Nova conta"
    E seleciono Salvar
    Entao a conta eh inserida com sucesso


  Cenario: Não deve inserir uma conta sem nome
    Dado que estou acessando a aplicacao
    Quando informo o usuario "contato3@kleber.com.br"
    E a senha "123456"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E seleciono Salvar
    Entao sou notificado que o nome da conta eh obrigatoria


  Cenario: Não deve inserir uma conta já existente
    Dado que estou acessando a aplicacao
    Quando informo o usuario "contato3@kleber.com.br"
    E a senha "123456"
    E seleciono entrar
    Entao visualizo a pagina inicial
    Quando seleciono Contas
    E seleciono Adicionar
    E informo a conta "Conta mesmo nome"
    E seleciono Salvar
    Entao sou notificcado que ja existe uma conta com esse nome