package kz.bitlab.spring.six.one.spring.demo.six.one.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "applications")
public class ApplicationRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "phone")
    private String phone;

    @Column(name = "handled")
    private boolean handled;

}
