# desafio-backend-fluig
API Rest para previsão de consumo de combustível de veículos utilizados para entrega de produtos de uma empresa 


- Comando para criar um container mysql que sera utilizado pela aplicação

```
$ docker container run -d -p 3307:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes --name veiculo-mysql mysql:8.0
```
