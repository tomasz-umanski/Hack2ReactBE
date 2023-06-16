package com.example.workflow.user;

import com.example.workflow.user.dao.User;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
    @Spec(path= "login", params = "login", spec = LikeIgnoreCase.class)
})
interface UserSpecification extends Specification<User> {
}
