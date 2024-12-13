package com.example.demo.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.AmministratoriDto;

import com.example.demo.model.Amministratori;


public class AmministratoriDtoBuilder {
	public static Amministratori adminFromDtoToEntity(AmministratoriDto aDto) {
		Amministratori a = new Amministratori();
		a.setId(aDto.getId());
		a.setNameAdmin(aDto.getNameAdmin());
		a.setSurnameAdmin(aDto.getSurnameAdmin());
		a.setEmailAdmin(aDto.getEmailAdmin());
		a.setPassword(aDto.getPassword());
		return a;
	}
	public static List<AmministratoriDto> adminFromEntityToDto(List<Amministratori> admins){
		List<AmministratoriDto> adminsDto = new ArrayList<>();
		for (Amministratori a : admins) {
			adminsDto.add(adminFromEntitytoDto(a));
		}
		return adminsDto;
	}
	
	public static AmministratoriDto adminFromEntitytoDto (Amministratori a) {
		AmministratoriDto aDto = new AmministratoriDto();
		aDto.setId(a.getId());
		aDto.setNameAdmin(a.getNameAdmin());
		aDto.setSurnameAdmin(a.getSurnameAdmin());
		aDto.setEmailAdmin(a.getEmailAdmin());
		aDto.setPassword(a.getPassword());
		return aDto;
	}
}
