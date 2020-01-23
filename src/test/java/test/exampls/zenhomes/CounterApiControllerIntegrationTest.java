package test.exampls.zenhomes;

import com.google.gson.Gson;
import io.restassured.http.Header;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import test.exampls.zenhomes.dto.CounterDTO;
import test.exampls.zenhomes.dto.CounterUpdateDTO;

import java.util.stream.Stream;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {
		"/sql/delete-test-data.sql",
		"/sql/insert-test-data.sql"
})
@Profile("integration-testing")
class CounterApiControllerIntegrationTest {
	private static int existingCounterId = 1;
	private static int nonExistingCounter = 123;
	private static String village1Name = "Test village";

	private static Gson gson = new Gson();

	@ParameterizedTest
	@MethodSource("createInvalidUpdateCounterRequests")
	void invalidCounterUpdates(String request, Integer counterId) {
		given()
				.header(new Header("Content-Type", "application/json"))
				.body(request)
		.when()
				.post("/v1/counter/"+counterId)
		.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.header("Content-Type", is("application/json"))
		;
	}

	@Test
	void counterUpdate() {
		Integer response = existingCounterId;
		Float newAmount = 99.1F;
		CounterUpdateDTO request = new CounterUpdateDTO(newAmount);

		given()
				.header(new Header("Content-Type", "application/json"))
				.body(gson.toJson(request))
		.when()
				.post("/v1/counter/"+ existingCounterId)
		.then()
				.statusCode(HttpStatus.OK.value())
				.header("Content-Type", is("application/json"))
				.body(is(gson.toJson(response)))
		;
	}

	@Test
	void getCounter() {
		CounterDTO expected = CounterDTO.builder()
				.id(existingCounterId)
				.amount(0F)
				.villageName(village1Name)
				.build();

		given()
				.header(new Header("Content-Type", "application/json"))
		.when()
				.get("/v1/counter/"+ existingCounterId)
		.then()
				.statusCode(HttpStatus.OK.value())
				.header("Content-Type", is("application/json"))
				.body(is(gson.toJson(expected)))
		;
	}

	private static Stream<Arguments> createInvalidUpdateCounterRequests() {
		return Stream.of(
				Arguments.of(gson.toJson(""), existingCounterId),
				Arguments.of(gson.toJson("{}"), existingCounterId),
				Arguments.of(gson.toJson("{\"amount\": \"string\"}"), existingCounterId),
				Arguments.of(gson.toJson("{\"amount\": \"string\"}"), existingCounterId),
				Arguments.of(gson.toJson("{\"amount\": \"123\"}"), nonExistingCounter)
		);
	}
}
