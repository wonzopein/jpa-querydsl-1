package com.workspace.account.api.position;

import com.workspace.account.base.BaseTimeEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Position extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

}
