package com.hankdjambong.frigletcreatorservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "FIGLET")
@Entity
public class Figlet {

    @javax.persistence.Id
    @NotNull
    @Column(name = "ID")
    @SequenceGenerator(name = "FIGLET_ID_SEQ", sequenceName = "FIGLET_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIGLET_ID_SEQ")
    private Long Id;

    @NotNull
    @Column(name = "FIGLET_VALUE")
    private String figletValue;
}
