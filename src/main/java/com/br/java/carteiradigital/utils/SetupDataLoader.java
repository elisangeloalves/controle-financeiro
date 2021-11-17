package com.br.java.carteiradigital.utils;

import com.br.java.carteiradigital.model.Privilege;
import com.br.java.carteiradigital.model.Role;
import com.br.java.carteiradigital.model.User;
import com.br.java.carteiradigital.repository.PrivilegeRepository;
import com.br.java.carteiradigital.repository.RoleRepository;
import com.br.java.carteiradigital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Configuration
@Service
@Transactional
public class SetupDataLoader {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            Privilege readPrivilege
                    = createPrivilegeIfNotFound("READ_PRIVILEGE");
            Privilege writePrivilege
                    = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

            List<Privilege> adminPrivileges = Arrays.asList(
                    readPrivilege, writePrivilege);

            Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
            Role userRole = createRoleIfNotFound("ROLE_USER", List.of(readPrivilege));

            User pedro = new User("PEDRO", "SILVA", "paulo@gmail.com", passwordEncoder.encode("123456"));
            User maria = new User("MARIA", "ALVES", "maria@gmail.com", passwordEncoder.encode("123456"));

            pedro.setRoles(Arrays.asList(adminRole));
            maria.setRoles(List.of(userRole));

            userRepository.save(pedro);
            userRepository.save(maria);
        };
    }

    public Privilege createPrivilegeIfNotFound(String name) {

        Optional<Privilege> privilege = privilegeRepository.findByName(name);
        if (privilege.isEmpty()) {
            privilege = Optional.of(new Privilege(name));
            privilegeRepository.save(privilege.get());
        }
        return privilege.get();
    }

    public Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Optional<Role> role = roleRepository.findByName(name);
        if (role.isEmpty()) {
            role = Optional.of(new Role(name));
            role.get().setAuthorities(privileges);
            roleRepository.save(role.get());
        }
        return role.get();
    }
}
