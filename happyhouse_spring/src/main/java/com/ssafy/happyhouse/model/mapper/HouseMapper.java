package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;

public interface HouseMapper {

	List<SidoGugunCodeDto> getSido();

	List<SidoGugunCodeDto> getGugunInSido(String sido);

	List<HouseInfoDto> getDongInGugun(String gugun);

	List<HouseInfoDto> getAptInDong(String dong);

	List<HouseInfoDto> getAptInAptName(String aptName);

}
