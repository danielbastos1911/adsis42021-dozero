package com.unicesumar.adsis4s2021.dozero.bolo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.unicesumar.adsis4s2021.dozero.base.BaseCrudService;

@Service
@Transactional
public class BoloService extends BaseCrudService<Bolo, BoloRepository> {

}
