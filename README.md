## Парсер JSON авиабилетов
### Задачи:
1. Обработать `tickets.json` (локальный файл)
2. Рассчитать минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика
3. Рассчитать разницу между средней ценой и медианой для полета между городами Владивосток и Тель-Авив

Проект собран на __Maven__. Для сборки исполняющего `jar-файла` необходимо выполнить команду (перед началом `mvn clear`) `mvn package`.
Или воспользоваться уже собранным [jar-файлом](https://drive.google.com/file/d/1qOJLPrmtk0hb2IQ_rfSNtCIeITRbQHnO/view?usp=sharing).
Для запуска _jar-файла_ из командной строки (Linux/Windows с настроенным окружением), перейдите в директорию с файлом и используйте команду:

`java -jar json_parser_ticket-1.0-SNAPSHOT-jar-with-dependencies.jar`

Пример: `C:\projects\json_parser_ticket\target> java -jar json_parser_ticket-1.0-SNAPSHOT-jar-with-dependencies.jar`

Результат выполнения:

![](https://i.ibb.co/rsxtq2H/Json-parser-rsl-sample.png)

Содержимое _jar-файла_ через [`jd-gui`](http://java-decompiler.github.io/):

![](https://i.ibb.co/HBvBTCF/jar-json-parser.png)