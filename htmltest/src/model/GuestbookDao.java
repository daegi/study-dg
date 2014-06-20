package model;

import java.util.List;

public interface GuestbookDao {
	//방명록 리스트를 리턴하는 method
	List<GuestbookDto> gbList();
}
