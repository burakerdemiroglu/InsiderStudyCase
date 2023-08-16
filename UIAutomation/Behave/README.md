#  Insider UI Test Otomasyon Projesi (Python/Behave)

Merhaba, bu projede Python dilinde Pytest ile Behave kütüphaneleri kullanılarak LcWaikiki sitesinin UI(User Interface) testleri yapılmaktadır.

Behave Python içerisinde BDD uygulamalarını yürütmesine izin veren en iyi Python frameworklerinden biridir. BDD(Behaviour Driven Development) ile, yazılım süreçlerinin daha test odaklı gitmesini sağlayan ve prensip olarak öncelikli olarak test kodları yazılıp daha sonrasında proje kodu yazılsın anlayışını benimsemektedir.  

 
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
    Then Anasayfaya geri dönülür."
```

https://github.com/burakerdemiroglu/InsiderStudyCase/assets/35409987/3cf808e6-fa88-44e6-ab36-955b7f2b689d
  
## ![allure](https://user-images.githubusercontent.com/35347777/187071905-8bad55fd-b3e4-4154-8af9-b10d313c5dd5.png) Allure 

<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>
 
![Allure](https://github.com/burakerdemiroglu/InsiderStudyCase/assets/35409987/7d8dea0d-d9db-4b6c-9e89-c3d44d8ae86a)

</details>
