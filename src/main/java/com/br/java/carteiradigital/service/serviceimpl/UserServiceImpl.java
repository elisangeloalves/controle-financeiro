package com.br.java.carteiradigital.service.serviceimpl;

import com.br.java.carteiradigital.config.validation.ApiErrorException;
import com.br.java.carteiradigital.controller.request.LoginRequest;
import com.br.java.carteiradigital.controller.request.UserRequest;
import com.br.java.carteiradigital.controller.response.TokenResponse;
import com.br.java.carteiradigital.controller.response.UserResponse;
import com.br.java.carteiradigital.model.Privilege;
import com.br.java.carteiradigital.model.Role;
import com.br.java.carteiradigital.model.User;
import com.br.java.carteiradigital.repository.PrivilegeRepository;
import com.br.java.carteiradigital.repository.RoleRepository;
import com.br.java.carteiradigital.repository.UserRepository;
import com.br.java.carteiradigital.service.TokenService;
import com.br.java.carteiradigital.service.UserService;
import com.br.java.carteiradigital.utils.SetupDataLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final String FIRSTNAME = "firstname";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private SetupDataLoader setupDataLoader;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User founderUser = userRepository.findByEmail(username);
        if (founderUser!= null) {
            return founderUser;
        }
        throw new UsernameNotFoundException("Erro de autenticacao pela aplicacao.");
    }

    @Override
    public List<UserResponse> listUsers(List<String> request, Integer page) {
        page = page != null ? page: 0;
        if (request.get(0) != null && request.get(1) != null) {
            return findAllByFullname(request.get(0),request.get(1), page);
        }
        if (request.get(0) != null) {
            return findAllByFirstname(request.get(0), page);
        }
        else if (request.get(1) != null) {
            return findAllByLastname(request.get(1), page);
        }
        else if (request.get(2) != null) {
            return List.of(findByEmail(request.get(2)));
        }
        else {
            return findAll(page);
        }
    }

    @Override
    public List<UserResponse> findAll(int page) {
        Pageable pageable = PageRequest.of(page, 30, Sort.Direction.DESC, "email");
        return userRepository.findAll(pageable).stream()
                .map(UserResponse::new).toList();
    }

    @Override
    public List<UserResponse> findAllByFullname(String firstname, String lastname, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, FIRSTNAME);
        return UserResponse.listAllUser(userRepository.findAllByFullName(
                firstname.toUpperCase(), lastname.toUpperCase(), pageable));
    }

    @Override
    public List<UserResponse> findAllByFirstname(String firstName, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, FIRSTNAME);
        List<User> users = userRepository.findAllByFirstname(firstName.toUpperCase(), pageable);
        return UserResponse.listAllUser(users);
    }

    @Override
    public List<UserResponse> findAllByLastname(String lastname, int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.ASC, FIRSTNAME);
        List<User> users = userRepository.findAllByLastname(lastname.toUpperCase(), pageable);
        return UserResponse.listAllUser(users);
    }

    @Override
    public UserResponse findByEmail(String email) {
        User foundedUser = userRepository.findByEmail(email.toLowerCase());
        return foundedUser!= null?
                new UserResponse(foundedUser)
                :null;
    }

    @Override
    public User findById(Long userId) {
        Optional<User> foundedUser = userRepository.findById(userId);
        return foundedUser.orElse(null);
    }

    @Override
    public UserResponse update(User user) {
        Optional<User> foundedUser = userRepository.findById(user.getId());
        return foundedUser.isPresent()?
                new UserResponse(userRepository.save(user))
                :null;
    }

    @Override
    public UserResponse create(UserRequest user) {
        User userModel = user.toModel();

        Privilege readPrivilege = setupDataLoader
                .createPrivilegeIfNotFound("READ_PRIVILEGE");
        Role role = setupDataLoader
                .createRoleIfNotFound("ROLE_USER", List.of(readPrivilege));
        userModel.setRoles(List.of(role));

        return new UserResponse(userRepository.save(userModel));
    }

    @Override
    public void delete(Long userId) {
        userRepository.deleteById(userId);

    }

    @Override
    public TokenResponse login(LoginRequest login, AuthenticationManager authenticationManager) {
        String token;
        try {
            UsernamePasswordAuthenticationToken data = login.convert();
            Authentication authentication = authenticationManager.authenticate(data);
            token = tokenService.generateToken(authentication);

        } catch (BadCredentialsException e) {
            throw new ApiErrorException(e.getLocalizedMessage(), ": Email and/or password invalid!", HttpStatus.PRECONDITION_FAILED);
        }
        return new TokenResponse(token, "Bearer");
    }
}
