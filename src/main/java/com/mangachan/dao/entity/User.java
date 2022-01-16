package com.mangachan.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "uk_user", columnNames = {"email", "username"}))
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 30)
	private String username;

	@Column(nullable = false, length = 50)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean enabled;

	@Column(nullable = false)
	private Boolean accountNonExpired;

	@Column(nullable = false)
	private Boolean accountNonLocked;

	@Column(nullable = false)
	private Boolean credentialsNonExpired;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_id")),
			inverseJoinColumns = @JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "fk_role_id"))
	)
	@ToString.Exclude
	private List<Role> authorities = new ArrayList<>();

	@Override
	public boolean isAccountNonExpired() {
		return getAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return getAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return getCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return getEnabled();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		User user = (User) o;
		return id != null && Objects.equals(id, user.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

}
