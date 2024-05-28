## MultiSearch Project - Backend

## Sobre
&nbsp;&nbsp; Neste projeto desenvolvi uma API simplificada de uma aplicação de buscas. As buscas são realizadas pelo [frontend](https://github.com/erik-ymmt/multi-search-front). Ao receber uma string, o backend retorna todos os resultado que contém o termo pesquisado. Os dados são extraídos de arquivos JSON.

## Tecnologias:
- Java;
- Spring Boot (+ Maven);
- Docker (para subir imagem no deploy da Render.com);

## Como rodar o projeto:
- Através da configuração do frontend (canto superior esquerdo), selecione "Backend Nuvem", o projeto já está hospedado na Render.com, basta aguardar que ele inicie.

  OU
- Faça um clone do repositório;
- Certifique-se que possui JDK e Maven instalados;
- Navegue até a raiz e inicie a aplicação (MultiSearchBackApplication.java) da maneira que preferir (algumas IDEs já possuem um início rápido) ou através do comando `./mvnw spring-boot:run`;
- O frontend irá chamar a porta 8080, o backend está configurado para rodá-la como padrão, portanto, certifique-se que ela está livre.
- Pronto! Agora é possível realizar as buscas pelo [frontend](https://github.com/erik-ymmt/multi-search-front).
