package com.example.springbootswagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Details about the contact")
public class Contact {
    @ApiModelProperty(notes = "the unique id of the contact")
    private String id;
    @ApiModelProperty(notes = "the person's name")
    private String name;
    @ApiModelProperty(notes = "the person's phone")
    private String phone;
}
