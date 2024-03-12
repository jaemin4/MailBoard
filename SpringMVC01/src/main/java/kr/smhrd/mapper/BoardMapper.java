package kr.smhrd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.smhrd.entity.Board;

//Mapper 는 - MyBatis가 가지고 있는 API
	@Mapper
	public interface BoardMapper {
		public List<Board> getLists();
		public void boardInsert(Board vo);
		
	}
