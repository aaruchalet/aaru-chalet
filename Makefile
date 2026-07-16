.PHONY: \
	mysql-up mysql-down mysql-start mysql-stop mysql-restart mysql-reset mysql-logs mysql-shell \
	mysql-temp-up mysql-temp-down mysql-temp-start mysql-temp-stop mysql-temp-restart mysql-temp-reset mysql-temp-logs mysql-temp-shell \
	app-up app-down app-start app-stop app-restart app-build app-logs \
	jenkins-up jenkins-down jenkins-start jenkins-stop jenkins-restart jenkins-reset jenkins-logs \
	stack-up stack-down stack-reset stack-status \
	build clean run-dev run-qa

##################################################
# MySQL (Persistent)
##################################################

mysql-up:
	docker compose -p chalet --profile persistent up --build -d mysql

mysql-down:
	docker compose -p chalet stop mysql

mysql-start:
	docker compose -p chalet start mysql

mysql-stop:
	docker compose -p chalet stop mysql

mysql-restart:
	docker compose -p chalet restart mysql

mysql-reset:
	docker compose -p chalet --profile persistent down -v

mysql-logs:
	docker compose -p chalet logs -f mysql

mysql-shell:
	docker exec -it chalet-mysql mysql -uroot -proot chalet_db

##################################################
# MySQL (Temporary)
##################################################

mysql-temp-up:
	docker compose -p chalet --profile temp up --build -d mysql-temp

mysql-temp-down:
	docker compose -p chalet stop mysql-temp

mysql-temp-start:
	docker compose -p chalet start mysql-temp

mysql-temp-stop:
	docker compose -p chalet stop mysql-temp

mysql-temp-restart:
	docker compose -p chalet restart mysql-temp

mysql-temp-reset:
	docker compose -p chalet --profile temp down

mysql-temp-logs:
	docker compose -p chalet logs -f mysql-temp

mysql-temp-shell:
	docker exec -it chalet-mysql-temp mysql -uroot -proot chalet_db_tmp

##################################################
# Spring Boot Application
##################################################

app-up:
	docker compose -p chalet --profile persistent up --build -d aaru-chalet

app-down:
	docker compose -p chalet stop aaru-chalet

app-start:
	docker compose -p chalet start aaru-chalet

app-stop:
	docker compose -p chalet stop aaru-chalet

app-restart:
	docker compose -p chalet restart aaru-chalet

app-build:
	docker compose -p chalet build aaru-chalet

app-logs:
	docker compose -p chalet logs -f aaru-chalet

##################################################
# Jenkins
##################################################

jenkins-up:
	docker compose -p chalet --profile ci up -d jenkins

jenkins-down:
	docker compose -p chalet stop jenkins

jenkins-start:
	docker compose -p chalet start jenkins

jenkins-stop:
	docker compose -p chalet stop jenkins

jenkins-restart:
	docker compose -p chalet restart jenkins

jenkins-reset:
	docker compose -p chalet --profile ci down -v

jenkins-logs:
	docker compose -p chalet logs -f jenkins

##################################################
# Complete Stack
##################################################

stack-up:
	docker compose -p chalet --profile persistent --profile ci up --build -d

stack-down:
	docker compose -p chalet down

stack-reset:
	docker compose -p chalet down -v

stack-status:
	docker compose -p chalet ps

##################################################
# Gradle
##################################################

clean:
	./gradlew clean

build:
	./gradlew clean build

run-dev:
	./gradlew bootRun --args='--spring.profiles.active=dev'

run-qa:
	./gradlew bootRun --args='--spring.profiles.active=qa'