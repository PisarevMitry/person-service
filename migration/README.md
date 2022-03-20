### Не забудьте перейти в папку migration перед запуском
#### -P можно в каждой команде заменить на -Denv= (замена профиля на параметр запуска команды)
#### Для выборочного наката миграции можно указать контекст -Dliquibase.contexts=[название контекстов через ,] (если не указать то накатываются вне зависимости от контекста) 
#### Можно ставить теги при запуске миграции для удобного отката через rollback -Dliquibase.tag=myTag
#### Если указать лэйбл при накате -Dliquibase.labels=[название лейблов через ,] то будут накачены все changeSet в котором он указан и все в которых нету никаких лейблов (если не указать то накатываются вне зависимости от лейблов) 
- Применение миграции
```
mvn -Plocal "-Dliquibase.labels=main" liquibase:update "-Dliquibase.tag=.." 
```
- Посмотреть SQL запросы, которые выполнятся при миграции
```
mvn -Plocal "-Dliquibase.contexts=main" liquibase:updateSQL
```
- Откатить последний changeSet
```
mvn -Plocal liquibase:rollback "-Dliquibase.rollbackCount=1"
```
- Откатить к миграцию по тэгу (должен быть указан при накате миграции)
```
mvn -Plocal liquibase:rollback "-Dliquibase.rollbackTag=tag_1" 
```
- Проверка статуса миграции (покажет все незадеплоеные changeSets)
```
mvn -Plocal liquibase:status "-Dliquibase.verbose"
```

