# Insider UI Test Otomasyon Projesi (Java/Cucumber)

Bu projede Insider tarafından verilen case oluşturulmuş olup senaryoların POM kullanılarak koşulması sağlanmıştır. 

Proje Özellikleri
--- 
- Java & Selenium frameworkü ile geliştirilmiştir. Mimaride POM(Page Object Model) kullanılmıştır.   
- Annotasyonlar ve assertionlar için JUnit kütüphanesi kullanılmıştır.
- Test sonuçlarının raporlanması adına Log4j kullanılmıştır. Adımlar logs klasöründeki log4j-application.log dosyasından adımlar izlenebilir.
- Testlerin monitoring edilebilmesi için allure report kullanılmıştır.
- Test'in fail olma durumuna karşın ekran görüntüsü kaydetmektedir. Allure report içerisinde hata adımı ve ekran görüntüsü gözlemlenebilir.
- WebDriverManager kullanılmıştır. Böylelikle her browser için farklı bir driver indirmemek ve aksini belirtmedikçe driverın son versiyonunu indirmesi için.
- ConfigReader ile resources klasörü altındaki app.properties dosyası üzerinden baseUrl, browser seçimleri yapılabilmektedir.
- JUnit kütüphanesi kullanılmıştır. 

Task
---
- https://www.lcwaikiki.com/tr-TR/TR adresine gidin.
- Herhangi bir kategori sayfasına gidin.
- Herhangi bir ürün sayfasına gidin.
- Ürünü sepete ekleyin.
- Sepet sayfasına gidin.
- Anasayfaya geri dönün.

Notlar:
- Chrome driver kullanılacak.
- İstediğiniz programlama dili kullanılabilir.
- Tercihen Page Object Model yapısı kullanılabilir.
- Locator’lar sayfanın üst bölümünde tanımlanacak.
- Test bittikten sonra driver kapatılacak.
- Sayfaların doğruluğunun kontrolü için her adımda assertion kullanılacak.

## 👨🏿‍💻 Senaryo

```cucumber
Feature: Insider UI Test

  @positive
  Scenario: Ürünü Sepete Ekleme ve Sepeti Kontrol Etme
    Given "https://www.lcwaikiki.com/tr-TR/TR" adresine gidilir.
    And Herhangi bir kategori sayfasına gidilir.
    And Herhangi bir ürün sayfasına gidilir.
    And Ürün sepete eklenir.
    When Sepet sayfasına gidilir.
    Then Anasayfaya geri dönülür.
```

[https://burakerdemiroglu.com.tr/Insider/Videos/CucumberUsage.mp4](https://github.com/burakerdemiroglu/InsiderStudyCase/assets/35409987/c4219cb9-0ac0-4450-aa21-4a01ba229b69)

## ![log4j](https://user-images.githubusercontent.com/35347777/187072045-4d157e04-a467-47cd-8b07-875b9b2b7887.png) Log4j 
 
<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>

![log4j](https://github.com/burakerdemiroglu/InsiderStudyCase/assets/35409987/1db57d0f-fffe-4240-8fb0-8d975f80c6d8)

</details>
  
## ![allure](https://user-images.githubusercontent.com/35347777/187071905-8bad55fd-b3e4-4154-8af9-b10d313c5dd5.png) Allure

 Allure raporunu detaylı incelemek için [*buraya*](https://burakerdemiroglu.com.tr/Insider/Allure) tıklayınız.

<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>

![Allure](https://github.com/burakerdemiroglu/InsiderStudyCase/assets/35409987/87bfb3ab-5f4a-4ea5-8e86-a14ecaff3579)

</details>
