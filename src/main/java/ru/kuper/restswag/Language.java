package ru.kuper.restswag;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@Entity
@ApiModel(value = "class language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;


    @NotNull
    @Size(min = 1, max = 30)
    @ApiModelProperty(value = "name of language", example = "pyton")
    private String name;

    @NotNull
    @Size(min = 2, max = 255)
    @ApiModelProperty(value = "language author", example = "gvido")
    private String author;



}
