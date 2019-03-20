package com.andrzej.cake.service;

import com.andrzej.cake.entity.CakeEntity;
import com.andrzej.cake.repository.CakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation od @CakeService interface.
 *
 *@see CakeService
 */
@Service
public class CakeServiceImpl implements CakeService{
	//The implementation of CakeService interface shouldn't be named as ...Impl it's only for this code sample

	private CakeRepository cakeRepository;

	/**
	 * Default constructor for initializing the service.
	 *
	 * @param cakeRepository cake repository
	 */
	@Autowired
	public CakeServiceImpl(CakeRepository cakeRepository) {
		this.cakeRepository = cakeRepository;
	}

	@Override
	public List<CakeEntity> getCakes() {
		final List<CakeEntity> result = new ArrayList<>();
		cakeRepository.findAll().forEach(result::add);
		return result;
	}

	@Override
	public CakeEntity getCake(@NonNull final Long id) {
		return cakeRepository.findById(id).get();
	}

	@Override
	public CakeEntity addCake(@NonNull final String title, @NonNull final String description, @NonNull final String imageUrl) {
		return cakeRepository.save(new CakeEntity(title, description, imageUrl));
	}
}
