package ru.kuper.restswag;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
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
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;


    @NotNull
    @Size(min = 1, max = 30)
    private String name;

    @NotNull
    @Size(min = 2, max = 255)
    private String author;



}
