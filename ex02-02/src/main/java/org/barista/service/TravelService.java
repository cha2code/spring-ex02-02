package org.barista.service;

import java.util.List;

import org.barista.domain.Criteria;
import org.barista.domain.TravelVO;

public interface TravelService {
	
	public List<TravelVO> getList(Criteria cri);
	
	public int getTotal(Criteria cri);
	
	public TravelVO get(Long no);
	
	public void register(TravelVO travel);
	
	public boolean modify(TravelVO travel);
	
	public boolean remove(Long no);

}
