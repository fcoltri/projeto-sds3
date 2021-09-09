package br.com.treswxsolutions.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treswxsolutions.dsvendas.dto.SellerDTO;
import br.com.treswxsolutions.dsvendas.entities.Seller;
import br.com.treswxsolutions.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	
	public List<SellerDTO> findAll(){
		List<Seller> result = repository.findAll();
		return result.stream().map(x-> new SellerDTO(x)).collect(Collectors.toList());
	}


}
