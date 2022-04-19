package com.workspace.account.api.members;

import com.workspace.account.api.corpcard.CorpCard;
import com.workspace.account.api.corpcard.CorpCardRepo;
import com.workspace.account.api.department.Department;
import com.workspace.account.api.department.DepartmentRepo;
import com.workspace.account.api.members.dto.MemberViewDto;
import com.workspace.account.api.members.dto.auth.LoginRequest;
import com.workspace.account.api.members.dto.auth.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Tag(name = "Member", description = "사용자 API")
@RequestMapping("/api/members")
@RestController
@Slf4j
public class MemberCtl {
    MemberService memberSerice;
    MemberRepo memberRepo;
    DepartmentRepo departmentRepo;

    CorpCardRepo cardRepo;

    public MemberCtl(MemberService memberSerice, MemberRepo memberRepo, DepartmentRepo departmentRepo, CorpCardRepo cardRepo) {
        this.memberSerice = memberSerice;
        this.memberRepo = memberRepo;
        this.departmentRepo = departmentRepo;
        this.cardRepo = cardRepo;
    }

    @PostConstruct
    public void init(){

        Department dept1 = Department.builder().name("부서1").build();
        departmentRepo.save(dept1);

        Department dept2 = Department.builder().name("부서1-1").build();


        dept1.addSubDepartment(dept2);
        departmentRepo.save(dept2);


        Member member = Member.builder()
                .name("오승현")
                .department(dept2)
                .build();

        Member member1 = Member.builder()
                .name("김승현")
                .department(dept1)
                .build();

        Member member2 = Member.builder()
                .name("김승현")
                .build();

        memberRepo.saveAll(Arrays.asList(member, member1, member2));

        CorpCard card1 = CorpCard.builder().alias("테스트 카드1").build();
        CorpCard card2 = CorpCard.builder().alias("테스트 카드2").build();
        card1.setMember(member);
        card2.setMember(member);
        cardRepo.saveAll(Arrays.asList(card1,card2));

        memberSerice.listMemberAll(); //memberRepo.findAllFetchJoin();

    }

    @PostMapping("/login")
    @Operation(summary = "사용자 인증", description = "OAuth2 정보를 통한 인증")
    public ResponseEntity<LoginResponse> userLogin(@RequestBody LoginRequest request){
        return ResponseEntity.ok(new LoginResponse());
    }

    @GetMapping("/{memberId}")
    @Operation(summary = "사용자 조회")
    public ResponseEntity<MemberViewDto> getMember(@Valid  @PathVariable("memberId") long memberId){
        MemberViewDto memberViewDto = memberSerice.getMember(memberId);
        return ResponseEntity.ok(memberViewDto);
    }

    @GetMapping("")
    @Operation(summary = "사용자목록 조회")
    public ResponseEntity<List<MemberViewDto>> listMember(){
        List<MemberViewDto> members = memberSerice.listMemberDtoAll();
        return ResponseEntity.ok(members);
    }

}
