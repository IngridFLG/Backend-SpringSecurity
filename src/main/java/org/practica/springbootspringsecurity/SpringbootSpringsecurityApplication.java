package org.practica.springbootspringsecurity;

import org.practica.springbootspringsecurity.persistence.entity.PermissionEntity;
import org.practica.springbootspringsecurity.persistence.entity.RoleEntity;
import org.practica.springbootspringsecurity.persistence.entity.UserEntity;
import org.practica.springbootspringsecurity.persistence.repository.UserRepository;
import org.practica.springbootspringsecurity.persistence.entity.RoleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringbootSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            /* Create PERMISSIONS */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();

            /* Create ROLES */

            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ROLE_ADMIN).permissionsList(Set.of(createPermission, readPermission, updatePermission, deletePermission)).build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.ROLE_USER)
                    .permissionsList(Set.of(createPermission, readPermission))
                    .build();

            RoleEntity roleInvited = RoleEntity.builder()
                    .roleEnum(RoleEnum.ROLE_INVITED)
                    .permissionsList(Set.of(readPermission))
                    .build();

            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEnum(RoleEnum.ROLE_DEVELOPER)
                    .permissionsList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
                    .build();

            /* CREATE USERS */
            UserEntity userSantiago = UserEntity.builder()
                    .username("santiago")
                    .password("1234")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserEntity userDaniel = UserEntity.builder()
                    .username("daniel")
                    .password("1234")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            UserEntity userAndrea = UserEntity.builder()
                    .username("andrea")
                    .password("1234")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();

            UserEntity userAnyi = UserEntity.builder()
                    .username("anyi")
                    .password("1234")
                    .isEnabled(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

            userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi));
        };
    }

}
