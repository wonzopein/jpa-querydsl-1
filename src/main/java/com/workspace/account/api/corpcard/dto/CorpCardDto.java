package com.workspace.account.api.corpcard.dto;

import com.workspace.account.api.corpcard.CorpCard;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CorpCardDto {
    private Long id;
    private String alias;
    private String name;
    private String company;
    private String number;
    private LocalDate expireDate;

    @Builder
    public CorpCardDto(Long id, String alias, String name, String company, String number, LocalDate expireDate) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.company = company;
        this.number = number;
        this.expireDate = expireDate;
    }

    public static CorpCardDto with(CorpCard corpCard) {
        if(corpCard == null){
            return null;
        }

        return CorpCardDto.builder()
                .id(corpCard.getId())
                .alias(corpCard.getAlias())
                .name(corpCard.getName())
                .company(corpCard.getCompany())
                .number(corpCard.getNumber())
                .expireDate(corpCard.getExpireDate())
                .build();
    }
}
