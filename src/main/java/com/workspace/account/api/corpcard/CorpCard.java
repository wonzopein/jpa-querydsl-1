package com.workspace.account.api.corpcard;

import com.workspace.account.base.BaseTimeEntity;
import com.workspace.account.api.members.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CorpCard extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String alias;

    private String name;
    private String company;
    private String number;
    private LocalDate expireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}
