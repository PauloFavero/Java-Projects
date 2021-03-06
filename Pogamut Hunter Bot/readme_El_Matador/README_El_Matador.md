# Hunter Bot - Pogamut

Ce projet consiste à concevoir et à programmer un Personnage Non Joueur (Bot) pour le jeux Unreal Tournament 2004 en utilisant la bibliothèque Pogamut.
Le point de départ était le projet Maven *HunterBot* de la bibliothèque citée.
A l'origine, il n'existait qu'une seule classe *HunterBot* qui possède tous les attributs et méthodes faisant partie de la dynamique du bot.


## Pour Commencer

Pour lancer le bot dans les ordinateurs de la salle B005, il faut juste suivre les instructions presentes au moodle du module *IAS*.

Les instructions pour l'instalation dans une machine personnel se trouvent dans le prerequisites.

### Prerequisites d'installations

Tous les itens suivantes, sont necessaires pour l'installations dans une machine personnel. Un tutoriel de l'installation se trouve dans la documentation [Pogamut](http://pogamut.cuni.cz/main/tiki-view_blog_post.php?postId=47)

* Item [Java JDK 1.7](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* Item [Maven](https://maven.apache.org/)
* Item NetBeans 7.4
* Item [Unreal Tournament 2004](https://store.steampowered.com/app/13230/Unreal_Tournament_2004_Editors_Choice_Edition/)
* Item [Pogamut](http://pogamut.cuni.cz/main/tiki-index.php) 

## Implementation

Dans cette section, nous expliquerons comment a été le développement de notre projet.

### Rempliment d'exigences minimales

L'automate à états qui nous avons developpé ce trouve ci-dessous.

<img src="https://github.com/PauloFavero/Java-Projects/blob/master/Bot_States.png" width="400" height="400" />

Chaque état possède ses respectives transitions de sortie organisé par ordre de priorité.

L'exemple ci-dessous, nous montre les transitions associé à l'état *Attack*. 

```java
    public AttackState() {
        transitions = new Transition[4];
        transitions[0] = new TransitionToPursue();
        transitions[1] = new TransitionToHurted();
        transitions[2] = new TransitionToAttack();
        transitions[3] = new TransitionToSearch();
    }
```

La machine à états a pour rôle de verifier le transitions qui appartient à l'état actuel et à changer d'état si la condition pour la transition est vrai. Cette verification est effectué par la methode *execute* de la machine à état.

```java
public void execute(HunterBot Bot) {
        for(int i = 0; i < this.currentState.getTransitions().length; i++){
            HunterState hs = this.currentState.getTransitions()[i].transition(Bot);
            if(hs != null){
                this.currentState = hs;
                break;
            }
        }
    }
 ```
 La structure ci-dessus nous permet à facilement d'ajouter de transitions et états au fur et à mesure. Il suffit juste d'ajouter des transitions si necessaire à un état correspondant.

### Diagramme de classes du bot

Nous nous asservissons du patron de conception *[State](https://sourcemaking.com/design_patterns/state)* et en plus d'une interface pour gerer les transitions. 

L'image ci-dessous exemplifique notre patron de conception que fait notre bot tourner. 

<img src="https://github.com/PauloFavero/Java-Projects/blob/master/Pogamut%20Hunter%20Bot/readme_El_Matador/Bot_UML.png" width="400" height="400" />

### Améliorations

Au début, nous avons créé un état supplementaire nommé *SwitchBestWeapon*. Cet état a pour rôle de donner au bot le savoir de choisir la meilleur arme parmi les deux classes d'armes: \textit{Range} et \textit{Melee}.

Dès qu'il aperçoit l'ennemie, il calcule la distance pour savoir déterminer la meilleur classe d'arme en rapport à la distance. Une fois qu'il a choisi la classe, le changement se donne de façon aléatoire.

Au bout dans moment, nous avons rendu compte qu'il avait déjà une méthode dans le bot qui travaille pour trouver la meilleur arme dans le moment du tir. Ce choix est fait basé sur des préferences d'arme avec un rapport de distance au moment de la création du bot.

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Pogamut](http://pogamut.cuni.cz/main/tiki-index.php) - Java Middleware to control virtual agents

## Auteurs: 

* **Helon Moreira**

* **Paulo Henrique Favero Pereira**

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

