package com.sp.score;

import java.util.List;
import java.util.Map;

public interface ScoreDAO {
	public int insertScore(Score dto);

	public int updateScore(Score dto);

	public int deleteScore(String hak);

	public int checkDelete(String hak);

	public Score readScore(String hak);

	public List<Score> listScore(Map<String, Object> map);

	public int dataCount();

}
