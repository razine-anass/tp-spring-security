package org.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.opendevup.Dao.EtudiantRepository;
import org.opendevup.entitee.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		 
		ApplicationContext	ctx=SpringApplication.run(TpSpringMvcApplication.class, args);
		
		 EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
		 DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		 etudiantRepository.save(new Etudiant("ahmed","bodali",df.parse("1988-11-10")));
		 etudiantRepository.save(new Etudiant("hamo","bodali",df.parse("1988-11-10")));
		 etudiantRepository.save(new Etudiant("milod","bodali",df.parse("1988-11-10")));
		 etudiantRepository.save(new Etudiant("kassem","bodali",df.parse("1988-11-10")));
		 
		 @SuppressWarnings("deprecation")
			Page<Etudiant> etds =etudiantRepository.findAll(new PageRequest(0, 5));
			etds.forEach(e-> System.out.println(e.getNom()));
	}
}
