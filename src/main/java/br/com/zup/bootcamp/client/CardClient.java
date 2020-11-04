package br.com.zup.bootcamp.client;

import br.com.zup.bootcamp.client.response.CardResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "card", url = "${cartao.url}")
public interface CardClient {

    @GetMapping("/api/cartoes")
    @Headers("Content-Type: application/json")
    ResponseEntity<CardResponse> getCard(@RequestParam("idProposta") String idProposta);
}
