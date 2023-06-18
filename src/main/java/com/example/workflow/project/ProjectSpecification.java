package com.example.workflow.project;

import com.example.workflow.project.dao.Project;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LessThanOrEqual;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
        @Spec(path= "title", params = "title", spec = LikeIgnoreCase.class),
        @Spec(path= "description", params = "description", spec = LikeIgnoreCase.class),
        @Spec(path= "startDate", params = "startDate", spec = GreaterThanOrEqual.class),
        @Spec(path= "startDate", params = "endDate", spec = LessThanOrEqual.class)
})
interface ProjectSpecification extends Specification<Project> {
}
