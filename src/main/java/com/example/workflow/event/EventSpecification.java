package com.example.workflow.event;

import com.example.workflow.event.dao.Event;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

@Or({
        @Spec(path= "title", params = "title", spec = LikeIgnoreCase.class),
        @Spec(path= "description", params = "description", spec = LikeIgnoreCase.class),
})
interface EventSpecification extends Specification<Event> {
}
