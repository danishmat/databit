package com.org.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
public class Customer {
@Id
@SequenceGenerator(
        name="customer_id_sequence",
        sequenceName = "customer_id_sequence"
)
@GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "customer_id_sequence"
)
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isRegistered;

}
