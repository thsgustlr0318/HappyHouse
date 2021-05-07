package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseMapper;

@Service
public class HouseServiceImpl implements HouseService {

	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;


	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		//return sqlSession.getMapper(NoticeMapper.class).list();
		System.out.println("1234");
		return sqlSession.getMapper(HouseMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getAptInDong(dong);
	}

	@Override
	public List<HouseInfoDto> getAptInAptName(String aptName) throws Exception {
		return sqlSession.getMapper(HouseMapper.class).getAptInAptName(aptName);
	}

	@Override
	public HouseInfoDto getAptInfo(HouseInfoDto houseInfoDto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapper.class).getAptInfo(houseInfoDto);
	}

}
