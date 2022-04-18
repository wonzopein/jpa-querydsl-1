package com.workspace.account.api.members.dto;

import com.workspace.account.api.corpcard.CorpCard;
import com.workspace.account.api.department.Department;
import com.workspace.account.api.members.Member;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberViewDto {
    private Long id;

    private String name;

    private String alias;

    private DepartmentDto department;

    private List<CorpCardDto> corpCards;

    @QueryProjection
    public MemberViewDto(Member member, Department department, List<CorpCard> corpCards) {
        this.id = member.getId();
        this.name = member.getName();
        this.alias = member.getAlias();
        this.department = DepartmentDto.with(department);
        if(corpCards != null){
            this.corpCards = corpCards.stream().map(CorpCardDto::with).collect(Collectors.toList());
        }
    }

    public MemberViewDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.alias = member.getAlias();
        this.department = member.getDepartment() == null? null:DepartmentDto.with(member.getDepartment());
        if(member.getCorpCards() != null && member.getCorpCards().size() > 0){
            this.corpCards = member.getCorpCards().stream().map(CorpCardDto::with).collect(Collectors.toList());
        }
    }
}
