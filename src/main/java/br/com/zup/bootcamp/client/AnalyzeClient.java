package br.com.zup.bootcamp.client;

import br.com.zup.bootcamp.gateway.dto.AnalyzeResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "analyze", url = "${analise.url}")
public interface AnalyzeClient {

    @PostMapping(path = "/api/solicitacao")
    @Headers("Content-Type: application/json")
    ResponseEntity<AnalyzeResponse> analyzeRestrictions(@RequestBody Map<String, String> request);
}
