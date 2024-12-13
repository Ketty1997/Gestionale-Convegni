package com.example.demo.dto.builder;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.IscrittiDto;
import com.example.demo.model.Iscritti;

public class IscrittiDtoBuilder {
	public static Iscritti participantsFromDtoToEntity (IscrittiDto iDto) {
		Iscritti i = new Iscritti ();
		i.setId(iDto.getId());
		i.setOrganizationName(iDto.getOrganizationName());
		i.setName(iDto.getName());
		i.setSurname(iDto.getSurname());
		i.setRole(iDto.getRole());
		i.setNumber(iDto.getNumber());
		i.setAddress(iDto.getAddress());
		i.setEmail(iDto.getEmail());
		return i;
	}
	public static List <IscrittiDto> participantsFromEntityToDto (List <Iscritti> participants){
		List<IscrittiDto> participantsDto = new ArrayList<>();
		for(Iscritti i : participants) {
			participantsDto.add(participantsFromEntitytoDto(i));
		}
		return participantsDto;
	}
	public static IscrittiDto participantsFromEntitytoDto(Iscritti i) {
		IscrittiDto iDto = new IscrittiDto ();
		iDto.setId(i.getId());
		iDto.setOrganizationName(i.getOrganizationName());
		iDto.setName(i.getName());
		iDto.setSurname(i.getSurname());
		iDto.setRole(i.getRole());
		iDto.setNumber(i.getNumber());
		iDto.setAddress(i.getAddress());
		iDto.setEmail(i.getEmail());
		return iDto;
		
	}
}
