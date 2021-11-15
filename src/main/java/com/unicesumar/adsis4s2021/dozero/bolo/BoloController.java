package com.unicesumar.adsis4s2021.dozero.bolo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicesumar.adsis4s2021.dozero.base.BaseCrudController;

@RestController
@RequestMapping("/api/bolos")
public class BoloController extends BaseCrudController<Bolo, BoloRepository, BoloService> {

}
