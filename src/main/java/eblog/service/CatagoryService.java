package eblog.service;

import java.util.List;

import eblog.dto.CatagoryDto;

public interface CatagoryService {

	CatagoryDto createCatagory(CatagoryDto dto);

	CatagoryDto getCatagory(int id);

	List<CatagoryDto> getAllCatagory();

	CatagoryDto updateCatagory(CatagoryDto dto, int id);

	void deleteCatagory(int id);
}
