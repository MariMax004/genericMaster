Задания

1. CountMap - счетчик объектов. Нужно обобщить интерфейс и добавить 2 реализации: обобщенную CounterMapImpl и конкретную IntCounterMap.
2. Election - механизм проведения анамимных выборов, результаты можно получить вызовом метода getResults. Результаты должны быть анонимными (т.е. не раскрывать конкретных избирателей), при этом позволяя проверить получить распределение по полам и группам возрастов избирателей, проголосовавщих за каждого кандидата.
   2.1 Создать enum:   
    Gender – это enum из двух элементов: MALE и FEMALE. 
    AgeCategory – это enum из четырех элементов (названия придумайте сами), которые должны отражать следующие возрастные категории и инкапсулировать в себе их границы: 
       1) 18-29 лет 
       2) 30-49 лет
       3) 50-64 года
       4) 65 лет и более
     2.2 Создать интерфейс Voter (избиратель), который будет содержать следующие методы:  
        Gender getGender(); // пол
         [AgeCategory getAgeCategory()](); // возрастная категория 
   2.2 Написать две реализации интерфейса Voter: Man и Woman. Каждая из реализаций должна соответствующим образом хардкодить значение метода getGender, а для избегания copy/paste для хранения AgeCategory можете создать промежуточный абстрактный класс (например, VoterBase), который будет хранить данное поле
     2.3 Написать программу, которая будет имитировать голосование людей на выборах с указанием данных для сбора статистики.
3. Пакет bank описывает клиентов банка и их счета.
    3.1 Создать 2 обобщенные реализации интерфейса Balance - Card и Account, обобщение ограничено наслдниками абстрактного класса Currency.
    3.2 Создать обобщенный класс Account, обобщение обграничено реализациями интерфейса Balance.
    3.3 Создать 3 класса валют (расширение Currency), вынеся в базовый класс общие свойства
    3.4 Реализовать клиента (Client), у которого может быть несколько счетов и карт с разными валютами
    3.5 Реализовать генератов случайных клиентов с их счетами и картами - RandomClientFactory.nextClient()
    3.5 Реализовать метод ClientUtils.printBalance, выводящий текущие остатки по всех счетам клиента в виде строки
    