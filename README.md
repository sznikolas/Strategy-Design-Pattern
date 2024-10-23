# Strategy Pattern with Spring-Provided Factory Mechanism

**This design can be viewed as a combination of the Strategy and Factory design patterns.**

1. **Strategy Pattern:**
   
  - The purpose of the Strategy pattern is to define different algorithms (or strategies) and select the appropriate one at
  runtime.
  The interface (PaymentProcessor) defines the common operations, but the implementation (for example, PayPal and
  GooglePay) represents different strategies for the payment process. In the processPayment method, the strategy is
  selected, meaning the PaymentProcessor implementation (e.g., PayPal or GooglePay) is chosen at runtime based on the
  paymentProcessorMap, which is a key characteristic of the Strategy pattern.

2. **Factory Pattern:**
- The Factory pattern is characterized by the creation of an object in a central place, and the appropriate instances are
returned based on a specific type. In this context, the Spring framework acts as the Factory, as Spring manages the
PaymentProcessor beans, and the various gateways (PayPal, GooglePay) are registered within it. The paymentProcessorMap
contains the registered types, and the correct implementation is selected based on the gateway key.

**In Summary:**
- This is primarily based on the Strategy pattern because different payment processors implement the shared interface, and
the system dynamically selects which implementation to use at runtime. The Factory mechanism provided by the Spring
framework is also a part of the design since the object selection is managed via bean injection, though there is no
explicit Factory implementation in the code.





&nbsp;&nbsp;&nbsp;
# Strategy Pattern Spring által nyújtott Factory mechanizmussal

**Ez a tervezés leginkább Strategy és Factory design pattern kombinációjának tekinthető.**

1. **Strategy Pattern:** 

- A Strategy minta célja, hogy különböző algoritmusokat (vagy stratégiákat) definiáljunk, majd futásidőben válasszuk ki a
megfelelő algoritmust. Az interfész (PaymentProcessor) definiálja a közös műveleteket, de az implementáció (például
PayPal és GooglePay) különböző stratégiákat képvisel a fizetési folyamatra vonatkozóan.
A processPayment metódusnál történik meg a stratégia kiválasztása, azaz a PaymentProcessor implementáció (pl. PayPal
vagy GooglePay) futásidőben kerül kiválasztásra a paymentProcessorMap alapján, ami nagyon jellegzetes a Strategy
mintára.

2. **Factory Pattern:**

- A Factory mintára jellemző, hogy egy objektum létrehozása egy központi helyen történik, és a létrehozott példányok
megfelelő típusok alapján kerülnek visszaadásra.
Ebben a kontextusban a Spring keretrendszer a Factory szerepét tölti be, mivel a Spring kezeli a PaymentProcessor típusú
bean-eket, és a különböző gateway-ek (PayPal, GooglePay) regisztrálva vannak benne. A paymentProcessorMap lényegében a
bejegyzett típusokat tartalmazza, és a megfelelő implementáció kerül kiválasztásra a gateway kulcs alapján.

**Összefoglalva:**
- Ez Strategy mintán alapul, mert a különböző fizetési feldolgozók implementálják a közös interfészt, és futásidőben kerül
kiválasztásra, melyik implementációt használja a rendszer.
A Spring keretrendszer által biztosított Factory mechanizmus része a designnak, hiszen a bean-ek injektálásával
létrehozott objektumok választása a logikához hasonlóan működik, de maga a Factory explicit módon nincs megvalósítva a
kódban.

**API endpoint: POST - http://localhost:8080/api/v1/payments?gateway=PayPal**

```\json
{
  "amount": 100,
  "currency": "EUR"
}
```

