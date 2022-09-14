# Desafio03A-Catalisa-Modulo5
Projeto para pagamento e recebimento, na primeira parte foi criada as classes, atributos e métodos para o sistema de pagamento de uma conta. Na segunda parte criamos um sistema para receber valores de Alugueis, Emprego_Clt e Freelancer, no caso dos alugueis se o pagamento foi em atraso ocasiona em uma multa de 3,5% no valor do aluguel, se o pagamento foi adiantado ocorre um desconto de 5% no valor. Foi feito o CRUD(Create, Read, Update and Delete) para cadastrar Estados, Cidades, Endereços, Usuários e Contas a Receber, cada cadastro é uma entidade que será persistida no banco de dados onde também foi feito um relacionamento entre entidades com PRIMARYKEY e FOREIGNKEY.

(DICA)
O cliente deverá primeiramente cadastrar um Estado, em seguida cadastrar uma Cidade e adicionar o codigo do Estado criado que será sua chave estrangeira. Depois de cadastrar a Cidade, cadastre um Endereço fazendo a relação com a Cidade criada, logo após cadastre um Usuário fazendo a relação com o Endereço criado e por fim cadestre uma Conta a Receber fazendo a relação com o Usuário criado. Fazendo essa sequência vai prevenir que haja a necessidade de ao cadastrar uma Conta a Receber primeiro e depois um usuário, tenha depois que editar a Conta a Receber criada para passar o codigo do Usuário.

(EXEMPLO)
Quando for cadastrar uma Conta a Receber utilizando o JSON, cadastre da seguinte forma:

    }
    "recebimento": "Aluguel Casa 01",
    "valorRecebimento": 900.00,
    "tipoRecebido":"ALUGUEIS",
    "dataDeVencimento": "2022-09-14",
    "dataDeRecebimento":"2022-09-10",    -> data de recebimento e vencimento precisam ser adicionadas pelo cliente nesse formato.
    "usuarios":{
        "codigo":1
    }
