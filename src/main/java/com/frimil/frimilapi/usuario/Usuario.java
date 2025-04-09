package com.frimil.frimilapi.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frimil.frimilapi.cargo.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TAB_USUARIO")
@Entity
public class Usuario implements UserDetails {

    @Id
    @Column(name = "TUSR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @JsonIgnore
    @Column(name = "TUSR_NOME", nullable = false)
    private String name;
    @Column(name = "TUSR_EMAIL",nullable = false, length = 35, unique = true)
    private String email;
    @JsonIgnore
    @Column(name = "TUSR_SENHA", nullable = false)
    private String senha;
    @JsonIgnore
    @Column(name = "TUSR_TELEFONE")
    private String telefone;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TAB_CARGOS_USUARIOS",
            joinColumns = @JoinColumn(name = "TUSR_ID"),
            inverseJoinColumns = @JoinColumn(name = "TCG_ID"))
    private Collection<Cargo> cargos;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return cargos;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
