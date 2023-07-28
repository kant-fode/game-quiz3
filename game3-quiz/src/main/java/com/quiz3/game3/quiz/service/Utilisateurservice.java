package com.quiz3.game3.quiz.service;

import com.quiz3.game3.quiz.ApiResponse;
import com.quiz3.game3.quiz.repository.Utilisateurdao_user;
import com.quiz3.game3.quiz.modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// Définition d'un service pour gérer les utilisateurs
@Service
public class Utilisateurservice {
    // Injection de dépendance pour accéder aux opérations de la base de données relatives aux utilisateurs
    @Autowired
    private Utilisateurdao_user utilisateurdaoUser;

    // Méthode pour créer un nouvel utilisateur en base de données

    public Utilisateur creer(Utilisateur user) {
        return utilisateurdaoUser.save(user);
    }

    // Méthode pour récupérer la liste de tous les utilisateurs enregistrés en base de données
    public List<Utilisateur> lire() {
        return utilisateurdaoUser.findAll();
    }

    // Méthode pour mettre à jour les informations d'un utilisateur existant en base de données
    public Utilisateur modifier(Long id, Utilisateur user) {

        return utilisateurdaoUser.findById(id).map(p -> {
            p.setPseudo(user.getPseudo());
            p.setEmail(user.getEmail());
            p.setQuizCrees(user.getQuizCrees());
            p.setPassword(user.getPassword());

            return utilisateurdaoUser.save(p);
        }).orElseThrow(() -> new RuntimeException("Utilisateur pas trouvé"));
    }

    // Méthode pour supprimer un utilisateur en utilisant son identifiant
    public String supprimer(Long id) {
        utilisateurdaoUser.deleteById(id);
        return "Suppréssion effectuer ! ";

    }
    // Méthode pour gérer l'authentification d'un utilisateur
    public ApiResponse login(String email, String password) {
        Utilisateur user = utilisateurdaoUser.findByEmail(email);
        if (user == null) {
            return new ApiResponse(200, "Le couple mot de passe ne correspond pas!", null);
        }
        if (!user.getPassword().equals(password)) {
            return new ApiResponse(200, "Le couple mot de passe ne correspond pas!", null);
        }
        return new ApiResponse(200, "Login success", user);



    }


    public Utilisateur getUtilisateurById(Long utilisateurId) {
        return utilisateurdaoUser.findById(utilisateurId).get();
    }

    public Utilisateur findUtilisateurById(long userId) {
        return  utilisateurdaoUser.findById((userId)).get();
    }
}
