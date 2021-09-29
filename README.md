# Home Appliances' energy consumption REST API

This project was created to provide information about brazilian home appliances' energy consumption.

*Free online scholarships, for Brazilian people, can be found at https://lnkd.in/e2f-aeNX*

The API status may be consulted at https://happliance.herokuapp.com/actuator/health

The API documentation is available at https://happliance.herokuapp.com/swagger-ui.html

| Description                              | Auth | HTTPS | CORS    |
| ---------------------------------------- | ---- | ----- | ------- |
| Brazilian home appliances' energy consumption | No   | Yes   | Yes |

### Endpoints
There are two endpoints available.

The first one returns energy consumption data about the given product name. You can make a GET request at https://happliance.herokuapp.com/api/v1/appliances/name?name={appliance name}, where {appliance name} is case insensitive and must be written in Portuguese.

The other returns the complete list of appliance names: GET request at https://happliance.herokuapp.com/api/v1/appliances/names/get

Let's search information about "Enceradeira":

https://happliance.herokuapp.com/api/v1/appliances/name?name=enceradeira

Don't worry if there are blank spaces or accented words in your request. The browser will treat them correctly.

The first requisition may take about 15 seconds to respond because the API is hosted to the Heroku platform for free. Be patient!

You'll get an answer like that:

```
{
    "name": "Enceradeira",
    "power": 500,
    "monthlyUsage": 2,
    "dailyUse": 120,
    "monthlyConsumptionAverage": 2.0
}
```



|                                    |             |
| ---------------------------------- | ----------- |
| name (text)                        | Enceradeira |
| power (in Watts)                   | 500         |
| monthlyUsage (days a month)        | 2           |
| dailyUse (minutes a day)           | 120         |
| monthlyConsumptionAverage (in kWh) | 2.00        |

#### You must consider

	- the home appliances technology is always being improved and some information in the database may be outdated;
	
	- the data is generic;
	
	- there are several manufactures for each home appliance and before buying one, ask the salesperson for information about its energy consumption;

#### Here is the list of all home appliances available in the database

| Names                                   |
| --------------------------------------- |
| Abridor-afiador                         |
| Abridor                                 |
| Afiador                                 |
| Afiador de facas                        |
| Aparelho de som 3 em 1                  |
| Aparelho de som pequeno                 |
| Aquecedor de ambiente                   |
| Aquecedor de mamadeira                  |
| Ar condicionado 7500 btus               |
| Ar condicionado 10000 btus              |
| Ar condicionado 12000 btus              |
| Ar condicionado 15000 btus              |
| Ar condicionado 18000 btus              |
| Aspirador de pó                         |
| Barbeador depilador massageador         |
| Barbeador                               |
| Depilador                               |
| Massageador                             |
| Batedeira                               |
| Boiler 50 litros                        |
| Boiler 60 litros                        |
| Boiler 100 litros                       |
| Boiler 200 a 500 litros                 |
| Bomba de água 1/4 cv                    |
| Bomba de água 1/2 cv                    |
| Bomba de água 3/4 cv                    |
| Bomba de água 1 cv                      |
| Bomba de aquário grande                 |
| Bomba de aquário pequeno                |
| Cafeteira elétrica                      |
| Churrasqueira                           |
| Chuveiro elétrico 4500W                 |
| Chuveiro elétrico 5500W                 |
| Circulador ar grande                    |
| Circulador ar pequeno médio             |
| Computador                              |
| Cortador de grama Grande                |
| Cortador de grama Pequeno               |
| Enceradeira                             |
| Escova de dentes Elétrica               |
| Espremedor de frutas                    |
| Estabilizador                           |
| Exaustor fogão                          |
| Exaustor parede                         |
| Faca elétrica                           |
| Ferro elétrico automático a seco 1050W  |
| Ferro elétrico automático a vapor 1200W |
| Ferro elétrico automático               |
| Fogão comum                             |
| Fogão elétrico 4 chapas                 |
| Forno à resistência Grande              |
| Forno à resistência Pequeno             |
| Forno microondas                        |
| Freezer Vertical horizontal             |
| Frigobar                                |
| Fritadeira elétrica                     |
| Geladeira 1 porta                       |
| Geladeira 2 portas                      |
| Grill                                   |
| Home theater 350W                       |
| Impressora                              |
| Iogurteira                              |
| Lâmpada fluorescente Compacta 11W       |
| Lâmpada fluorescente Compacta 15W       |
| Lâmpada fluorescente Compacta 23W       |
| Lâmpada incandescente 40W               |
| Lâmpada incandescente 60W               |
| Lâmpada incandescente 100W              |
| Lavadora de louças                      |
| Lavadora de roupas                      |
| Liquidificador                          |
| Máquina de costura                      |
| Máquina de furar                        |
| Microcomputador                         |
| Moedor de carnes                        |
| Multiprocessador                        |
| Nebulizador                             |
| Ozonizador                              |
| Panela elétrica                         |
| Pipoqueira                              |
| Rádio elétrico grande                   |
| Rádio elétrico pequeno                  |
| Rádio relógio                           |
| Sauna                                   |
| Secador de cabelo 1000W                 |
| Secador de cabelo grande                |
| Secador de cabelos pequeno              |
| Secadora de roupa grande                |
| Secadora de roupa pequena               |
| Secretária eletrônica                   |
| Sorveteira                              |
| Torneira elétrica 3250W                 |
| Torneira elétrica                       |
| Torradeira                              |
| Tv em cores 14 polegadas                |
| Tv em cores 18 polegadas                |
| Tv em cores 20 polegadas                |
| Tv em cores 29 polegadas                |
| Tv em preto e branco                    |
| Tv portátil                             |
| Ventilador de teto                      |
| Ventilador pequeno                      |
| Vídeocassete                            |
| Vídeogame                               |


Those data were extract from:

	http://www.procelinfo.com.br/main.asp?View=%7BE6BC2A5F-E787-48AF-B485-439862B17000%7D
	
	http://natureba.com.br/energia-eletrodomesticos.htm

*Free online scholarships, for Brazilian people, can be found at https://lnkd.in/e2f-aeNX*