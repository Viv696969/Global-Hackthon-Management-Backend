package com.vivekempire.hackathonManager.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Judge assigned_judge;

    @ManyToOne
    private Hackathon hackathon;

    @OneToOne
    private Participant leader;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "scores",columnDefinition = "jsonb")
    private Map<String, String> scores=Map.of("inovation","0","performance","0","teamwork","0","feasibility","0","presentation","0");



}
