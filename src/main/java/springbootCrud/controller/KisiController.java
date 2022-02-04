package springbootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootCrud.model.Kisi;
import springbootCrud.service.KisiService;

@RestController 				// cok method calistirdigimiz icn ana kontrol i cagirdik
public class KisiController {
	
	public KisiService kisiService;
	
	
	@Autowired
	public KisiController(KisiService kisiService) {
		this.kisiService=kisiService;
	}
	
	// bu bir get işlemi old için requestmapping (bütün mappingleri kaplayan anotasyon)
	//değilde get işlemine özel olan @GetMapping anotasyonunu kullandık
	@GetMapping(path = "/kisiler") 			//bu bir get islemi oldugu icin hepsini kapsamasi icin requestmapping yerine yazdik
	public List<Kisi> fetchPerson(){	
		return kisiService.tumKisileriGetir();
	}
	
	
	@PostMapping(path = "kisiler/ekle")
	public Kisi addPerson(@RequestBody Kisi kisi) {	 	// @RequestBody model de olusan toplu bir veri geliyor
		return kisiService.kisiEkle(kisi);
	}
	
	
	@DeleteMapping(path = "kisiler/sil/{id}") 			// frontend e id girerek sil butonunu basmak ile ayni
	public String deletePersonWithId(@PathVariable Integer id) {		
		return kisiService.idIleKisiSil(id);
	}
	
	
	@PutMapping(path = "/kisiler/guncelle")
	public Kisi updatePerson(@RequestBody  Kisi yeniKisi) {
		
		return kisiService.kisiGuncelle(yeniKisi);
	}
	
	@PatchMapping(path = "/kisiler/yenile/{id}")
	public Kisi yamaYapma(@PathVariable Integer id, @RequestBody Kisi updateKisi ) {
		
		return kisiService.idIleKisiGuncelle(id, updateKisi);
	}
	
	

}
