package com.dihardmg.kayrawanapp.controller;


import com.dihardmg.kayrawanapp.dao.SiswaDao;
import com.dihardmg.kayrawanapp.entity.Karyawan;
import com.dihardmg.kayrawanapp.entity.Siswa;

import ch.qos.logback.classic.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author : Otorus
 * @since : 1/4/18
 */
@Controller
public class SiswaController {
    @Autowired
    private SiswaDao siswaDao;


    @GetMapping("/siswa/list")
    public ModelMap karyawan(@PageableDefault(size = 5) Pageable pageable, @RequestParam(name = "value", required = false) String value, Model model){
        if (value != null) {
            model.addAttribute("key", value);
            return new ModelMap().addAttribute("siswa", siswaDao.findByNisContainingIgnoreCaseOrNamaContainingIgnoreCase(value, value, pageable));  
        } else {
            return new ModelMap().addAttribute("siswa", siswaDao.findAll(pageable));
        }
        
    }

    @GetMapping("/siswa/form")
    public ModelMap tampilkanForm(@RequestParam(value = "id", required = false) Siswa s ) {
        if (s == null) {
            s = new Siswa();
        }
        return new ModelMap("siswa", s);
    }


    @PostMapping("/siswa/form")
    public String simpan(@Valid @ModelAttribute("siswa") Siswa siswa , BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "siswa/form";

        }
        siswaDao.save(siswa);
        status.setComplete();
        return "redirect:/siswa/list";
    }



    @GetMapping("/siswa/delete")
    public String deleteConfirm(@RequestParam(value = "id", required = true) Siswa siswa ) {
    	java.util.logging.Logger.global.info("DELETE>><<<"+siswa.getNis());
    	java.util.logging.Logger.global.info("ID>><<<"+siswa);
    	java.util.logging.Logger.global.info("DELETE>><<<"+siswa.getNama());
    	
    	 siswaDao.delete(siswa);
    	 return "redirect:/siswa/list";
    }
    @GetMapping("/siswa/detail")
    public ModelMap detail(@RequestParam(value = "id", required = true)Siswa siswa) {
    	
    	 return new ModelMap("siswa", siswaDao.findOne(siswa.getNis()));
    }
  /*  @GetMapping("/employee/{id}/edit")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("employee", siswaDao.findOne(id));
		return "form";
	} */
    @PostMapping("/siswa/delete")
    public String delete(@ModelAttribute Siswa siswa , SessionStatus status) {
    	java.util.logging.Logger.global.info("SISWA>><<<"+siswa.getNis());
    	java.util.logging.Logger.global.info("SISWA>><<<"+siswa.getNama());
    	java.util.logging.Logger.global.info("SISWA>><<<"+status);
    	try{

            siswaDao.delete(siswa);
        } catch (DataIntegrityViolationException exception) {
            status.setComplete();
      /*      return new ModelAndView("error/errorHapus")
                    .addObject("entityId", siswa.getNis())
                    .addObject("entityName", "siswa")
                    .addObject("errorCause", exception.getRootCause().getMessage())
                    .addObject("backLink","/siswa/list"); */
        } 
        status.setComplete();
        return "redirect:/siswa/list";
    }

}


