package com.chamith.jpa.unitintergrationtests.repo;
import com.chamith.jpa.unitintergrationtests.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {
}
