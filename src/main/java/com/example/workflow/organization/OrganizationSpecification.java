package com.example.workflow.organization;

import com.example.workflow.organization.dao.Organization;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
        @Spec(path= "name", params = "name", spec = LikeIgnoreCase.class)
})
interface OrganizationSpecification extends Specification<Organization> {
}
