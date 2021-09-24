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

The first one returns energy consumption data about the given product name. You can make a GET request at https://happliance.herokuapp.com/api/v1/appliances/<u>{name}</u>/get, where {name} is case insensitive and must be written in Portuguese.

The other returns the complete list of appliance names: GET request at https://happliance.herokuapp.com/api/v1/appliances/names/get

Let's search information about "aquecedor de ambiente":

https://happliance.herokuapp.com/api/v1/appliances/aquecedor<u> de ambiente</u><u>/get</u>

Don't worry about blank spaces in your request. Your browser will treat them correctly.

The first requisition may take about 15 seconds to respond because the API is hosted to the Heroku platform for free. Be patient!

You'll get an answer like that:

```
{
    "name": "Aquecedor de ambiente",
    "power": 1550,
    "monthlyUse": 15,
    "dailyUse": 480,
    "averageMonthlyConsumption": 186.0
}
```



|                                     |                       |
| ----------------------------------- | --------------------- |
| name (text)                         | Aquecedor de ambiente |
| power (in Watts)                    | 1550                  |
| monthlyUse (number of days a month) | 15                    |
| dailyUse (number of minutes a day)  | 480                   |
| averageMonthlyConsumption (in kWh)  | 186.00                |

#### You must consider

	- the home appliances technology is always being improved and some information in the database may be outdated;
	
	- the data is generic;
	
	- there are several manufactures for each home appliance and before buying one, ask the salesperson for information about its energy consumption;

#### Here is the list of all home appliances available in the database

| Names                                      |
| ------------------------------------------ |
| Abridor/afiador                            |
| Afiador de facas                           |
| Aparelho de som 3 em 1                     |
| Aparelho de som pequeno                    |
| Aquecedor de ambiente                      |
| Aquecedor de mamadeira                     |
| Ar-condicionado 7.500 btu                  |
| Ar-condicionado 10.000 btu                 |
| Ar-condicionado 12.000 btu                 |
| Ar-condicionado 15.000 btu                 |
| Ar-condicionado 18.000 btu                 |
| Aspirador de pó                            |
| Barbeador/depilador/massageador            |
| Batedeira                                  |
| Boiler 50 e 60 l                           |
| Boiler 100 l                               |
| Boiler 200 a 500 l                         |
| Bomba d"água 1/4 cv                        |
| Bomba d"água 1/2 cv                        |
| Bomba d"água 3/4 cv                        |
| Bomba d"água 1 cv                          |
| Bomba aquário grande                       |
| Bomba aquário pequeno                      |
| Cafeteira elétrica                         |
| Churrasqueira                              |
| Chuveiro elétrico - 4500 W                 |
| Chuveiro elétrico - 5500 W                 |
| Circulador ar grande                       |
| Circulador ar pequeno/médio                |
| Estabilizador/Computador/Impressora        |
| Cortador de grama Grande                   |
| Cortador de grama Pequeno                  |
| Enceradeira                                |
| Escova de dentes Elétrica                  |
| Espremedor de frutas                       |
| Exaustor fogão                             |
| Exaustor parede                            |
| Faca elétrica                              |
| Ferro elétrico automático                  |
| Ferro elétrico automático a seco - 1050 W  |
| Ferro elétrico automático a vapor - 1200 W |
| Fogão comum                                |
| Fogão elétrico 4 chapas                    |
| Forno à resistência Grande                 |
| Forno à resistência Pequeno                |
| Forno micro-ondas                          |
| Freezer Vertical/horizontal                |
| Frigobar                                   |
| Fritadeira elétrica                        |
| Geladeira 1 porta                          |
| Geladeira 2 portas                         |
| Grill                                      |
| Home theater - 350 W                       |
| Iogurteira                                 |
| Lâmpada fluorescente Compacta – 11w        |
| Lâmpada fluorescente Compacta - 15 w       |
| Lâmpada fluorescente Compacta - 23 w       |
| Lâmpada incandescente - 40 w               |
| Lâmpada incandescente - 60 w               |
| Lâmpada incandescente - 100 w              |
| Lâmpada fluorescente compacta - 11 W       |
| Lâmpada fluorescente compacta - 15 W       |
| Lâmpada fluorescente compacta - 23 W       |
| Lâmpada incandescente - 40 W               |
| Lâmpada incandescente - 60 W               |
| Lâmpada incandescente - 100 W              |
| Lavadora de louças                         |
| Lavadora de roupas                         |
| Liquidificador                             |
| Máquina de costura                         |
| Máquina de furar                           |
| Microcomputador                            |
| Moedor de carnes                           |
| Multiprocessador                           |
| Nebulizador                                |
| Ozonizador                                 |
| Panela elétrica                            |
| Pipoqueira                                 |
| Rádio elétrico grande                      |
| Rádio elétrico pequeno                     |
| Rádio relógio                              |
| Sauna                                      |
| Secador de cabelo grande                   |
| Secador de cabelos pequeno                 |
| Secador de cabelo - 1000 W                 |
| Secadora de roupa grande                   |
| Secadora de roupa pequena                  |
| Secretária eletrônica                      |
| Sorveteira                                 |
| Torneira elétrica                          |
| Torneira elétrica - 3250 W                 |
| Torradeira                                 |
| Tv em cores – 14"                          |
| Tv em cores – 18"                          |
| Tv em cores – 20"                          |
| Tv em cores – 29"                          |
| Tv em preto e branco                       |
| Tv portátil                                |
| Ventilador de teto                         |
| Ventilador pequeno                         |
| Vídeocassete                               |
| Vídeogame                                  |

Those data were extract from:

	http://www.procelinfo.com.br/main.asp?View=%7BE6BC2A5F-E787-48AF-B485-439862B17000%7D
	
	http://natureba.com.br/energia-eletrodomesticos.htm

*Free online scholarships, for Brazilian people, can be found at https://lnkd.in/e2f-aeNX*