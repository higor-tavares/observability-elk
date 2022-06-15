# OBSERVABILITY ELK
Projeto de estudos da integração do Spring Boot e a stack ELK.

## Requisitos
* Java 11
* Maven
* Docker
* docker-compose
* Um computador com mais de 8GB de ram 😭


## Como executar
Com o Docker e o Docker-compose previamente instalados, rode o comando make dependencies, aonde serão iniciados um container ElasticSearch e um container do Kibana.
Em seguida rode um projeto na sua IDE ou rode um make package e depois um make run

## Como testar
Uma vez que seu projeto está rodando acesse http://localhost:5601, clique na aba discovery em seguida crie um indice pattern para logstash* agora ao acesse http://localhost:8080/hello e novamente acesse http://localhost:5601/app/discover#/ agora é possivel ver os logs gerados pela aplicação spring


