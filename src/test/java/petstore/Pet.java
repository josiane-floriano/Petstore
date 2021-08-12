// 1 - pacote
package petstore;

// 2 - bibliotecas


import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3- classe


public class Pet {
// 3.1 - Atributos

   String uri = "https://petstore.swagger.io/v2/pet"; //endereço da identidade Pet
//    3.2 - Metodos e funções

   public String lerJson(String caminhoJson) throws IOException {
      return new String(Files.readAllBytes(Paths.get(caminhoJson)));
   }

//   incluir - create - post
   @Test // identifica o método para teste
   public void incluirPet() throws IOException {
      String jsonBody = lerJson("db/pet1.json");

      // Sintaxe Gherkin
      // Dado - Quando - Então
      // Given -When - Then

      given() // Dado
              .contentType("application/json") // comum em API REST - antigas era "text/xml"
              .log().all()
              .body(jsonBody)
     .when() // Quando
              .post(uri)
     .then() // Então
              .log().all()
              .statusCode(200)
     ;
   }

}
