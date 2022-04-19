package com.workspace.account.api.members;

import com.workspace.account.api.department.Department;
import com.workspace.account.api.members.dto.MemberViewDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class MemberService {

    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public void setDepartment(Member member, Department department){
        member.setDepartment(department);
        memberRepo.save(member);
    }

    public List<MemberViewDto> listMember(){
        //  Entity -> DTO 변환을 DAO에서 하는방법은...?
//        return memberRepo.findAllFetchJoin()
//                .stream()
//                .map(m -> MemberViewDto.builder().build())
//                .collect(Collectors.toList());
        return null;
    }

    @Transactional(readOnly = true)
    public List<MemberViewDto> listMemberAll(){
        return null;
//        return memberRepo.findAllFetchJoin().stream().map(m -> new MemberViewDto.builder()
//                        .id(m.getId())
//                        .name(m.getName())
//                        .alias(m.getAlias())
//                        .department(DepartmentDto.with(m.getDepartment()))
//                        .build())
//                        .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberViewDto> listMemberDtoAll(){

//        return memberRepo.findAllFetchJoin().stream()
//                .map(MemberViewDto::new)
//                .collect(Collectors.toList());

        return memberRepo.findAllDto();
    }

    @Transactional(readOnly = true)
    public MemberViewDto getMember(long memberId) {
        Member member = memberRepo.findById(memberId).orElse(null);

        if(member == null){
            return null;
        }else{
            return new MemberViewDto(member);
        }
    }
}
