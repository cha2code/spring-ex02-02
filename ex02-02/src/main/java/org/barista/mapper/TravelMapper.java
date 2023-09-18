package org.barista.mapper;

import java.util.List;

import org.barista.domain.Criteria;
import org.barista.domain.TravelVO;

public interface TravelMapper {
	
	public int getTotalCount(Criteria cri);

	public List<TravelVO> getList(Criteria cri);
	
	// insert가 실행 되고 생성 된 PK값을 알아야 하는 경우
	// insert 실행 후 생성 되는 PK값을 다른 테이블의 FK값으로 연결해 후속 작업을 해야 하는 경우
	// ex) 첨부 파일 저장
	public void insert(TravelVO travel);
		
	public TravelVO read(Long no);
		
	public int delete(Long no);
		
	public int update(TravelVO travel);

}
