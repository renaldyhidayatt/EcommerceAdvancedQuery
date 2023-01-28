package com.sanedge.ecommercequery.repository;

import com.sanedge.ecommercequery.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);

    @Query("select r.id, count(*) from User u inner join u.roles r where r.id in :roleIds group by r.id")
    Object[][] findUsersCountForRoleIds(@Param("roleIds") List<Long> roleIds);
}
