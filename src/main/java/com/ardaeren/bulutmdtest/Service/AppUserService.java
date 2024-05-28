package com.ardaeren.bulutmdtest.Service;

import com.ardaeren.bulutmdtest.Domain.AppUser;
import com.ardaeren.bulutmdtest.Repository.AppUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUser createUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    public List<AppUser> getAllUsers() {
        return appUserRepo.findAll();
    }
}