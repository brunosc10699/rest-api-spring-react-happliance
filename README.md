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
| Aspirador de p??                         |
| Barbeador depilador massageador         |
| Barbeador                               |
| Depilador                               |
| Massageador                             |
| Batedeira                               |
| Boiler 50 litros                        |
| Boiler 60 litros                        |
| Boiler 100 litros                       |
| Boiler 200 a 500 litros                 |
| Bomba de ??gua 1/4 cv                    |
| Bomba de ??gua 1/2 cv                    |
| Bomba de ??gua 3/4 cv                    |
| Bomba de ??gua 1 cv                      |
| Bomba de aqu??rio grande                 |
| Bomba de aqu??rio pequeno                |
| Cafeteira el??trica                      |
| Churrasqueira                           |
| Chuveiro el??trico 4500W                 |
| Chuveiro el??trico 5500W                 |
| Circulador ar grande                    |
| Circulador ar pequeno m??dio             |
| Computador                              |
| Cortador de grama Grande                |
| Cortador de grama Pequeno               |
| Enceradeira                             |
| Escova de dentes El??trica               |
| Espremedor de frutas                    |
| Estabilizador                           |
| Exaustor fog??o                          |
| Exaustor parede                         |
| Faca el??trica                           |
| Ferro el??trico autom??tico a seco 1050W  |
| Ferro el??trico autom??tico a vapor 1200W |
| Ferro el??trico autom??tico               |
| Fog??o comum                             |
| Fog??o el??trico 4 chapas                 |
| Forno ?? resist??ncia Grande              |
| Forno ?? resist??ncia Pequeno             |
| Forno microondas                        |
| Freezer Vertical horizontal             |
| Frigobar                                |
| Fritadeira el??trica                     |
| Geladeira 1 porta                       |
| Geladeira 2 portas                      |
| Grill                                   |
| Home theater 350W                       |
| Impressora                              |
| Iogurteira                              |
| L??mpada fluorescente Compacta 11W       |
| L??mpada fluorescente Compacta 15W       |
| L??mpada fluorescente Compacta 23W       |
| L??mpada incandescente 40W               |
| L??mpada incandescente 60W               |
| L??mpada incandescente 100W              |
| Lavadora de lou??as                      |
| Lavadora de roupas                      |
| Liquidificador                          |
| M??quina de costura                      |
| M??quina de furar                        |
| Microcomputador                         |
| Moedor de carnes                        |
| Multiprocessador                        |
| Nebulizador                             |
| Ozonizador                              |
| Panela el??trica                         |
| Pipoqueira                              |
| R??dio el??trico grande                   |
| R??dio el??trico pequeno                  |
| R??dio rel??gio                           |
| Sauna                                   |
| Secador de cabelo 1000W                 |
| Secador de cabelo grande                |
| Secador de cabelos pequeno              |
| Secadora de roupa grande                |
| Secadora de roupa pequena               |
| Secret??ria eletr??nica                   |
| Sorveteira                              |
| Torneira el??trica 3250W                 |
| Torneira el??trica                       |
| Torradeira                              |
| Tv em cores 14 polegadas                |
| Tv em cores 18 polegadas                |
| Tv em cores 20 polegadas                |
| Tv em cores 29 polegadas                |
| Tv em preto e branco                    |
| Tv port??til                             |
| Ventilador de teto                      |
| Ventilador pequeno                      |
| V??deocassete                            |
| V??deogame                               |


Those data were extract from:

	http://www.procelinfo.com.br/main.asp?View=%7BE6BC2A5F-E787-48AF-B485-439862B17000%7D
	
	http://natureba.com.br/energia-eletrodomesticos.htm

*Free online scholarships, for Brazilian people, can be found at https://lnkd.in/e2f-aeNX*