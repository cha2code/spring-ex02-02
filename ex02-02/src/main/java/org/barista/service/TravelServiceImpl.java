package org.barista.service;

import java.util.List;

import org.barista.domain.Criteria;
import org.barista.domain.TravelVO;
import org.barista.mapper.TravelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

	@Autowired
	private TravelMapper mapper;
	
	@Override
	public List<TravelVO> getList(Criteria cri) {
		
		return mapper.getList(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}

	@Override
	public TravelVO get(Long no) {
		
		return mapper.read(no);
	}

	@Override
	public void register(TravelVO travel) {
		
		mapper.insert(travel);
	}

	@Override
	public boolean modify(TravelVO travel) {
		
		return mapper.update(travel) == 1;
	}

	@Override
	public boolean remove(Long no) {
		
		return mapper.delete(no) == 1;
	}

}
