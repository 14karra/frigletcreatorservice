# Figlet Creator Service

## Using `docker run` command
### Initialize DBMS
Get started by initializing the PostgreSQL SGBD and PGAdmin containers (pay attention to PostgreSQL localhost port `5433`).
<br>
With Docker installed and the docker engine turned on, open a command line and type:
<br>
`docker network create -d bridge figlet-network`
<br>
`docker run -dit --name postgres -p 5433:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=FIGLET_DB postgres`
<br>
`docker network connect figlet-network postgres`
<br>
`docker run -dit --name pgAdmin -p 5431:80 -e PGADMIN_DEFAULT_EMAIL=johndoe@mail.com -e PGADMIN_DEFAULT_PASSWORD=pgadmin4 dpage/pgadmin4`
<br>

### Create database
Open PGAdmin GUI in your browser at http://localhost:5431 and log in with credentials:<br>
username: `johndoe@mail.com`<br>username: `pgadmin4`
<br>
If not existing, create a database named `FIGLET_DB` with default username and password `postgres`.
<br>
You're ready to execute this program.

### Initialize Figlet Creator Service
Open a terminal and type:
<br>`docker run -dit --name figletcreatorservice --link postgres --net figlet-network -p 9005:9005 14karra/figletcreatorservice`
<br>
Figlet Creator Service is running on port `9005`.
<br>
- You can create a Figlet by sending a POST request at `http://localhost:9005/api/v1` with a message as body.
<br>
- You can get all saved Figlets by sending a GET request at `http://localhost:9005/api/v1`. As expected, the JSON list is not suitable for direct printing.  

## Using `docker-compose up -d`
Alternatively, you could make use of the `docker-compose.yml` file provided within the project folder.
<br>
Type the following command: `docker-compose up -d`
