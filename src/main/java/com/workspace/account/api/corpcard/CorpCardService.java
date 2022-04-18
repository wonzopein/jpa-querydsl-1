package com.workspace.account.api.corpcard;

import com.workspace.account.api.corpcard.dto.CorpCardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CorpCardService {

    private final CorpCardRepo cardRepo;

    public CorpCardService(CorpCardRepo cardRepo) {
        this.cardRepo = cardRepo;
    }

    public List<CorpCardDto> corpCardDtoList() {
        return cardRepo.findAll()
                .stream()
                .map(CorpCardDto::with)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CorpCardDto> corpCardDtoList(Long memberId) {
        return cardRepo.findAllByMemberId(memberId)
                .stream()
                .map(CorpCardDto::with)
                .collect(Collectors.toList());
    }
}
