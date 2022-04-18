package com.workspace.account.api.members;

import com.workspace.account.api.members.dto.MemberViewDto;

import java.util.List;

public interface MemberCustomRepo {

    List<Member> findAllFetchJoin();

    List<MemberViewDto> findAllDto();

}
