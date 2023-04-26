//DAO signifie "Data Access Object"
//utilisÃ© pour accÃ©der Ã  des donnÃ©es stockÃ©es dans une base de donnÃ©es.
package sn.esmt.cv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.cv.entities.AppCvEntity;


//cette annotation marque la classe AppCvRepository comme etant un composant de la couche DAO.
@Repository
//l'interface AppCvRepository qui etend la classe JpaRepository
public interface AppCvRepository extends JpaRepository<AppCvEntity,Integer> {
    AppCvEntity findByNom(String nom);
    AppCvEntity findByEmailAndPrenom(String email, String prenom);

}

