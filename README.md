# Installation :
git clone https://github.com/BorisLegros/learningCampus.git
cd wacdo

fichier .env necessaire :

DB_HOST=

DB_PORT=

DB_DATABASE=

DB_USER=

DB_PASSWORD=

DB_URL=jdbc:mysql

MYSQL_ROOT_PASSWORD=

JWT_SECRET=

JWT_EXPIRATION=86400000

# Lancement :

Attention necessite docker

### construire les images
docker compose up --build
### demarrer les services
docker compose up
### voir les logs
docker compose logs -f

docker compose logs -f backend

docker compose logs -f frontend

docker compose logs -f mysql
### arreter les services
docker compose down
### supprimer les services
docker compose down -v

# Accéder à l'application
Frontend (Vue.js) : http://localhost:5173
Backend (Spring Boot) : http://localhost:8080
MySQL : localhost:3307

