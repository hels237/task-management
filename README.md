# Application de Gestion des Tâches

API REST développée avec **Spring Boot** pour la gestion des tâches. Chaque tâche contient un titre, une description, un responsable, une échéance, un statut et une priorité.

## Fonctionnalités

- Créer une nouvelle tâche
- Récupérer toutes les tâches
- Récupérer une tâche par ID
- Filtrer les tâches par statut (`A_FAIRE`, `EN_COURS`, `TERMINEE`)
- Modifier une tâche existante
- Supprimer une tâche

## Technologies utilisées

- Java 17
- Spring Boot 3.4.3
- Spring Data JPA
- PostgreSQL
- MapStruct
- Lombok
- SpringDoc OpenAPI 3 (Swagger)

## Configuration et démarrage

### 1. Prérequis
- Java 17+
- PostgreSQL
- Base de données `gestion_des_taches`

### 2. Configuration
Dans `application.properties` :
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_des_taches
spring.datasource.username=hels
spring.datasource.password=hels
```

### 3. Démarrer l'application
```bash
cd "Gestion des tâches"
./mvnw spring-boot:run
```

## API Endpoints

**Base URL** : `http://localhost:8080/api/taches`

**Documentation Swagger** : `http://localhost:8080/swagger-ui.html`

## Exemples d'utilisation

### Créer une tâche
```http
POST /api/taches
Content-Type: application/json

{
  "titre": "Préparer la présentation",
  "description": "Créer les slides pour la présentation client",
  "statut": "EN_COURS",
  "priorite": "MOYENNE",
  "responsable": "Alice",
  "dateEcheance": "2025-04-17"
}
```

### Récupérer toutes les tâches
```http
GET /api/taches
```

### Récupérer une tâche par ID
```http
GET /api/taches/{id}
```

### Filtrer par statut
```http
GET /api/taches/statut/EN_COURS
```

### Modifier une tâche
```http
PUT /api/taches/{id}
Content-Type: application/json

{
  "titre": "Titre modifié",
  "description": "Description modifiée",
  "statut": "TERMINEE",
  "priorite": "HAUTE",
  "responsable": "Alice",
  "dateEcheance": "2025-04-17"
}
```

### Supprimer une tâche
```http
DELETE /api/taches/{id}
```
