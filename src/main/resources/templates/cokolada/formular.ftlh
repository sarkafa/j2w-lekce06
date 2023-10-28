[#ftl]
[#import "/spring.ftl" as spring]  <!--  v spring.ftl jsou makra -->
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Obchůdek pro mlsné jazýčky: čokoláda</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div class="container">
    <form class="kosik" action="/cokolada" method="post">
        <h1>Objednávka čokolády</h1>
        <label for="zbozi" class="radek">Zboží:</label> <!-- za dvojteckou je to co se ma zobrazit a vlevo co se posle do controlleru -->
        [@spring.formSingleSelect path="form.zbozi" options={
        "": "",
        "1": "bílá",
        "2": "mléčná",
        "3": "hořká"
        } /]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <label for="jmeno" class="radek">Jméno a příjmení:</label>
        [@spring.formInput path="form.jmeno" /] <!-- říká se tomu volání makra ve freemarkeru, neni tam hash, ale @ -->
        <!-- vytvori html input  a v path rika co ma naplnit - v modelu mam atribut form (javabean) -->
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <label for="vek" class="radek">Věk:</label>
        [@spring.formInput path="form.vek" fieldType="number" /]
        <div class="error">[@spring.showErrors "<br>"/]</div>  <!-- podívá se jestli tam mají být chyby a zobrza
         class errro je zobrazí červeně -->

        <label for="email" class="radek">E-mail:</label>
        [@spring.formInput path="form.email" fieldType="email" /]
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <div class="radek">
            [@spring.formCheckbox path="form.obchodniPodminky" /]
            <label for="obchodniPodminky">Souhlasím s obchodními podmínkami</label>
        </div>
        <div class="error">[@spring.showErrors "<br>"/]</div>

        <div class="radek controls">
            <button type="submit">Objednat</button>
        </div>
        <!--
        Formulář bude obsahovat:
        * výběr z druhů čokolády, např.: mléčná, bíla, hořká (select)
        * Jméno a příjmení (input)
        * e-mail – volitelný údaj (input)
        * souhlas s obchodními podmínkami (check box)
        -->
    </form>
</div>
</body>
</html>
