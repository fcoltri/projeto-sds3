package br.com.treswxsolutions.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.treswxsolutions.dsvendas.dto.SaleDTO;
import br.com.treswxsolutions.dsvendas.dto.SaleSuccessDTO;
import br.com.treswxsolutions.dsvendas.dto.SaleSumDTO;
import br.com.treswxsolutions.dsvendas.entities.Sale;
import br.com.treswxsolutions.dsvendas.repositories.SaleRepository;
import br.com.treswxsolutions.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupeBySeller(){
		return repository.amountGroupeBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupeBySeller(){
		return repository.successGroupeBySeller();
	}
	
	

}
