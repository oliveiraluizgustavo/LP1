# LP1
Pasta criada para salvar projetos da aula de Linguagem de Programação 1. 

__________________________________________________________________________
Média Alunos - Teste de Mesa
O teste de mesa realizado com 10 alunos
[Media 10 Alunos](<E1_Classes_métodos_atributos_e_objetos - parte 1/Media_10_Alunos.xlsx>)


🎵 Música - Aquarela - Toquinho

Diagrama UML

![alt text](DiagramaUmlMusica.png)

🖼️ Vik Muniz – Lampedusa

![alt text](Lampedusa.png)

(https://cdn.culturagenial.com/imagens/lampedusa-cke.jpg?class=article)

Diagrama UML

![alt text](DiagramaUmlLampedusa.png)

🖼️ Vik Muniz – Torre Eiffel

![alt text](TorreEiffel.png)

(https://cdn.culturagenial.com/imagens/paris-0-cke.jpg?class=article)

Diagrama UML

![alt text](DiagramaUmlTorreEiffel.png)

🎨 Doodle

![alt text](DoodlePicnikPoster.png)
(https://static.wixstatic.com/media/c097a7_2cbe4d15bd6149889672c78f175482dc~mv2.jpg/v1/fill/w_955,h_665,al_c,q_85,enc_avif,quality_auto/c097a7_2cbe4d15bd6149889672c78f175482dc~mv2.jpg)

Diagrama UML

![alt text](DiagramaUmlDoodlePicnikPoster.png)

🎬 Vídeo - Brave | Animated Short Film

![alt text](VideoBrave.png)

(https://www.youtube.com/watch?v=iD_tsK_aqIQ)

Diagrama UML

![alt text](DiagramaUmlVideoBrave.png)

__________________________________________________________________________

# Entrega 02

__________________________________________________________________________

Este projeto é uma aplicação Java desenvolvida com JavaFX para interface gráfica e MySQL como banco de dados.
O sistema permite cadastrar, listar, editar e excluir registros de objetos (denominados Música apenas como nome da classe).

A estrutura é organizada em camadas:

## 1. Database.java

Responsável por criar a conexão JDBC com o MySQL.
Centraliza a URL, usuário e senha do banco, oferecendo o método getConnection() utilizado por todo o sistema.

## 2. Musica.java (Modelo)

Classe que representa cada registro salvo no banco.
Possui ID, título e três atributos personalizados, além de construtores, getters e setters.

## 3. MusicaDAO.java (Acesso ao Banco)

Implementa as operações CRUD:

Create → insere novos registros

Read → retorna todos os registros

Update → edita atributos de um registro

Delete → remove um registro pelo ID

## 4. MainApp.java (Interface JavaFX)

Gerencia toda a interface gráfica:

Tela inicial com mensagem de boas-vindas

Tela principal com duas abas:

Música: formulários para cadastrar novos objetos

Gerenciar: tabela com registros, botões para recarregar, editar e deletar

O sistema demonstra o uso de JavaFX + JDBC + MySQL, aplicando boas práticas de organização com separação entre interface, modelo e acesso a dados.

## Tela de início

Nesta tela, somos introduzidos ao sistema Com a mensagem de "Bem vindo ao programa" e temos opção de entrar no sistema, através do botão "continuar".

<img width="793" height="675" alt="TelaPrincipal" src="https://github.com/user-attachments/assets/e4855cba-731f-454e-8d6e-74636b895d59" />

## Tela Principal

Nesta tela, é onde inserimos os dados que desejamos salvar no bando de dados, após salvar, o sistema avisa que foi salvo e depois apaga as informações.

<img width="795" height="674" alt="TelaInsercaoDados" src="https://github.com/user-attachments/assets/d1a5c0d8-e0be-427a-a3f6-374ec68c4018" />

## Tela de gerenciamneto do banco

Nesta tela, podemos recarregar para ver se alguma nova informação foi inserida no sistema do banco, no caso usando MySQL em especifico, e ainda dá a opção
de editar o que foi inserido ou também excluir, caso não seja mais necessário na tabela.

<img width="796" height="677" alt="TelaDadosTabela" src="https://github.com/user-attachments/assets/1ee25b2c-fdec-48ee-b76f-0d751dca9304" />

