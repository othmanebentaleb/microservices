package com.ms.gestionEtudiant.msgestionEtudiant;

import com.ms.gestionEtudiant.msgestionEtudiant.dao.EtudiantRepository;
import com.ms.gestionEtudiant.msgestionEtudiant.dao.FormationRepository;
import com.ms.gestionEtudiant.msgestionEtudiant.modele.Etudiant;
import com.ms.gestionEtudiant.msgestionEtudiant.modele.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MsGestionEtudiantApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private FormationRepository formationRepository;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MsGestionEtudiantApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Formation.class,Etudiant.class);
		Formation f1 = 	formationRepository.save(new Formation(null,"Java",30,null));
		Formation f2 =	formationRepository.save(new Formation(null,"PHP",30,null));


		etudiantRepository.save( new Etudiant(null,"Bentaleb","Othmane",new Date(),f1));
		etudiantRepository.save( new Etudiant(null,"Bentaleb","Othmane",new Date(),f2));
		etudiantRepository.save( new Etudiant(null,"Bentqsdeb","Othmane",new Date(),f1));
		etudiantRepository.save( new Etudiant(null,"Bentaleb","Othmane",new Date(),f2));
		etudiantRepository.save( new Etudiant(null,"Bentaleb","Othmane",new Date(),f1));
	}
}
