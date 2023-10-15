package br.com.sanscrito.integrations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.context.ActiveProfiles;
import java.net.http.HttpClient
import java.net.http.HttpRequest
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import java.io.File
import java.net.URI
import java.net.http.HttpResponse

@Testcontainers
@ActiveProfiles("test")
public class MsCalendarioServiceTest {

    val DOCKER_IMAGE_NAME = "odilio/testcontainners"
    val PORT = 8080

    @Container
    val container: GenericContainer<*> = GenericContainer<Nothing>(DOCKER_IMAGE_NAME)

        .withExposedPorts(PORT)


    companion object {
        private val environment: DockerComposeContainer<*> = DockerComposeContainer<Nothing>(File("docker-compose.yml"))
            .withExposedService("microservice", 8080)

        // Configurar outras dependências Docker necessárias aqui

        init {
            environment.start()
            Thread.sleep(5000)
        }
    }


    @Test
    fun testMicroserviceIntegration() {

        // Obter a URL do serviço Docker do microserviço
        val microserviceUrl = "http://${environment.getServiceHost("microservice", 8080)}:8080"

        // Realizar a chamada de integração para o microserviço
        val response = callMicroserviceEndpoint(microserviceUrl, "/boletas/v1/")

        // Verificar o resultado esperado
        assertEquals(200, response.statusCode())
    }

    private fun callMicroserviceEndpoint(baseUrl: String, endpoint: String): HttpResponse<String> {
        return HttpClient.newHttpClient()
            .send(HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + endpoint))
                .GET()
                .build(),
                HttpResponse.BodyHandlers.ofString()
            )
    }
}