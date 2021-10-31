# PROJETO CONTROLE FINANCEIRO - API RESTFULL

>    Aplicação desenvolvida para disponibilizar uma API REST que possibilite ao usuario gerenciar seus gastos atraves do lancamentos de despesas e receitas com a opção de categorizar os lançamentos.

### Descrição técnica do projeto:

###### Tecnologias utilizadas no projeto:
- Java versão 11
- SpringBoot Framework e familia versão: 2.4.4
- H2 Database
- Projeto Maven versão 4.0.0

######  Requisitos Funcionais

* Nesta aplicação, o usuario poderá criar uma conta para gerenciar seus gastos;
* Somente usuários cadastrados poderão fazer/acessar funcionalidades como:

    - incluír lançamentos na conta contendo data, valor, se é crédito ou débito;
    - incluir categorias de despesas/receitas (opcional) para melhorar organização da conta
    - listar seus lançamentos mensais agrupados por categoria
    - listar um resumo de receitas, despesas e saldo por mês

*	 Restrição de funcionalidade:
      Lançamentos criados por um usuário não podem ser vistos por outros usuarios.


######  Requisitos não funcionais

- Toda ação do usuário sobre os lançamentos é autenticada (acesso somente com token válido)
- Campos de data serão exibidos na API no formato ISO (yyyy-MM-dd)


##  Rotas de acesso

DICA:  para facilitar a visualização e o acesso aos end-points da api, o acesso as rotas pode ser feito através do botao abaixo:
>
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/b2ea39d264b1850f2d3c?action=collection%2Fimport)

>   * será possível executar o Postman via browser ou local ( talvez precise fazer login para acessar o serviço );
>   * após o postman abrir, escolha o Workspace "Mentoria Devs" e a coleção será importada automaticamente;
>   * atenção: só é possível ter os end-points funcionando, após clonar o projeto e executá-lo em uma IDE de sua escolha;

####    Rotas para requisições do tipo POST

###### Cadastrar usuario:

        POST http://localhost:8080/controle-financeiro/usuarios

###### Autenticacao de usuario (login):

        POST http://localhost:8080/controle-financeiro/login

###### Adicionar um novo lançamento:

        POST http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/lancamentos

###### Cadastrar categorias:

        POST http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/categorias

####    Rotas para requisições do tipo GET

######  Listar todos os usuarios (Gerencial - acesso somente via perfil "ADMIN"):

       GET https://localhost/controle-financeiro/gerenciamento

######  Listar todos os lançamentos:

       GET https://localhost/controle-financeiro/usuarios/%usuario_id%/lancamentos

######  Listar um lançamento especifico por id:

      GET https://localhost/controle-financeiro/usuarios/%usuario_id%/lancamentos/%lancamento_id

###### Listar resumo de todas as despesas/receitas e saldo mensais:

       GET https://localhost:8080/controle-financeiro/usuarios/%usuario_id%/lancamentos/resumo

###### Listar detalhes de lançamentos de um mes especifico (paramentro ano é opcional: ano=%ano_4_digitos%):

       GET http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/lancamentos?mes=%mes_por_extenso%

###### Listar resumo de lançamentos de um mes especifico (paramentro ano é opcional):

       GET http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/lancamentos/resumo?mes=%mes_por_extenso%&ano=%ano_4_digitos%

###### Listar lancamentos de um determinado mes por uma categoria especifica:

       GET http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/lancamentos?mes=%mes_por_extenso%&categoria=%nome_da_categoria%

###### Listar lancamentos por uma categoria especifica:

       GET http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/lancamentos?categoria=%nome_da_categoria%

###### Listar todas as categorias previamente cadastradas:

       GET http://localhost:8080/controle-financeiro/usuarios/%usuario_id%/categorias

####    Rotas para requisições do tipo DELETE

###### Excluir a conta (do usuario logado):

        DELETE http://localhost:8080/usuarios/%usuario_id%

###### Excluir uma lançamento:

        DELETE http://localhost:8080/usuarios/%usuario_id%/lancamentos/%lancamento_id%

###### Excluir uma categoria:

        DELETE http://localhost:8080/usuarios/%usuario_id%/categorias/%categoria_id%

####    Rotas para requisições do tipo PUT

###### Alterar um lançamento:

        PUT http://localhost:8080/usuarios/%usuario_id%/lancamentos/%lancamento_id%

###### Atualizar dados da conta (do usuario logado):

        PUT http://localhost:8080/usuarios/%usuario_id%

##  Como executar o projeto

##### Requisitos necessários no computador:

-    Java ( no mínimo versão 11 )
-    Maven

##### Passo-a-passo para linha de comando:

> ... em construção ...