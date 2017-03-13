#Projet Master 2 SIRES TestPsycho
#Développement Web

Clients : <br>
- Professeur et Chercheur Cyrille Bertelle. <br>
- Docteur Sophie BAUDIC. <br>

##Développement d’un serveur de tests psychologiques.<br>
Dans le cadre d’une collaboration avec une neuro-psychologue spécialisée dans le traitement  de la douleur, il est proposé de développer un serveur web de tests psychologiques servant à diagnostiquer les effets de concentration liés au traitement de la douleur. Les test demandés soont sous forme d'affichage d'images, de caractères ou de symboles avec réaction attendu de l’utilisateur via son clavier.<br>

Le but est de développer un petit serveur web qui est à destination de 2 catégories d’usagers : des patients qui seront sollicités par un médecin afin de réaliser certains tests et les médecins afin qu’ils récupèrent des analyses statistiques de leur patient. Le dispositif doit pouvoir marcher en local sur une machine sans connexion au réseau. Il doit aussi pouvoir être déployé sur un site web. Le codage des applications doit être facilement accessible pour pouvoir être modifié ou adapté. L’implémentation de nouveaux tests doit être accessible en s’inspirant des applications déjà développées. On pourra penser à développer une bibliothèque de composants logiciels rendant les développements futurs simplifier.<br>

# Conception détaillée:
Pour la conception on va utilisé l’UML (Undified Modeling Language), En utilisant deux diagrammes:
- Diagramme de cas d’utilisation.
- Diagrammes de classes.<br>

## 1) Diagramme de cas d’utilisation<br>
L’objectif fondamental de cette étape est d’identifier et repérer les principaux données et cas d’utilisation.<br>
Nous nous intéressons donc, dans cette partie, à la réalisation du diagramme des cas d’utilisations des données. Ce diagramme décrit précisément les besoins d’utilisateur final.<br>

### Présentation des acteurs:<br>
- Avant d’étudier les cas d’utilisation nous commençons par la recherche des acteurs qui régissent notre champ d’étude.
- Nous avons défini deux acteurs : le médecin qui sera administrateur et le patient.<br>

#### Diagramme de cas d'utilisations:
![1utilisationdiagram](https://cloud.githubusercontent.com/assets/22649502/23113183/9e3dc3c2-f736-11e6-928b-d995f51cdf1c.jpg)<br>

#### Diagramme de classes:
![2classdiagram](https://cloud.githubusercontent.com/assets/22649502/23113272/570c0724-f737-11e6-9d8c-b52a8050cf0a.jpg)<br>

# 2) Matrice de traçabilité:
### Besoins fonctionnels:
![1](https://cloud.githubusercontent.com/assets/22649502/23113395/17cdcc22-f738-11e6-8120-9a12195d80d6.png)<br>
### Besoins non fonctionnels:
![2](https://cloud.githubusercontent.com/assets/22649502/23113449/79aab0d6-f738-11e6-9f4d-a7a064462e2a.png)<br>

# 3) Demo:<br>
## Interface d'acceuil:<br>
![1](https://cloud.githubusercontent.com/assets/22649502/23112585/9eefda12-f731-11e6-8391-61f881842355.png)<br>
## Tableau de bord du medecin:<br>
![2](https://cloud.githubusercontent.com/assets/22649502/23839598/8171cbde-079f-11e7-9fe7-ed59fe4f6d24.png)
## Interface d'ajout d'un paient par un medecin:<br>
![3](https://cloud.githubusercontent.com/assets/22649502/23112659/3db83eaa-f732-11e6-9304-244d49ca5168.png)<br>

## Tableau de bord du patient:<br>
![1](https://cloud.githubusercontent.com/assets/22649502/23839639/cfd56772-079f-11e7-9315-08a586c10f9b.png)<br>
## Départ d'un exemple de test de rotation:<br>
![5](https://cloud.githubusercontent.com/assets/22649502/23112726/e0451e40-f732-11e6-9a63-064def8dba75.png)<br>
![6](https://cloud.githubusercontent.com/assets/22649502/23112763/2f2194da-f733-11e6-9ba4-96d25a7e8454.png)<br>
![7](https://cloud.githubusercontent.com/assets/22649502/23112801/84e3ca00-f733-11e6-9233-1b330b0f7bc2.png)<br>
## Lors de la fin d'un test (Affichage du pourcentage et temps moyen par puzzle):<br>
![3](https://cloud.githubusercontent.com/assets/22649502/23112949/dc811960-f734-11e6-9e76-9ab2a20afad3.png)<br>
## Exemple de résulats de test:<br>
![4](https://cloud.githubusercontent.com/assets/22649502/23112824/ae37b8da-f733-11e6-84cc-6b4218172054.png)<br>

