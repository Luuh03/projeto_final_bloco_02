# Projeto Final Bloco 2 - Backend de Farmácia com Spring Boot
 
<br />
 
<div align="center">
<img src="https://i.imgur.com/w8tTOuT.png" title="source: imgur.com" /> 
</div>
 
<br />
 
<div align="center">
<img src="https://img.shields.io/github/languages/top/Luuh03/projeto_final_bloco_02?style=flat-square" />
<img src="https://img.shields.io/github/repo-size/Luuh03/projeto_final_bloco_02?style=flat-square" />
<img src="https://img.shields.io/github/languages/count/Luuh03/projeto_final_bloco_02?style=flat-square" />
<img src="https://img.shields.io/github/last-commit/Luuh03/projeto_final_bloco_02?style=flat-square" />
<img src="https://img.shields.io/github/issues/Luuh03/projeto_final_bloco_02?style=flat-square" />
<img src="https://img.shields.io/github/issues-pr/Luuh03/projeto_final_bloco_02?style=flat-square" />
<img src="https://img.shields.io/badge/status-construção-green" alt="Status: Concluído">
 
</div>
 
<br />
 
## 1. Descrição
 
<br />
 
O **Projeto Final Bloco 2** é uma aplicação pensada no contexto de um Ecommerce de Farmácia que permite que usuários publiquem, editem e visualizem produtos relacionados a categorias variadas, de forma organizada e segura. Este projeto foi desenvolvido com fins avaliativos, simulando uma aplicação de gestão de produtos para avaliar conceitos de criação de projetos Spring, configuração da conexão com banco de dados, conceitos relacionados a classes Model e Controller, interfaces Repository e integração entre entidades.
 
Entre os principais recursos que um Ecommerce de Farmácia oferece, destacam-se:
 
1. Criação, edição e exclusão de produtos
2. Associação de produtos a categorias específicas
4. Visualização de produtos por categoria
 
<br />
 
## 2. Sobre esta API
 
<br />
 
A API do Projeto final foi desenvolvida utilizando **Java** e o **framework Spring**, seguindo os princípios da Arquitetura MVC e REST. Ela oferece endpoints para o gerenciamento dos recursos **Produto** e **Categoria**, permitindo a interação entre os usuários e os produtos publicados.
 
<br />
 
### 2.1. Principais funcionalidades da API:
 
<br />
 
2. Consulta, criação e gerenciamento de categorias para classificar produtos
3. Criação, edição, listagem e remoção de produtos
4. Associação de produtos a categorias
 
<br />
 
## 3. Tecnologias utilizadas
 
<br />
 
| Item                          | Descrição       |
| ----------------------------- | --------------- |
| **Servidor**                  | Tomcat          |
| **Linguagem de programação**  | Java            |
| **Framework**                 | Spring Boot     |
| **ORM**                       | JPA + Hibernate |
| **Banco de dados Relacional** | MySQL           |
 
<br />
 
## 4. Requisitos
 
<br />
 
Para executar os códigos localmente, você precisará:
 
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Banco de dados [MySQL](https://dev.mysql.com/downloads/)
- [STS](https://spring.io/tools)
- [Insomnia](https://insomnia.rest/download) ou [Postman](https://www.postman.com/)
 
<br />
 
## 5. Como Executar o projeto no STS
 
<br />
 
### 5.1. Importando o Projeto
 
1. Clone o repositório do Projeto [Projeto Final Bloco 2](https://github.com/Luuh03/projeto_final_bloco_02) dentro da pasta do *Workspace* do STS
 
```bash
git clone https://github.com/Luuh03/projeto_final_bloco_02
```
 
2. **Abra o STS** e selecione a pasta do *Workspace* onde você clonou o repositório do projeto
3. No menu superior do STS, clique na opção: **File 🡲 Import...**
4. Na janela **Import**, selecione a opção: **General 🡲 Existing Projects into Workspace** e clique no botão **Next**
5. Na janela **Import Projects**, no item **Select root directory**, clique no botão **Browse...** e selecione a pasta do Workspace onde você clonou o repositório do projeto
6. O STS reconhecerá o projeto automaticamente
7. Marque o Projeto Final Bloco 2 no item **Projects** e clique no botão **Finish** para concluir a importação
 
<br />
 
### 5.2. Executando o projeto
 
1. Na Guia **Boot Dashboard**, localize o  **Projeto Final Bloco 2**
2. Selecione o **Projeto Final Bloco 2**
3. Clique no botão **Start or Restart** <img src="https://i.imgur.com/wdoZqWP.png" title="source: imgur.com" width="4%"/> para iniciar a aplicação
4. Caso seja perguntado se você deseja autorizar o acesso ao projeto via rede, clique no botão **Permitir Acesso**
5. Acompanhe a inicialização do projeto no console do STS
6. Verifique se o banco de dados `db_farmacia` foi criado corretamente e se as tabelas foram geradas automaticamente.
7. Utilize o [Insomnia](https://insomnia.rest/) ou o [Postman](https://www.postman.com/) para testar os endpoints.
 
<br />
 
## 6. Contribuição
 
<br />
 
Este repositório é parte de um projeto educacional, mas contribuições são sempre bem-vindas! Caso tenha sugestões, correções ou melhorias, fique à vontade para:
 
- Criar uma **issue**
- Enviar um **pull request**
- Compartilhar com colegas que estejam aprendendo Java!
 
<br />
 
##  7. Contato
 
<br />
 
Desenvolvido por [**Luan**](https://github.com/Luuh03)
Para dúvidas, sugestões ou colaborações, entre em contato via GitHub ou abra uma issue!
