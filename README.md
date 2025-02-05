# Opis projekta

Projekt je okvir (framework) za automatsko testiranje web aplikacije koristeći Selenium WebDriver. Cilj je bio demonstrirati tehnike automatiziranog testiranja naučene tijekom laboratorijskih vježbi.

# Tehnologije i alati

Java – glavni programski jezik
Maven – za upravljanje ovisnostima
Selenium WebDriver – za automatizaciju web preglednika
TestNG – za upravljanje i izvršavanje testova
WebDriverManager – za automatsko upravljanje driverima preglednika
Git – za verzioniranje koda

# Testni slučajevi

ValidLoginTest – Provjera uspješnog prijavljivanja s ispravnim podacima.
InvalidLoginTest – Provjera poruke o grešci prilikom prijave s neispravnim podacima.
AddToCartTest – Dodavanje proizvoda u košaricu.
RemoveFromCartTest – Uklanjanje proizvoda iz košarice.
SortItemsTest – Provjera sortiranja proizvoda po cijeni.

# Struktura projekta

Projekt koristi Page Object Model (POM) za bolju organizaciju koda i održavanje.
pages/ – Definicije stranica aplikacije (LoginPage, InventoryPage, CartPage)
test/ – Testne klase podijeljene prema funkcionalnostima (login, cart, inventory)
utils/ – Pomoćne klase kao što je DriverSetup

# Pokretanje testa

`mvn clean install`
`mvn test`
