# Kata 'Indiana Jones et le Temple du code Legacy'

Ce code est un exercice pour apprendre à faire évoluer fonctionnellement du code Legacy en prenant le temps d'écrire des tests unitaires et de refactorer.

Vous avez besoin de Maven 3 et d'un JDK 8 pour cet exercice

Vous avez deux web services qui se lance en tapant la commande :
`mvn clean install tomcat6:run`

## Premier refactoring
refactorer le premier web service accessible à l'URL [http://localhost:8080/indianajones/rest/results] en affichant le turnover qui manque au rapport.
Le XML affiché a cette forme là :
```xml
<report>
	<title>Quaterly Report</title>
    <frame>2012 - 2012</frame>
    <results>
        <result>
            <lob>UX</lob>
            <manager>Bob</manager>
            <net>40.0</net>
            <alertNet>Alert : Net Profit too low</alertNet>
            <operatingExpense>80.0</operatingExpense>
            <alertExpense>Alert : Too much notes</alertExpense>
    	</result>
    </results>
</report>
```
Il doit maintenant ressembler à ça :
```xml
<report>
	<title>Quaterly Report</title>
    <frame>2012 - 2012</frame>
    <results>
        <result>
            <lob>UX</lob>
            <manager>Bob</manager>
            <net>40.0</net>
            <alertNet>Alert : Net Profit too low</alertNet>
            <operatingExpense>80.0</operatingExpense>
            <alertExpense>Alert : Too much notes</alertExpense>
            <turnover>11</turnover>
    	</result>
    </results>
</report>
```

Veillez à rendre le code le plus propre possible avec un maximum de tests unitaires (vous pouvez utiliser Mockito).
Vous avez à peu près 15 minutes ...

## Deuxième refactoring
refactorer le premier web service accessible à l'URL [http://localhost:8080/indianajones/json/results] en affichant des élements supplémentaires.
Le JSON affiché a cette forme là :
```javascript
[{"manager":"Mathieu","departement":"Media","operatingExpense":4000.0,"netProfit":4000.0,"year":2013,"underKpiMessage":true,"tooMuchExpenseMessage":true,"turnover":9}]
```
Il doit maintenant ressembler à ça :
```javascript
[{"manager":"Mathieu","year":2013,"underKpiMessage":"ALERT KPI","tooMuchExpenseMessage":"ALERT EXPENSE","departement":"Media","netProfit":4000.0,"operatingExpense":4000.0,"underKpi":true,"hasTooMuchExpense":true,"turnover":9}]
```
Encore une fois, veillez à rendre le code le plus propre possible avec un maximum de tests unitaires (vous pouvez utiliser Mockito).
Et vous avez encore à peu près 15 minutes ...

