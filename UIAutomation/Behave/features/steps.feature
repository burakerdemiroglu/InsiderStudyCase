Feature: Insider UI Test

  @positive
  Scenario: Ürünü Sepete Ekleme ve Sepeti Kontrol Etme
    Given "https://www.lcwaikiki.com/tr-TR/TR" adresine gidilir.
    And Herhangi bir kategori sayfasına gidilir.
    And Herhangi bir ürün sayfasına gidilir.
    And Ürün sepete eklenir.
    When Sepet sayfasına gidilir.
    Then Anasayfaya geri dönülür.