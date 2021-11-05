// 1- Pacote
package petstore;

// 2 - Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3 - Classe
public class Pet {
     // 3.1 - Atributivos
     String uri = "https://petstore.swagger.io/v2/pet"; // Endereco da entidade pet

    // 3.2 - Metodos e funcoes
     public String lerJson (String caminhoJson) throws IOException {

          return new String(Files.readAllBytes(Paths.get(caminhoJson)));
     }

     // Incluir - Create - POST
     @Test //identifica o metodo ou funcao como um teste, para o testeNG
     public void incluirPet() throws IOException {
          String jsonBody = lerJson ("data/pet1.json");

         // Sintaxe Gherkin
         // dado - quando - entao (Given, when, then)

         given() // Dado
                 .contentType("application/json") // Comum em API REST
                 .log().all() //log de request
                 .body(jsonBody)
         .when()
                 .post(uri)
         .then()
                 .log().all() // log de response
                 .statusCode(200)
         ;


     }
}
