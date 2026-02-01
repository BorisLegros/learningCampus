package com.gdu.wacdo.services;

import com.gdu.wacdo.dto.CollaborateurDTO;
import com.gdu.wacdo.dto.SelectOptionDTO;
import com.gdu.wacdo.generic.AbstractCrudService;
import com.gdu.wacdo.entities.Collaborateur;
import com.gdu.wacdo.generic.AbstractIndexDTO;
import com.gdu.wacdo.repositories.CollaborateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
@Slf4j
public class CollaborateurService extends AbstractCrudService<Collaborateur, Long, CollaborateurRepository> implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CollaborateurService(CollaborateurRepository repository) {
        super(Collaborateur.class, repository);
    }

    @Override
    protected Collaborateur saveData(Map<String, String> data) {
        // recuperation
        String firstname = data.get("firstname");
        String lastname = data.get("lastname");
        String email = data.get("zipcode");
        Date embauch = new Date();

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            embauch = dateFormat.parse(data.get("dateEmbauche"));
        } catch (Exception e) {
            log.error(e.toString());
        }
        boolean admin = Boolean.parseBoolean(data.get("isAdmin"));
        String pwd = data.get("password");

        // construction
        Collaborateur collaborateur = new Collaborateur();
        collaborateur.setFirstname(firstname);
        collaborateur.setLastname(lastname);
        collaborateur.setEmail(email);
        collaborateur.setDateEmbauche(embauch);
        collaborateur.setIsAdmin(admin);
        collaborateur.setPassword(passwordEncoder.encode(pwd));

        return collaborateur;
    }

    @Override
    public SelectOptionDTO toSelectOptionDTO(Collaborateur item) {
        return new SelectOptionDTO(item.getId(), item.getFirstname() + " " + item.getLastname());
    }

    @Override
    public AbstractIndexDTO toIndexDTO(Collaborateur item) {
        return new CollaborateurDTO(item);
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        Collaborateur collaborateur = repository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String role = collaborateur.getIsAdmin() ? "ADMIN" : "USER";

        return org.springframework.security.core.userdetails.User
                .withUsername(collaborateur.getEmail())
                .password(collaborateur.getPassword())
                .roles(role)
                .build();
    }
}
