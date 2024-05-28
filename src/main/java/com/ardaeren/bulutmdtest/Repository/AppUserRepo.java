package com.ardaeren.bulutmdtest.Repository;

import com.ardaeren.bulutmdtest.Domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    AppUser findByName(String appUserName);
}
