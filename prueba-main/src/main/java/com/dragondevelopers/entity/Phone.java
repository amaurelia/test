package com.dragondevelopers.entity;
import lombok.Data;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="phones")
public class Phone {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="number")
	private String number;

	@Column(name="citycode")
	private String citycode;

	@Column(name="contrycode")
	private String contrycode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
