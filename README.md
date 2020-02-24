# DigitalMaps API

## 1 - Detalhes sobre o serviço

A DigitalMaps é uma empresa especializada na produção de receptores GPS. A
organização está empenhada em lançar um dispositivo que promete auxiliar pessoas
na “localização de pontos de interesse”.<br>

O serviço Permite a inserção de novas localizações de ponto de interesse com coordenadas geográficas referentes à este ponto de interesse (X e Y) e horário de funcionamento (abertura e
fechamento). <br>

● Obs1: Coordenadas devem ser números inteiros positivos. <br>
● Obs2: Estas informações sao armazenadas em uma base dados.. <br>
● Obs3: Para pontos como a praça, não deve haver horário de funcionamento. <br>

O serviço permite a listagem de todos os pontos de interesse cadastrados. <br>
O serviço permite a listagem de todos os pontos de interesse por proximidade,
 fornecendo as coordenadas X e Y, a distância em metros e hora atual. <br>


## 1 - Tecnologias Utilizadas 
  
- Java 8. <br>  
- Spring Boot 2.2.4. <br> 
- Maven. <br>
- Spring Tools 4. <br> 

## 2 - Considerações de Desenvolvimento

- As APIs deverão segue o modelo RESTFul com formato JSON. <br>
- Foram desenvolvidos testes unitários. <br>

## 2 - Requisitos para rodar aplicação

- Java SE Development Kit 8 instalado na maquina. <br>

## 3 - Documentaçao  
  
 - **Swagger** gerar automaticamente a documentação dos endpoints da API.
 Apos a aplicação se iniciada ela se encotra no seguinte endereço: 
 http://localhost:8080/swagger-ui.html 

  
 <img src="https://github.com/pauloricardodn/digitalmaps/blob/master/swagger.png"/>
 
 Exemplo de json quando ponto de interesse tem horario de funcionamento: <br> 
 <img src="https://github.com/pauloricardodn/digitalmaps/blob/master/jsonhorario.png"/>

 Exemplo de json quando ponto de interesse tem horario de funcionamento: <br> 
 <img src="https://github.com/pauloricardodn/digitalmaps/blob/master/jsonshorario.png"/>
  

  



  

