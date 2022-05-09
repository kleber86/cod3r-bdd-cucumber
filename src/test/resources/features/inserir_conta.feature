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

  Esquema do Cenario: Deve validar regras cadastro contas
    Quando informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem "<mensagem>"

    Exemplos:
      | conta            | mensagem                           |
      | Conta de Teste   | Conta adicionada com sucesso!      |
      |                  | Informe o nome da conta            |
      | Conta mesmo nome | Já existe uma conta com esse nome! |