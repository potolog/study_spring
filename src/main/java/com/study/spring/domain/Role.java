package com.study.spring.domain;

import com.study.spring.auditing.AuditableDomain;
import com.study.spring.enums.EnableStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.AuditOverrides;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Audited
@AuditOverride(forClass = AbstractAuditable.class)
public class Role extends AuditableDomain {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private EnableStatus enable;

    private String description;

    public Role(String name, EnableStatus enable) {
        this.name = name;
        this.enable = enable;
    }
}
