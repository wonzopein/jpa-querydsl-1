package com.workspace.account.api.department;

import com.workspace.account.base.BaseTimeEntity;
import com.workspace.account.api.members.Member;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter @Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Department extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Department parentDepartment;

    @OneToMany(mappedBy = "parentDepartment")
    private List<Department> subDepartment;

    @OneToMany(mappedBy = "department")
    private List<Member> members;

    public void addMember(Member member){

        if(members == null){
            members = new ArrayList<>();
        }

        members.add(member);
        member.setDepartment(this);
    }

    public void addSubDepartment(Department department){
        if(subDepartment == null){
            subDepartment = new ArrayList<>();
        }

        subDepartment.add(department);
        department.setParentDepartment(this);
    }
}
