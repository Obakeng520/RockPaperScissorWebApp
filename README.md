Rock Paper Scissors Web App (WeDoWebApps)
A Java EE web application that allows users to play Rock-Paper-Scissors against the computer (named "Siri"), track game statistics in real-time within a session, and persist game history to a database using Enterprise JavaBeans (EJB).

📋 Project Overview
The project is structured into two main modules to separate business logic from the web presentation layer:

WeDoWebAppsEJBModule (Backend): Handles business logic, game rules, and database interactions (JPA).

WeDoWebApps (Frontend): Handles the user interface (JSP/HTML) and HTTP requests (Servlets).

🚀 Features
User Sessions: Users start by entering their name and ID to initialize a game session.

Game Logic:

Computer Opponent ("Siri"): Randomly selects Rock, Paper, or Scissor.

Win/Loss Detection: Automatically determines the winner based on standard rules (Rock crushes Scissors, Scissors cuts Paper, Paper covers Rock).

Statistics Tracking:

Tracks the total number of games played.

Counts wins for the player, wins for Siri, and ties.

Maintains a history of moves made by both the player and Siri.

Persistence: Saves the complete game session statistics to a database.

Reporting:

View statistics for all played games.

View statistics for specific players.

Filter players who have won more games than the computer.

📂 Project Structure
1. WeDoWebAppsEJBModule (EJB Layer)
za.ac.tut.entities.Game: JPA Entity representing a game session stored in the database.

Attributes: id, name, numGames, numGamesWonBySiri, numGamesWonByPlayer, numGamesEndedTie.

Lists: Stores the history of moves (listSiri, listPlayer) as @ElementCollection.

za.ac.tut.ejb.bl.GameFacade: Stateless Session Bean containing the business logic.

generateSign(): Returns a random move (Rock, Paper, or Scissor).

determineOutcome(user, computer): Compares moves and returns "won", "lost", or "tie".

viewAllGameStatistics(): Retrieves all game records.

viewPlayersWon(): Retrieves players who beat the computer.

2. WeDoWebApps (Web Layer)
StartSessionServlet: Initializes the HttpSession attributes (counters set to 0, empty lists).

PlayServlet:

Captures the user's move.

Calls the EJB to get the computer's move and determine the result.

Updates the session counters (wins/losses/ties).

Forwards the result to outcome.jsp.

ViewAllGameStatisticsServlet: Fetches database records via the EJB and forwards them to the view.

🛠️ Setup & Deployment
Prerequisites:

JDK 8 or higher.

GlassFish / Payara Application Server.

Relational Database (e.g., Derby, MySQL) configured with the JNDI name WeDoWebAppsEJBModulePU.

Database Configuration:

Ensure your persistence.xml points to a valid JDBC data source.

Build & Run:

Build the EJB Module JAR.

Build the Web Application WAR (referencing the EJB JAR).

Deploy the WAR file to your application server.

Navigate to the context root
