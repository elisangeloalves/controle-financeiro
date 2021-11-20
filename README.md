# PROJETO CONTROLE FINANCEIRO - API RESTFULL
   Aplicação desenvolvida para disponibilizar uma API RESTFULL (Backend) que possibilite ao usuario gerenciar seus gastos através do lancamentos de despesas e receitas com a opção de categorizar os lançamentos.

### Descrição técnica do projeto:

##### Tecnologias utilizadas no projeto:
- Java versão 17
- SpringBoot Framework e familia versão: 2.4.4
- H2 Database 2019
- Projeto Maven versão 4.0.0
		
#####  Requisitos Funcionais
	
* Nesta aplicação, o usuario poderá criar uma conta onde será possível gerenciar suas receitas e gastos;
* Somente usuários cadastrados poderão acessar as seguintes funcionalidades:
####
    - incluír lançamentos seja de crédito ou débito contendo valor, data e categoria(opcional);
    - atualizar ou excluir lançamentos de uma conta;
    - criar categorias subclassificadas como despesa ou receita;
    - adicionar categorias aos lançaments para melhorar organização da conta;
    - adicinar uma categoria a um lançamento já cadastrado na aplicação pertecente ao usuário;
    - excluir uma categoria que foi cadastrada pelo usuário;
    - listar todas as categorias cadastradas pelo usuário;
    - listar todos os lançamentos criado pelo usuario;
    - listar um lançamento específico do usuário;
    - listar lançamentos criados pelo usuário por um ano específico classificados por data;
    - listar lançamentos criados pelo usuário por ano e mês específico classificados por data;
    - listar lançamentos criados pelo usuário por ano, mês e uma categoria específica classificados por data;
    - listar lançamentos criados pelo usuário por uma categoria específica classificados por data;
    - listar resumo de lançamentos das receitas, despesas e saldos por meses;
    - listar resumo de um mês específico;

* Um usuário deve ter acesso somente a seus próprios lançamentos.
		
		
######  Requisitos não funcionais
		
- Toda ação do usuário sobre os lançamentos é autenticada (acesso somente com token válido);
- A autenticação deve ser configurada para expirar em 5 minutos;
- Campos de data serão exibidos na API no formato ISO (yyyy-MM-dd);


OBS: funcionalidades implementadas até este momento:
>
>    * cadastro de usuário;
>    * autenticação e login de usuário;
>    * cadastro de categorias;
>    * listagem de categoris pelo usuário;
>
 Extras:
>    - segurança da aplicação (está ativa e funcional) com autentição via JWT token;
>    - usuario logado com pefil "ADMIN" podem listar usuários cadastrados na aplicação;
>    - aplicação possui rotas de monitoramento da aplicação como:
>		* métricas da aplicação;
>		* informações da aplicação;
>		* healthcheck;
>		* prometheus;

... Demais funcionalidades continuam em implementação.

##  Rotas de acesso

#### DICA: 
para facilitar a visualização e o acesso aos end-points da api, o acesso as rotas pode ser feito através do botao abaixo:

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/b2ea39d264b1850f2d3c?action=collection%2Fimport)

   * será possível executar o Postman via browser ou local (talvez precise fazer login para acessar o serviço);
   * após o postman abrir, escolha o Workspace "Mentoria Devs" e a coleção será importada automaticamente;
   * atenção: só é possível ter os end-points funcionando, após clonar o projeto e executá-lo em uma IDE de sua escolha;

###    Rotas para requisições do tipo POST
* exemplo de parâmetros de entrada e saída podem ser encontrados na coleção do postman.

###### Cadastrar usuario:

        POST http://localhost:8080/digital-wallet/users

###### Autenticacao de usuario (login):

	POST http://localhost:8080/digital-wallet/login

###### Adicionar um novo lançamento:

        POST http://localhost:8080/digital-wallet/users/{user_id}/entries

###### Cadastrar categorias:

        POST http://localhost:8080/digital-wallet/users/{user_id}/categories

###    Rotas para requisições do tipo GET

######  Listar todos os usuarios (Gerencial - acesso somente via perfil "ADMIN"):

       GET https://localhost/digital-wallet/management

######  Listar todos os lançamentos:
* na ausência do parametro "year" a aplição lista os lançamentos do último ano.
       
       GET https://localhost/digital-wallet/users/{user_id}/entries
       
######  Listar um lançamento especifico por id:
      
      GET https://localhost/digital-wallet/users/{user_id}/entries/{entry_id}
       
###### Listar resumo de todas as despesas/receitas e saldo mensais:
* na ausência do parametro "year" a aplição lista o resumo do último ano.

       GET https://localhost:8080/digital-wallet/users/{user_id}/entries/summary
       
###### Listar detalhes de lançamentos de um mes especifico
* na ausência do parametro "year" a aplicação considera o ano corrente como referência.

       GET http://localhost:8080/digital-wallet/users/{user_id}/entries?month={written_month}
       
###### Listar resumo de lançamentos de um mes especifico
* na ausência do parametro "year" a aplicação considera o ano corrente como referência.

       GET http://localhost:8080/digital-wallet/users/{user_id}/entries/sumary?month={written_month}&year={year}
       
###### Listar lancamentos de um determinado mes por uma categoria especifica:
* na ausência do parametro "year" a aplicação considera o ano corrente como referência.
        
       GET http://localhost:8080/digital-wallet/users/{user_id}/entries?month={written_month}&category={category_name}

###### Listar lancamentos por uma categoria especifica:    
        
       GET http://localhost:8080/digital-wallet/users/{user_id}/entries?category={category_name}
             
###### Listar todas as categorias previamente cadastradas:
  
       GET http://localhost:8080/digital-wallet/users/{user_id}/categories

####    Rotas para requisições do tipo DELETE
        
###### Excluir a conta (do usuario logado):

        DELETE http://localhost:8080/digital-wallet/users/{user_id}
        
###### Excluir uma lançamento:
        
        DELETE http://localhost:8080/digital-wallet/users/{user_id}/entries/{entry_id}
        
###### Excluir uma categoria:        
        
        DELETE http://localhost:8080/digital-wallet/users/{user_id}/categories/{category_id}
        
####    Rotas para requisições do tipo PUT
            
###### Atualizasr um lançamento específico:

        PUT http://localhost:8080/digital-wallet/users/{user_id}/entries/{entry_id}

###### Atualizar dados da conta (do usuario logado):

        PUT http://localhost:8080/digital-wallet/users/{user_id}


##  Como executar o projeto

##### Requisitos necessários no computador:

-    Java ( no mínimo versão 17 )
-    Maven
-    ter acesso a uma interface que possibilite fazer requisições para a aplicação.
   
##### Passo-a-passo para linha de comando:

> ... em construção ...

