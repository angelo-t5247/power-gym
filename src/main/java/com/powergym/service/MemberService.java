package com.powergym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powergym.model.Member;
import com.powergym.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	public void saveMember(Member member) {
		memberRepository.save(member);
	}
	
	public List<Member> findAllMembers(){
		return memberRepository.findAll();
	}
}
