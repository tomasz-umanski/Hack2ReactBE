package com.example.workflow.organization.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {

    @NotBlank(message = "id cannot be blank")
    private String id;

    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "address cannot be blank")
    private String address;

    @NotBlank(message = "type cannot be blank")
    private String type;

}
