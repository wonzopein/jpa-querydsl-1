package com.workspace.account.api.members;

import com.workspace.account.api.corpcard.CorpCard;
import com.workspace.account.api.department.Department;
import com.workspace.account.base.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String alias;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToMany(mappedBy = "member")
    private List<CorpCard> corpCards = new ArrayList<>();

    @Builder
    public Member(String name, Department department) {
        this.name = name;
        this.department = department;
    }
}
