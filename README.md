## SibFast
### Проект сервиса доставки, написанный во время участия в интенсиве ШИФТ

Личный вклад в проект:
* проектирование и доработка API
* DTO объекты
* маппинг

Предварительные требования:
* JDK 17
* Docker

Процедура запуска:
1. Разверните в докере базу данных
2. Затем войдите в cqlsh и введите команды из файла init.cql
3. Запускайте проект: или средствами вашей IDE, или с помощью командной строки (java -jar delivery-1.0.0.jar)
4. Тесты для проверки проекта находятся в файле delivery.json
