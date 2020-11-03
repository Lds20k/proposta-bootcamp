package br.com.zup.bootcamp;

import br.com.zup.bootcamp.enumerate.Eligibility;
import br.com.zup.bootcamp.gateway.database.model.ProposalDBDomain;
import br.com.zup.bootcamp.gateway.database.repository.ProposalRepository;
import br.com.zup.bootcamp.resource.dto.request.ProposalCreateRequest;
import br.com.zup.bootcamp.resource.proposal.ProposalResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProposalCreateTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private ProposalRepository proposalRepository;

	private final String id = "8528d44a-1ad6-11eb-adc1-0242ac120002";
	private final String cpf = "068.230.990-70";
	private final String email = "joao@email.com";
	private final String name = "João";
	private final String address = "Rua b";
	private final BigDecimal salary = new BigDecimal(100.00);
	private final Eligibility eligibility = Eligibility.PENDENTE;

	@DisplayName("Deve aceitar uma requisição valida")
	@Test
	void validRequestToCreate() {
		ProposalCreateRequest requestCPF = new ProposalCreateRequest(
				this.cpf, this.email, this.name, this.address, this.salary
		);

		HttpEntity<ProposalCreateRequest> httpEntityCPF = new HttpEntity<>(requestCPF);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<Void> responseCPF = restTemplate.exchange(
				ProposalResource.path,
				HttpMethod.POST,
				httpEntityCPF,
				Void.class,
				headers
		);

		assertThat(responseCPF.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);

		assertThat(responseCPF.getHeaders().getLocation()).isNotNull();
	}

	@DisplayName("Deve recusar uma requisição com um documento já registrado")
	@Test
	void requestWithSameDocumentToCreate() {
		ProposalCreateRequest requestCPF = new ProposalCreateRequest(
				this.cpf, this.email, this.name, this.address, this.salary
		);

		ProposalDBDomain proposalDBDomain = new ProposalDBDomain(
				this.id,
				this.cpf,
				this.email,
				this.name,
				this.address,
				this.salary,
				this.eligibility
		);

		BDDMockito.when(proposalRepository.findByDocument(this.cpf)).thenReturn(Optional.of(proposalDBDomain));

		HttpEntity<ProposalCreateRequest> httpEntityCPF = new HttpEntity<>(requestCPF);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ResponseEntity<Void> responseCPF = responseCPF = restTemplate.exchange(
				ProposalResource.path,
				HttpMethod.POST,
				httpEntityCPF,
				Void.class,
				headers
		);

		assertThat(responseCPF.getStatusCode()).isEqualByComparingTo(HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@DisplayName("Deve recusar uma requisição invalida")
	@Test
	void invalidRequestToCreate() {
		ResponseEntity<Void> response = restTemplate.postForEntity(ProposalResource.path, Void.class, Void.class);
		assertThat(response.getStatusCode()).isEqualByComparingTo(HttpStatus.BAD_REQUEST);
	}
}
