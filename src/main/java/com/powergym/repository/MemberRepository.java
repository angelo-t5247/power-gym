package com.powergym.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.powergym.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
