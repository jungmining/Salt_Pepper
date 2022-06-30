package com.min.edu.model;

import java.util.List;

import com.min.edu.vo.AnimalHospitalDto;

public interface IAnimalDao {
	public int animalHospitalInsert(List<AnimalHospitalDto> dto);
	public int animalHospitalDelete();

}
