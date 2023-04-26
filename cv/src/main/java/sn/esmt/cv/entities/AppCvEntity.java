//Entitiies les entitÃ©s sont des objets qui reprÃ©sentent des tables dans une base de donnÃ©es.
// les entitÃ©s sont souvent utilisÃ©es en conjonction avec les DAO pour accÃ©der Ã  des donnÃ©es.
package sn.esmt.cv.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//?
@Entity
@Table(name="appcvs")
public class AppCvEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100,nullable = false)
    private String nom;
    @Column(length = 100,nullable = false)
    private String prenom;
    @Column(length = 50,nullable = false)
    private String age;
    @Column(length = 200,nullable = false,unique = true)
    private String adresse;
    @Column(length = 200,nullable = false,unique = true)
    private String email;
    @Column(length = 50,nullable = false)
    private String telephone;
    @Column(length = 150,nullable = false)
    private String specialite;
    @Column(length = 200,nullable = false)
    private String niveauEtude;
    @Column(length = 200,nullable = false)
    private String experienceProfessionnelle;


}
