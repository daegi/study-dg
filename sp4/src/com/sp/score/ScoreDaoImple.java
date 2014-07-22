package com.sp.score;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("score.scoreDAO")
public class ScoreDaoImple implements ScoreDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertScore(Score dto) {
		int result = 0;

		try {
			result = sqlSession.insert("score.insertScore", dto);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	@Override
	public int updateScore(Score dto) {
		int result = 0;

		try {
			result = sqlSession.update("score.updateScore", dto);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	@Override
	public int deleteScore(String hak) {
		int result = 0;

		try {
			result = sqlSession.delete("score.deleteScore", hak);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	@Override
	public Score readScore(String hak) {
		Score dto = null;
		try {
			dto = (Score) sqlSession.selectOne("score.readScore", hak);

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;
	}

	@Override
	public List<Score> listScore(Map<String, Object> map) {
		List<Score> list = null;
		try {
			list = sqlSession.selectList("score.listScore", map);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return list;
	}

	@Override
	public int dataCount() {
		int result = 0;

		try {
			result = (Integer) sqlSession.selectOne("score.dataCount");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

}
