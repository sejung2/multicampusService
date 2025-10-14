package com.spring_boot_jpa_projectEx.project.repository;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
