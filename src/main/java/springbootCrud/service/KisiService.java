package springbootCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import springbootCrud.model.Kisi;
import springbootCrud.repository.KisiRepository;

@Service
public class KisiService {

	public static KisiRepository kisiRepository;

	// Dependency Injection bunu yapmayıp klasik yöntemle çağırsaydık birbirine sıkı
	// sıkı bağlı olacaktı, birinin
	// ömrü ötekine bağlı oluyor,biri oluşmadan diğeri oluşturulamıyor ve kolay
	// ayrılmıyor
	@Autowired // Spring buna ihtiyaç duyduğunda (çalıştırıldığında), oluşturuyor, alttaki
				// tetiklenmeden boşuna çalışmasın diye.
	public KisiService(KisiRepository kisiRepo) {
		// KisiService.kisiRepository=kisiRepo; --> seklinde de yazabiliriz
		kisiRepository = kisiRepo;

	}

	// veritabanina kisi ekleyen servis methodu
	public Kisi kisiEkle(Kisi kisi) {

		return kisiRepository.save(kisi); // repos. jpa sayesinde database e kisi verileri kaydoldu
	}

	// database'den tum listeyi getir
	public List<Kisi> tumKisileriGetir() {

		return kisiRepository.findAll();
	}

	// id ile kisi silme

	public String idIleKisiSil(Integer id) {

		if (kisiRepository.findById(id) == null) {
			throw new EmptyResultDataAccessException(id);
		}

		kisiRepository.deleteById(id);

		return id + " id'li kisi silindi";
	}

//	PUT 
// 	PUT , kaynağın var olup olmadığını kontrol etmek içindir, ardından güncellemek ,
// 	aksi takdirde yeni kaynak oluşturmak içindir. PATCH her zaman sadece bir kaynağı güncellemek içindir.
// 	PUT için, json dizisine id belirterek yazarız, bu id li kişi yoksa yenisini oluşturur,
//  id belirtmezsek kendi sıradaki id ile yeni oluşturur,sadece ismini yeni verirsek diğer documentler null yada 0 gelir.
//  "id":77,
//	"ad": "xxx",
//	"soyad": "ver",
//	"yas": 66}

	public Kisi kisiGuncelle(Kisi guncelKisi) {

		return kisiRepository.save(guncelKisi);
	}

//	PATCH= bir kişinin istediğiniz field ını değiştirir, metodu yazarken kişiyi id si ile seçeriz belirtiriz

	public Kisi idIleKisiGuncelle(Integer id, Kisi YamaliKisi) {

		Kisi oldPerson = kisiRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(id + " kisi bulunamadi"));

		if (YamaliKisi.getAd() != null) {
			oldPerson.setAd(YamaliKisi.getAd());
		}
		
		if (YamaliKisi.getSoyad() != null) {
			oldPerson.setSoyad(YamaliKisi.getSoyad());
		}
		
		if (YamaliKisi.getYas() != 0) {
			oldPerson.setYas(YamaliKisi.getYas());
		}
		
		return kisiRepository.save(oldPerson) ;
	}

}
