# music-poc
Music POC Test for Sinax

##ATIVIDADE

Crie um cadastro de músicas (nome, banda e duração) utilizando as seguintes tecnologias:

a) Página dinâmica utilizando JavaScript . Você pode utilizar APIs apropriadas, como JQuery

ou AngularJS;

b) Comunicação com servidor através de serviços RESTFUL com JAX-RS;

c) Persistência com JPA 2.0;

O sistema também deve disponibilizar uma tela de busca por nome da música.

## RESOLUÇÃO

``` bash
$ git clone git@github.com:pflima92/music-poc.git
$ cd music-poc
```

### music-poc-view

Single Page Application contruída com AngularJS a fim de realizar POC proposta.

Para executar:

```
$ cd music-poc
$ npm install
$ bower install
$ gulp serve

* Aplicação devera ser executada na porta: 3000.

```

### music-poc-svc 

API RESTFul contruída com JAX-RS.

Servidor de aplicação stand alone: Jetty.
Banco de dados: H2.

Para executar:
```
$ gradle fatJar
$ java -jar build/libs/music-poc-svc-all-1.0.jar

* Aplicação devera ser executada na porta: 8080.
```


