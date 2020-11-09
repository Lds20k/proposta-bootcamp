package br.com.zup.bootcamp.gateway;

import br.com.zup.bootcamp.entity.Proposal;

import java.util.Optional;

public interface UserHaveProposalGateway {
    Optional<Proposal> execute(String id);
}
