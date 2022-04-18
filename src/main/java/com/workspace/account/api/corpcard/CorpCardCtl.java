package com.workspace.account.api.corpcard;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/corpcards")
@RestController
@Tag(name = "CorpCard", description = "법인카드 API")
public class CorpCardCtl {

    private final CorpCardService corpCardService;

    public CorpCardCtl(CorpCardService corpCardService) {
        this.corpCardService = corpCardService;
    }

    @GetMapping("")
    public ResponseEntity<?> listCorpCard(){
        return ResponseEntity.ok(corpCardService.corpCardDtoList());
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<?> listCorpCardByMember(@Valid @PathVariable("memberId") Long memberId){
        return ResponseEntity.ok(corpCardService.corpCardDtoList(memberId));
    }

}
