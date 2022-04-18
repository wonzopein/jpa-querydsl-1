package com.workspace.account.api.members;

import com.workspace.account.api.members.dto.MemberViewDto;
import com.workspace.account.api.members.dto.QMemberViewDto;

import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.workspace.account.api.corpcard.QCorpCard.*;
import static com.workspace.account.api.members.QMember.member;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;

@Repository
public class MemberCustomRepoImpl implements MemberCustomRepo {

    private final JPAQueryFactory queryFactory;

    public MemberCustomRepoImpl(JPAQueryFactory jpaQueryFactory) {
        this.queryFactory = jpaQueryFactory;
    }

    @Override
    public List<Member> findAllFetchJoin() {
        return queryFactory.selectFrom(member)
                .distinct()
                .innerJoin(member.department)
                .leftJoin(member.corpCards)
                .fetchJoin()
                .fetch();
    }

    @Override
    public List<MemberViewDto> findAllDto() {
//        return queryFactory
//                .from(member)
//                .leftJoin(member.corpCards, corpCard)
//                .transform(
//                        groupBy(member.id)
//                        .list(
//                        Projections.constructor(
//                                MemberViewDto.class,
//                                member,
//                                member.department,
//                                GroupBy.list(corpCard)
//                        )));
        return queryFactory
                .from(member)
                .leftJoin(member.corpCards, corpCard)
                .transform(
                        groupBy(member.id)
                                .list(
                                        new QMemberViewDto(member, member.department, GroupBy.list(corpCard))
                                ));
    }

}
