package br.com.zup.bootcamp.client;

import br.com.zup.bootcamp.client.response.AdviseTripResponse;
import br.com.zup.bootcamp.client.response.CardResponse;
import br.com.zup.bootcamp.client.response.LockResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "card", url = "${cartao.url}")
public interface CardClient {

    @GetMapping("/api/cartoes")
    @Headers("Content-Type: application/json")
    ResponseEntity<CardResponse> getCard(@RequestParam("idProposta") String idProposta);

    @PostMapping("/api/cartoes/{id}/bloqueios")
    @Headers("Content-Type: application/json")
    ResponseEntity<LockResponse> lockCard(@PathVariable(name = "id") String card, @RequestBody Map<String, String> request);

    @PostMapping("/api/cartoes/{id}/avisos")
    @Headers("Content-Type: application/json")
    ResponseEntity<AdviseTripResponse> adviseTrip(@PathVariable(name = "id") String card, @RequestBody Map<String, String> request);
}
