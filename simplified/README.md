<h1>
   <p> 
      <img src="https://user-images.githubusercontent.com/92659173/208775299-8a384f52-7cbe-4af6-8d11-2de7d61b3a1e.svg" width="100" align="center" />
      <img src="https://user-images.githubusercontent.com/92659173/208777593-0b0906f0-2e13-420f-a435-b78f0151671e.png" width="100" align="center" />
     
      AA3 - Sistema para locação de bicicletas (API REST)
   </p>
   <img src="https://img.shields.io/github/license/vinimrs/VinChat?color=black" align="center" />
</h1>

Projeto de implementação de uma aplicação web de um sistema para locações de bicicletas online utilizando as tecnologias **Java [Spring Boot] para o desenvolvimento de uma [API REST]**, com objetivo de coNtemplar as principais responsabilidades de uma locação de bicicleta explorando e conhecendo melhor como funciona o desenvolvimento de sistemas web.

<p align="center">

   <img src="https://github.com/vinimrs/AA3/assets/92659173/a049e76c-6a65-4879-9793-effb81320359"  width="800"/>
   <p align="center">
      <i>Coleção de requisições para a API - Postman
</i>
   </p>
</p>

Tal sistema foi projetado e desenvolvido durante o curso de _Desenvolvimento de Software para a Web 1_ da _Universidade Federal de São Carlos (UFSCar)_, ministrado pelo Prof. Alan Demetrius Baria Valejo, cujo objetivos acadêmicos gerais são:

> Familiarizar o estudante com os principais conceitos do desenvolvimento de software para web; capacitar o estudante a desenvolver aplicações web pelo lado do servidor (back-end).

## :hammer: Funcionalidades

As funcinalidades deste sistema foram baseadas no [documento de requisitos](https://github.com/vinimrs/AA3/blob/main/requisitos.pdf) proposto pelo professor durante a disciplina.

- `Funcionalidade 1` `Gerenciamento de usuários`: O sistema permite que um super usuário (administrador) gerencie (CRUD) todos os usuários do sistema, tais como locaodoras e clientes.
- `Funcionalidade 2` `Locação de bicicletas`: O sistema permite que clientes aluguem bicicletas em certa data das locadoras disponíveis no sistema.
- `Funcionalidade 3` `Navegação sem login`: O sistema fornece interfaces para usuários não logados conseguirem utilizar o sistema sem um cadastro.
- `Entre outras...`.

<!--
<p align="center">
   <img src="https://user-images.githubusercontent.com/92659173/208769107-f9583f61-f9dd-45d7-bc2c-fbfdb548e14f.gif" width="300px" />
</p>
-->

## :electric_plug: Testando o projeto

Para testar o projeto, você deve primeiramente cloná-lo em sua máquina:

```bash
git clone https://github.com/vinimrs/AA3.git
cd AA3/
```

Após isso, abra o projeto em sua IDE java de preferência (foi utilizado a IntelliJ IDEA para o desenvolvimento). E inicialize a aplicação na versão 20 do Java pela classe `LocadoraAplicattion`.

Será necessário criar um banco de dados local chamado `locadora` no SGBD postgresql com super usuário `postgres` e senha `postgres`.

Depois de inicializar você pode testar a API a partir de serviços como o [Postman](https://www.postman.com/). Importe a [coleção de requisições](https://github.com/vinimrs/AA3/blob/main/requests.json) no serviço escolhido e comece a testar. Você pode seguir o [tutorial de importação](https://learning.postman.com/docs/getting-started/importing-and-exporting/importing-data/#importing-postman-data) do Postman se for utilizá-lo.  

## :zap: Tecnologias

- [Spring Boot]
- [API REST]

<!--
## ✅ Melhorias

Ideias de melhorias para o projeto:
-->

[Spring Boot]: https://spring.io/projects/spring-boot
[API REST]: https://www.redhat.com/pt-br/topics/api/what-is-a-rest-api

