package br.com.zup.bootcamp.resource.proposal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ProposalResource.path)
public abstract class ProposalResource {
        public static final String path = "/api/proposals";
}
