package kodlama.io.ecommerce;

import kodlama.io.ecommerce.core.exceptions.BusinessExceptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*Bir E-ticaret sistemi oluşturmak istiyoruz. Spring Boot 3.0.4, paket yöneticisi olarak Maven ve Java SDK olarak 17 veya daha üst bir versiyon kullanılacaktır.
(Sadece Spring Web ve Swagger bağımlılığını eklemeniz yeterli olacaktır.)

Proje ismi : e-commerce

Req 1 : Sistemde Ürünler(Product) tutulmalıdır.

Req 2 : Ürünün id,name,quantity,price ve description şeklinde özellikleri olacaktır.

Req 3 : Ürünleri ekleyebilecek, silebilecek, güncelleyebilecek, listeleyebilecek, id ile getirebilecek kodları yazınız. Bunu tamamen in memory yapınız.

Req 4 : Ürünlerin fiyat bilgisi 0 dan büyük olmalıdır.

Req 5 : Ürünlerin quantity(miktarı) 0 dan küçük olamaz.

Req 6 : Ürünlerin description(açıklama) alanı min 10 karakter max 50 karakter olmalıdır.

---- (Validation paketini kullanmadan, kod yazarak algoritmik çözünüz) ----

Projede derste gördüğümüz gibi katmanlı mimari kullanılacaktır. Kodlarınızı github'a yükleyiniz.
Zorlandığınız veya yapamadığınız kısımlarda diğer arkadaşlarınızdan yardım alınız.

NOT : Belirtilen 6 madde dışında herhangi bir ekleme yada süsleme yapmayınız!

--------------------------------------------------------------------------------------------------

Swagger bağımlılığı için pom.xml'e ekleyiniz.

<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.0.4</version>
</dependency>*/
@RestControllerAdvice // rest controller dinleniyor demek
@SpringBootApplication
public class ECommerceApplication {
    //200: ok->request başarılı,500:->request başarısız,201:created,204:->delete sonrasında gözüküyor

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @ExceptionHandler // hataları işle
    public BusinessExceptions businessExceptions(String mesage) {
        return new BusinessExceptions(mesage);
    }
}
