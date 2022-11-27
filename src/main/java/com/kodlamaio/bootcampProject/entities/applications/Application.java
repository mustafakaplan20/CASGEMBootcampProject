package com.kodlamaio.bootcampProject.entities.applications;

import com.kodlamaio.bootcampProject.entities.bootcamps.Bootcamp;
import com.kodlamaio.bootcampProject.entities.users.Applicant;
import com.kodlamaio.bootcampProject.entities.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "state")
    private int state;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    Applicant applicant;
    @ManyToOne
    @JoinColumn(name = "bootcamp_id")
    Bootcamp bootcamp;

}
