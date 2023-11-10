package com.dragondevelopers.entity;
import lombok.Data;
import java.sql.Timestamp;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="users")
public class User {
    
    @Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;

	@Column(name="email", unique=true)
	private String email;

	@Column(name="password")
	private String password;
    
    @CreationTimestamp
	private Timestamp created;
    
    @UpdateTimestamp
	private Timestamp modified;
    
    @CreationTimestamp
	private Timestamp last_login;

	@Column(name="isactive")
	private boolean isactive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Phone> phones;

}
