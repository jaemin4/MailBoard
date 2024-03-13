package kr.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.smhrd.entity.Member;




//Mapper 는 - MyBatis가 가지고 있는 API
	@Mapper
	public interface MemberMapper {
		public int memberJoin(Member member);
		
	}
