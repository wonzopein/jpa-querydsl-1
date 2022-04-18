package com.workspace.account.api.corpcard;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CorpCardRepo extends JpaRepository<CorpCard, Long>, CorpCardCustomRepo {

    List<CorpCard> findAllByMemberId(Long memberId);

}
