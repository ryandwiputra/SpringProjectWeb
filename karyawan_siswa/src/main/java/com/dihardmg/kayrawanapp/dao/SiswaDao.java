package com.dihardmg.kayrawanapp.dao;



import com.dihardmg.kayrawanapp.entity.Siswa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Otorus
 * @since : 1/4/18
 */
@Repository
public interface SiswaDao extends PagingAndSortingRepository<Siswa, String> {
	Page<Siswa>findByNisContainingIgnoreCaseOrNamaContainingIgnoreCase(String nis,String nama, Pageable pageable);
	Page<Siswa>findByNisContainingIgnoreCase(String nis, Pageable pageable);
}
