package com.example.workflow.organization;

import com.example.workflow.organization.dao.Organization;
import com.example.workflow.user.dao.User;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
    @Spec(path= "login", params = "login", spec = LikeIgnoreCase.class)
})
interface OrganizationSpecification extends Specification<Organization> {
}
