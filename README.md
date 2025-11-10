# 🎮 Java.rpg
A simple API-based game built for the IronHack Back-End course final project.

This project is a game built the following technologies:
- IntelliJ
- Java
- Spring Boot
- Maven
- MySQL
- Postman for testing

Players start by logging in with their credentials via Postman to receive an authentication token, which must be included in all subsequent requests.

Once authenticated, players can create their Avatar and begin their Journey.  
Throughout the journey, they will:
- Choose a Path, Virtue, Dominion, and a Weapon
- Prepare for battle against enemies associated with the chosen Dominion

When the battle begins, the game randomly selects an enemy and calculates the damage dealt based on the player’s stats and choices.  
The outcome — victory or defeat — is determined dynamically through the API’s battle logic.

All interactions, from character creation to combat, are handled entirely through API endpoints, making it a fully back-end-driven adventure experience.

Endpoints for a normal use case:

|  Method   | Endpoint                   | Description                                                                   |
|:---------:|:---------------------------|:------------------------------------------------------------------------------|
| **POST**  | `/api/login`               | Logs in the player using credentials and returns an authentication token.     |
| **POST**  | `/avatar/create`           | Creates a new Avatar for the authenticated player.                            |
| **PATCH** | `/avatar/choose`           | Choose an avatar to play.                                                     |
|  **GET**  | `/journey/start`           | Begins the player's Journey.                                                  |
| **POST**  | `/journey/choose/dominion` | Sets the Dominion for the current journey.                                    |
| **POST**  | `/avatar/choose/path`      | Selects the Path for the current Avatar.                                      |
| **POST**  | `/avatar/choose/virtue`    | Chooses the current Avatar’s guiding Virtue.                                  |
| **POST**  | `/avatar/choose/weapon`    | Selects the Avatar’s Weapon for battle.                                       |
| **POST**  | `/journey/battle`          | Starts the battle against a randomly selected enemy from the chosen Dominion. |
