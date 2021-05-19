package com.ssafy.happyhouse.controller;

import java.util.List;

import org.apache.tomcat.util.threads.StopPooledThreadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseService;

import io.swagger.annotations.Api;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/map")
@Api(value="HappyHouse MAP API")
public class HouseController {
	private static final Logger logger = LoggerFactory.getLogger(HouseController.class);

	@Autowired
	private HouseService houseService;

	@GetMapping(value = "/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> getSido() {
		System.out.println("sido click");
		try {
			List<SidoGugunCodeDto> list = houseService.getSido();
			//			for(SidoGugunCodeDto ob:list) {
			//				System.out.println(ob.getSidoName());
			//			}
			return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> getGugun(String sido) {
		try {
			System.out.println("gugun click");
			System.out.println(sido);
			List<SidoGugunCodeDto> list = houseService.getGugunInSido(sido);
			return new ResponseEntity<List<SidoGugunCodeDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/dong")
	public ResponseEntity<List<HouseInfoDto>> getDong(String gugun) {
		try {
			System.out.println("dong click");
			List<HouseInfoDto> list = houseService.getDongInGugun(gugun);
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/apt")
	public ResponseEntity<List<HouseInfoDto>> getAptInDong(String dong) {
		try {
			System.out.println("apt click");
			List<HouseInfoDto> list = houseService.getAptInDong(dong);
			for( HouseInfoDto dto: list ){
				HouseInfoDto d = houseService.getAptInfo(dto);
				dto.setArea(d.getArea());
				dto.setDealAmount(d.getDealAmount());
				System.out.println(dto.toString());
			}
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping(value = "/searchApt")
	public ResponseEntity<List<HouseInfoDto>> getAptInName(String aptName) {
		try {
			System.out.println("search apt click");
			List<HouseInfoDto> list = houseService.getAptInAptName(aptName);
			return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
}
