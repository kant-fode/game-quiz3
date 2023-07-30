package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.ApiResponse;
import com.quiz3.game3.quiz.repository.UtilisateurRepository;
import com.quiz3.game3.quiz.modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Définition d'un service pour gérer les utilisateurs
@Service
public class Utilisateurservice {
    // Injection de dépendance pour accéder aux opérations de la base de données relatives aux utilisateurs
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Méthode pour créer un nouvel utilisateur en base de données

    public Utilisateur inscrire(Utilisateur utilisateur) {
        
        return utilisateurRepository.save(utilisateur);
    }

    // Méthode pour récupérer la liste de tous les utilisateurs enregistrés en base de données
    public List<Utilisateur> lire() {
        
        return utilisateurRepository.findAll();
    }

    // Méthode pour mettre à jour les informations d'un utilisateur existant en base de données
    public Utilisateur modifier(Long id, Utilisateur utilisateur) {

        return utilisateurRepository.findById(id).map(u -> {
            u.setPseudo(utilisateur.getPseudo());
            u.setEmail(utilisateur.getEmail());
            u.setQuizCreer(utilisateur.getQuizCreer());
            u.setPassword(utilisateur.getPassword());

            return utilisateurRepository.save(u);
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    // Méthode pour supprimer un utilisateur en utilisant son identifiant
    public String supprimer(Long id) {
        utilisateurRepository.deleteById(id);
        return "Suppréssion effectuer ! ";

    }
    // Méthode pour gérer l'authentification d'un utilisateur
    public ApiResponse connecter(String email, String password) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur == null) {
            return new ApiResponse(200, "Email incorrect" +
                    "!!!", null);
        }
        if (!utilisateur.getPassword().equals(password)) {
            return new ApiResponse(200, "mot de passe incorrect!", null);
        }
        return new ApiResponse(200, "Login success", utilisateur);



    }


    public Utilisateur getUtilisateurById(Long utilisateurId) {
        return utilisateurRepository.findById((utilisateurId)).get();
    }

    public Utilisateur findUtilisateurById(long userId) {
        return  utilisateurRepository.findById((userId)).get();
    }
}
